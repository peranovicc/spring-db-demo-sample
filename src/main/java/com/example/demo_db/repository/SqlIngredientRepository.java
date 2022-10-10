package com.example.demo_db.repository;

import com.example.demo_db.model.Ingredient;
import com.example.demo_db.repository.Interfaces.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class SqlIngredientRepository implements IngredientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Ingredient> getAllIngredients() {
        String query = "SELECT id, name, currentPrice FROM Ingredients";

        // String testInsert = "insert into ingredients ([id], [name], currentPrice) values ('f5b69315-881a-4902-a55f-5ed3d59754ca', 'MOJ SASTOJAK', 1337)";
        // jdbcTemplate.execute(testInsert);

        return jdbcTemplate.query(
                query,
                BeanPropertyRowMapper.newInstance(Ingredient.class)
        );
    }
}
