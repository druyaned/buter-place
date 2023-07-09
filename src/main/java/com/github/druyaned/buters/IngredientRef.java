package com.github.druyaned.buters;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table
public class IngredientRef {

    private final String ingredientId;
    
}
