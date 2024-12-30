package druyaned.buterplace.web;

import druyaned.buterplace.ButerOrder;
import druyaned.buterplace.ButerUser;
import druyaned.buterplace.data.OrderRepository;
import druyaned.buterplace.props.ButerUserProps;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders/show")
public class OrdersShowController {
    
    private final OrderRepository repo;
    private final ButerUserProps props;
    
    public OrdersShowController(OrderRepository repo, ButerUserProps props) {
        this.repo = repo;
        this.props = props;
    }
    
    @ModelAttribute(name = "buterUser")
    public ButerUser buterUser() {
        return (ButerUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
    @ModelAttribute public void addButerOrdersToModel(
            Model model,
            @ModelAttribute ButerUser buterUser
    ) {
        List<ButerOrder> buterOrders = repo
                .findByUsernameOrderByCreatedAtDesc(buterUser.getUsername());
        model.addAttribute("buterOrders", buterOrders.subList(0,
                Integer.min(buterOrders.size(), props.getOrderCountToShow())));
    }
    
    @GetMapping public String ordersShow() {
        return "ordersShowPage";
    }
    
}
