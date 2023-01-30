package com.assingment.clx;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("product1", "type1", "blue", 15.00, 700));
        products.add(new Product("product2", "type2", "red", 12.00, 800));
        products.add(new Product("product3", "type3", "green", 18.00, 700));
        products.add(new Product("product4", "type4", "blue", 20.00, 700));

        List<Rule> rules1 = new ArrayList<>();
        List<Rule> rules2 = new ArrayList<>();
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition("color", "blue", "=="));
        conditions.add(new Condition("cost", 17.75, "<"));
        conditions.add(new Condition("name", "product3", "=="));
        conditions.add(new Condition("color", "red", "!="));
        conditions.add(new Condition("cost", 17.75, ">"));
        conditions.add(new Condition("name", "product4", "!="));
        rules1.add(new Rule(false,100, conditions));
        rules2.add(new Rule(true,100, conditions));


        for (Product product : products) {
            int score = 0;
            for (Rule rule : rules1) {
                score += rule.getScore(product);
            }
            System.out.println(score);
        }
//
//        double totalPrice = 0.0;
//        int count = 0;
//        for (Product product : products) {
//            if (product.getScore() >= 50) {
//                totalPrice += product.getPrice();
//                count++;
//            }
//        }

//        double averagePrice = totalPrice / count;
//        System.out.println("Total price: " + totalPrice);
//        System.out.println("Average price: " + averagePrice);
    }
}
