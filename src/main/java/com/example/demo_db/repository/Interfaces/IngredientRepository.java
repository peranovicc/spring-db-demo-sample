package com.example.demo_db.repository.Interfaces;

import com.example.demo_db.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository {
    List<Ingredient> getAllIngredients();

    void insertIngredient(Ingredient ingredient);
}
