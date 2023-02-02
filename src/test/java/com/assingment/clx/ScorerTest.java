package com.assingment.clx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScorerTest {

    // Test for scoring products successfully
    @Test
    public void testScoreProductsSuccess() {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition("color", "item3", "=="));
        Rule rule = new Rule(false, 20, conditions);
        Scorer scorer = new Scorer(rule);
        List<Product> products = new ArrayList<>();
        products.add(new Product("item1", "item2", "item3", 1.0, 2.0, 3.0));
        products.add(new Product("item4", "item5", "item6", 4.0, 5.0, 6.0));
        List<Product> expectedScoredProducts = new ArrayList<>();
        expectedScoredProducts.add(new Product("item1", "item2", "item3", 1.0, 2.0, 20));
        expectedScoredProducts.add(new Product("item4", "item5", "item6", 4.0, 5.0, 0.0));
        List<Product> actualScoredProducts = scorer.scoreProducts(products);
        assertEquals(expectedScoredProducts, actualScoredProducts);
    }

    // Test for empty list of products
    @Test
    public void testScoreProductsEmptyList() {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition("color", "item3", "=="));
        Rule rule = new Rule(false, 20, conditions);
        Scorer scorer = new Scorer(rule);
        List<Product> products = new ArrayList<>();
        List<Product> expectedScoredProducts = new ArrayList<>();
        List<Product> actualScoredProducts = scorer.scoreProducts(products);
        assertEquals(expectedScoredProducts, actualScoredProducts);
    }
}
