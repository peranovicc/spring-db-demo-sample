package com.example.demo_db.controllers;

import com.example.demo_db.model.Ingredient;
import com.example.demo_db.repository.Interfaces.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class IngredientsQueryController {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientsQueryController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    // /api/ingredients
    @GetMapping("/api/ingredients")
    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.getAllIngredients();
    }
}
