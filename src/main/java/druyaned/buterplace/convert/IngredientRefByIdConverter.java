package druyaned.buterplace.convert;

import druyaned.buterplace.Ingredient;
import druyaned.buterplace.IngredientRef;
import druyaned.buterplace.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientRefByIdConverter implements Converter<String, IngredientRef> {
    
    private final IngredientRepository repo;
    
    @Autowired public IngredientRefByIdConverter(IngredientRepository repo) {
        this.repo = repo;
    }
    
    @Override public IngredientRef convert(String ingredientId) {
        Ingredient ingredient = repo.findById(ingredientId).orElse(null);
        if (ingredient == null) {
            return null;
        } else {
            return new IngredientRef(ingredient.getId());
        }
    }
    
}
