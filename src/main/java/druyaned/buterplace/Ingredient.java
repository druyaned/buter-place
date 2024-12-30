package druyaned.buterplace;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Ingredient implements Persistable<String> {
    
    public static enum Type { WRAP, PROTEIN, VEGGIE, CHEESE, SAUCE }
    
    @Id private String id;
    private String name;
    private Type type;
    
    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    
    @Override public boolean isNew() {
        return true;
    }
    
    @Override public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Type getType() {
        return type;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    @Override public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.type);
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
        final Ingredient other = (Ingredient)obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!this.name.equals(other.name)) {
            return false;
        }
        return this.type == other.type;
    }
    
    @Override public String toString() {
        return "Ingredient{" + "id=" + id + ", name=" + name + ", type=" + type + '}';
    }
    
}
