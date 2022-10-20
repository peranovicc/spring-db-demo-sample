package com.example.demo_db.controllers;

import com.example.demo_db.model.Ingredient;
import com.example.demo_db.repository.Interfaces.IngredientRepository;
import com.example.demo_db.repository.Interfaces.TestJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IngredientsQueryController.class)
class IngredientsQueryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IngredientRepository ingredientRepository;

    @MockBean
    TestJpaRepository testJpaRepository;

    @Test
    void testFN() {
        assertEquals("Bla bla 1", IngredientsQueryController.testFN(1));
        assertEquals("Bla bla -50", IngredientsQueryController.testFN(-50));
        assertEquals("Bla bla 0", IngredientsQueryController.testFN(0));
    }

    @Test
    void getAllIngredients() throws Exception {
        Ingredient I1 = new Ingredient(UUID.randomUUID(), "Jabuka", 102.2);
        Ingredient I2 = new Ingredient(UUID.randomUUID(), "Kruska", 123);
        Ingredient I3 = new Ingredient(UUID.randomUUID(), "Mleko", 500);
        ArrayList<Ingredient> ingredients = new ArrayList<>(Arrays.asList(I1, I2, I3));

        Mockito.when(ingredientRepository.getAllIngredients())
                .thenReturn(ingredients);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/ingredients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[1].currentPrice", is(123.0)));
    }

    @Test
    void getIngredientsByName() {
    }

    @Test
    void getIngredientsCheaperThan() {
    }
}