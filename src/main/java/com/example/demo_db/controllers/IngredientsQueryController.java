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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class IngredientsQueryController {
    private IngredientRepository ingredientRepository;
    private TestJpaRepository testJpaRepository;

    @Autowired
    public IngredientsQueryController(IngredientRepository ingredientRepository, TestJpaRepository testJpaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.testJpaRepository = testJpaRepository;
    }

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        if(5 == 5){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        else if(6 == 9){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    // /api/ingredients
    @GetMapping("/api/ingredients")
    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.getAllIngredients();
    }

    // 63AD3944-E558-4D76-8971-D4F00B71C434
    @GetMapping("/api/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable(value = "id") UUID id) {
        // var maybeIngredient = testJpaRepository.findById(id);
        //
        // if(maybeIngredient.isEmpty()){
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        // }
        //
        // return ResponseEntity.status(HttpStatus.OK).body(maybeIngredient.get());
        if (!testJpaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(testJpaRepository.findById(id).get());
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
        List<Ingredient> test = testJpaRepository.findByCurrentPriceLessThanAndNameStartsWith(price, name);

        List<Ingredient> blabla = test.stream()
                .filter(x -> x.getCurrentPrice() > 50)
                .map(x -> {
                    Ingredient y = new Ingredient();

                    y.setCurrentPrice(x.getCurrentPrice() + 50);
                    y.setId(x.getId());
                    y.setName(x.getName());

                    return y;
                })
                .sorted()
                .collect(Collectors.toList());

        return testJpaRepository.findByCurrentPriceLessThanAndNameStartsWith(price, name);
    }
    public static String testFN(int x){
        return "Bla bla " + x;
    }


    private boolean priceBiggerThan50(Ingredient pppp){
        return pppp.getCurrentPrice() > 50;
    }
}
