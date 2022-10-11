package com.example.demo_db.controllers;

import com.example.demo_db.model.Ingredient;
import com.example.demo_db.repository.Interfaces.IngredientRepository;
import com.example.demo_db.repository.Interfaces.TestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/api/ingredients")
    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.getAllIngredients();
    }

    // 63AD3944-E558-4D76-8971-D4F00B71C434
    @GetMapping("/api/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable(value = "id") UUID id){
        // var maybeIngredient = testJpaRepository.findById(id);
        //
        // if(maybeIngredient.isEmpty()){
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        // }
        //
        // return ResponseEntity.status(HttpStatus.OK).body(maybeIngredient.get());
        if(!testJpaRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(testJpaRepository.findById(id).get());
    }
}
