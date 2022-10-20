package com.example.demo_db.repository.Interfaces;

import com.example.demo_db.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository
public interface TestJpaRepository extends JpaRepository<Ingredient, UUID> {
    Optional<Ingredient> findById(UUID id);

    List<Ingredient> findByNameStartsWith(String name);

    List<Ingredient> findByCurrentPriceLessThanAndNameStartsWith(double currentPrice, String name);

    // @Query("SELECT new java.lang.Boolean(COUNT(u) > 0) FROM Customer u WHERE u.customer_type=?1")
    // Boolean getCountOfNewUsers(String customertype);

    @Query(value = "SELECT COUNT(*) FROM Ingredients WHERE name=:name", nativeQuery = true)
    Integer isDuplicateName(@Param("name") String name);




    // JPA query
    // @Query("SELECT i FROM Ingredients i WHERE currentPrice < :price")
    // List<Ingredient> getIngredientsCheaperThan(@Param("price") double price);

    // Native query
    @Query(value = "SELECT * FROM Ingredients WHERE currentPrice < :price AND name like :name%", nativeQuery = true)
    List<Ingredient> getIngredientsCheaperThan(@Param("price") double x, @Param("name") String y);


}
