package com.github.druyaned.buters.data;

import com.github.druyaned.buters.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
