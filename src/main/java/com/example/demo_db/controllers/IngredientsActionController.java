package com.example.demo_db.controllers;

import com.example.demo_db.model.Ingredient;
import com.example.demo_db.repository.Interfaces.IngredientRepository;
import com.example.demo_db.repository.Interfaces.TestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IngredientsActionController {
    private IngredientRepository ingredientRepository;
    private TestJpaRepository testJpaRepository;


    @Autowired
    public IngredientsActionController(IngredientRepository ingredientRepository, TestJpaRepository testJpaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.testJpaRepository = testJpaRepository;
    }

    @PostMapping("/api/ingredients")
    public ResponseEntity<Void> addIngredient(@RequestBody Ingredient ingredient){
        // Проверити да ли већ постоји састојак са прослеђеним именом
        if(testJpaRepository.isDuplicateName(ingredient.getName()) != 0){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        // Генерисати насумичан id и додати га састојку из request-a
        ingredient.setId(UUID.randomUUID());

        ingredientRepository.insertIngredient(ingredient);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

}
