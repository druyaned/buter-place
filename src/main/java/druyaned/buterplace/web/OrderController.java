package druyaned.buterplace.web;

import druyaned.buterplace.ButerOrder;
import druyaned.buterplace.ButerUser;
import druyaned.buterplace.data.OrderRepository;
import jakarta.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/orders")
@SessionAttributes("buterOrder")
public class OrderController {
    
    private final OrderRepository repo;
    
    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }
    
    @ModelAttribute(name = "buterUser")
    public ButerUser buterUser() {
        return (ButerUser)SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
    }
    
    @ModelAttribute(name = "buterOrder")
    public ButerOrder buterOrder() {
        return new ButerOrder();
    }
    
    @GetMapping public String orders() {
        return "error/404";
    }
    
    @GetMapping("/current")
    public String orderForm(ButerOrder buterOrder) {
        if (!buterOrder.getButers().isEmpty()) {
            return "orderForm";
        }
        return "error";
    }
    
    @PostMapping public String processOrder(
            @Valid ButerOrder buterOrder,
            Errors errors,
            SessionStatus status,
            @ModelAttribute ButerUser buterUser
    ) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        buterOrder.setUsername(buterUser.getUsername());
        repo.save(buterOrder);
        Logger.getLogger(OrderController.class.getName())
                .log(Level.INFO, "Process buterOrder: {}", buterOrder);
        status.setComplete();
        return "redirect:/orders/pickedup";
    }
    
}
