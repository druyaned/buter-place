package com.github.druyaned.buters;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table
public class Buter {
    
    @Id private Long id;
    
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @NotBlank(message = "пустое имя бутера")
    private String name;
    
    @Size(min = 1, message = "требуется хотя бы 1 ингредиент")
    private List<IngredientRef> ingredientRefs = new ArrayList<>();
    
}
