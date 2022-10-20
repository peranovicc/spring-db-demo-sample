package com.example.demo_db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Ingredients")
// select * from ingredient
public class Ingredient implements Comparable<Ingredient> {
    @Id
    private UUID id;
    private String name;
    private double currentPrice;

    public Ingredient() {
    }

    public Ingredient(UUID id, String name, double currentPrice) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }

    @Override
    public int compareTo(Ingredient o) {
        return (int)(this.getCurrentPrice() - o.getCurrentPrice());
    }
}
