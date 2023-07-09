package com.github.druyaned.buters;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
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
    
    @Override
    public boolean isNew() {
        return true;
    }

}
