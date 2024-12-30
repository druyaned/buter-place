package druyaned.buterplace.web;

import druyaned.buterplace.Buter;
import druyaned.buterplace.ButerOrder;
import druyaned.buterplace.Ingredient;
import druyaned.buterplace.data.IngredientRepository;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/design")
@SessionAttributes("buterOrder")
public class DesignButerController {
    
    private final IngredientRepository repo;
    
    public DesignButerController(IngredientRepository repo) {
        this.repo = repo;
    }
    
    @ModelAttribute public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = repo.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            String attributeName = type.toString().toLowerCase();
            List<Ingredient> attributeValue = new ArrayList<>();
            for (Ingredient ingredient : ingredients) {
                if (ingredient.getType().equals(type)) {
                    attributeValue.add(ingredient);
                }
            }
            model.addAttribute(attributeName, attributeValue);
        }
    }
    
    @ModelAttribute(name = "buter")
    public Buter buter() {
        return new Buter();
    }
    
    @ModelAttribute(name = "buterOrder")
    public ButerOrder buterOrder() {
        return new ButerOrder();
    }
    
    @GetMapping public String designForm() {
        return "designForm";
    }
    
    @PostMapping public String processButer(
            @Valid Buter buter,
            Errors errors,
            @ModelAttribute ButerOrder buterOrder
    ) {
        if (errors.hasErrors()) {
            return "designForm";
        }
        buterOrder.addButer(buter);
        Logger.getLogger(DesignButerController.class.getName())
                .log(Level.INFO, "Process buter: {}", buter);
        return "redirect:/orders/current";
    }
    
}
