package com.github.druyaned.buters.web;

import com.github.druyaned.buters.Buter;
import com.github.druyaned.buters.ButerOrder;
import com.github.druyaned.buters.Ingredient;
import com.github.druyaned.buters.data.IngredientRepository;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DesignButerController {
    
    private final IngredientRepository repo;
    
    public DesignButerController(IngredientRepository repo) {
        this.repo = repo;
    }
    
//-Methods------------------------------------------------------------------------------------------
    
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
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
    
    @GetMapping
    public String designForm() {
        return "designForm";
    }
    
    @PostMapping
    public String processButer(@Valid Buter buter, Errors errors,
            @ModelAttribute ButerOrder buterOrder) {
        if (errors.hasErrors()) {
            return "designForm";
        }
        buterOrder.addButer(buter);
        log.info("Process buter: {}", buter);
        return "redirect:/orders/current";
    }

}
