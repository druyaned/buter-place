package druyaned.buterplace.security;

import druyaned.buterplace.data.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    private final UserRepository repo;
    private final PasswordEncoder encoder;
    
    public RegistrationController(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }
    
    @ModelAttribute(name = "registrationForm")
    public RegistrationForm registrationForm() {
        return new RegistrationForm();
    }
    
    @GetMapping public String registerForm() {
        return "registerForm";
    }
    
    @PostMapping public String processUser(
            @Valid RegistrationForm registrationForm,
            Errors errors,
            Model model
    ) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        repo.save(registrationForm.toUser(encoder));
        return "redirect:/login";
    }
    
}
