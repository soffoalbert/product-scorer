package com.assingment.clx;

import java.util.Objects;

public class Product {
    private String name;
    private String type;
    private String color;
    private double cost;
    private double weight;
    private double score;


    public Product(String name, String type, String color, double cost, double weight, double score) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.cost = cost;
        this.weight = weight;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.getCost(), getCost()) == 0 && Double.compare(product.getWeight(), getWeight()) == 0 && Double.compare(product.getScore(), getScore()) == 0 && Objects.equals(getName(), product.getName()) && Objects.equals(getType(), product.getType()) && Objects.equals(getColor(), product.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getColor(), getCost(), getWeight(), getScore());
    }

    protected Object getProductAttributeValue(String attributeName) {
        switch (attributeName) {
            case "color":
                return this.getColor();
            case "cost":
                return this.getCost();
            case "weight":
                return this.getWeight();
            case "name":
                return this.getName();
            default:
                throw new IllegalArgumentException("Unknown attribute: " + attributeName);
        }
    }
}



