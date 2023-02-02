package com.assingment.clx;

import com.assingment.clx.Product;
import com.assingment.clx.Rule;

import java.util.List;

public class Scorer {
    private Rule rule;

    public Scorer(Rule rules) {
        this.rule = rules;
    }

    public List<Product> scoreProducts(List<Product> products) {
        for (Product product : products) {
            int score = 0;
            score += rule.getScore(product);
            product.setScore(score);
        }
        return products;
    }
}
