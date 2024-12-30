package druyaned.buterplace;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Buter {
    
    @Id private Long id;
    
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @NotBlank(message = "пустое имя бутера")
    private String name;
    
    @Size(min = 1, message = "требуется хотя бы 1 ингредиент")
    private List<IngredientRef> ingredientRefs = new ArrayList<>();
    
    public Long getId() {
        return id;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public String getName() {
        return name;
    }
    
    public List<IngredientRef> getIngredientRefs() {
        return ingredientRefs;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setIngredientRefs(List<IngredientRef> ingredientRefs) {
        this.ingredientRefs = ingredientRefs;
    }
    
    @Override public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.createdAt);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.ingredientRefs);
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
        final Buter other = (Buter) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return Objects.equals(this.ingredientRefs, other.ingredientRefs);
    }
    
    @Override public String toString() {
        return "Buter{id=" + id
                + ", createdAt=" + createdAt
                + ", name=" + name
                + ", ingredientRefs=" + ingredientRefs
                + '}';
    }
    
}
