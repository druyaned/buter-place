package druyaned.buterplace.web;

import druyaned.buterplace.ButerUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    
    @ModelAttribute(name = "hasUser")
    public boolean hasUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal()
                instanceof ButerUser;
    }
    
    @GetMapping public String homePage() {
        return "homePage";
    }
    
}
