package com.example.demo_db.controllers;

import com.example.demo_db.model.Ingredient;
import com.example.demo_db.repository.Interfaces.IngredientRepository;
import com.example.demo_db.repository.Interfaces.TestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class IngredientsQueryController {
    private IngredientRepository ingredientRepository;
    private TestJpaRepository testJpaRepository;

    @Autowired
    public IngredientsQueryController(IngredientRepository ingredientRepository, TestJpaRepository testJpaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.testJpaRepository = testJpaRepository;
    }

    // /api/ingredients
    @GetMapping("/api/ingredients")
    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.getAllIngredients();
    }

    @GetMapping("/api/testjpa/{name}")
    public List<Ingredient> getIngredientsByName(@PathVariable String name){
        return testJpaRepository.findByNameStartsWith(name);
    }

    // @GetMapping("/api/testjpa/price/{price}")
    // public List<Ingredient> getIngredientsCheaperThan(@PathVariable double price){
    //     return testJpaRepository.getIngredientsCheaperThan(price);
    // }

    @GetMapping("/api/testjpa/price/{price}/{name}")
    public List<Ingredient> getIngredientsCheaperThan(@PathVariable double price, @PathVariable String name){
        return testJpaRepository.findByCurrentPriceLessThanAndNameStartsWith(price, name);
    }
}
