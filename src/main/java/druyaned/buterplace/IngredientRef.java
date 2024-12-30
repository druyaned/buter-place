package druyaned.buterplace;

import java.util.Objects;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class IngredientRef {
    
    private final String ingredientId;
    
    public IngredientRef(String ingredientId) {
        this.ingredientId = ingredientId;
    }
    
    public String getIngredientId() {
        return ingredientId;
    }
    
    @Override public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.ingredientId);
        return hash;
    }
    
    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IngredientRef other = (IngredientRef) obj;
        return this.ingredientId.equals(other.ingredientId);
    }
    
    @Override public String toString() {
        return "IngredientRef{ingredientId=" + ingredientId + '}';
    }
    
}
