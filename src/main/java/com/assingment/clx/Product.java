package com.assingment.clx;

import java.util.List;

class Product {
    private String name;
    private String type;
    private String color;
    private double cost;
    private double weight;

    public Product(String name, String type, String color, double cost, double weight) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.cost = cost;
        this.weight = weight;
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



