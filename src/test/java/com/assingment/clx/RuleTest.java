package com.assingment.clx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RuleTest {

    // Test for negative boolean value
    @Test
    public void testNegativeValue() {
        Product product = new Product("product3", "type3", "green", 100.00, 700, 0);
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition("color", "green", "=="));
        Rule rule = new Rule(true, 10, conditions);
        assertTrue(rule.getScore(product) < 0);
    }

    // Test for score value
    @Test
    public void testScoreValue() {
        Product product = new Product("product3", "type3", "green", 100.00, 700, 0);
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition("color", "green", "=="));
        Rule rule = new Rule(false, 20, conditions);
        assertEquals(20, rule.getScore(product));
    }

    // Test for getScore method with all matching conditions
    @Test
    public void testGetScoreAllMatchingConditions() {
        List<Condition> conditions = new ArrayList<>();
        Product product = new Product("product3", "type3", "green", 100.00, 700, 0);
        conditions.add(new Condition("color", "green", "=="));
        conditions.add(new Condition("cost", 9, ">"));
        Rule rule = new Rule(false, 50, conditions);
        assertEquals(50, rule.getScore(product));
    }
//
    // Test for getScore method with some non-matching conditions
    @Test
    public void testGetScoreSomeNonMatchingConditions() {
        List<Condition> conditions = new ArrayList<>();
        Product product = new Product("product3", "type3", "blue", 100.00, 700, 0);
        conditions.add(new Condition("color", "green", "=="));
        conditions.add(new Condition("cost", 9, ">"));
        Rule rule = new Rule(false, 50, conditions);
        assertEquals(25, rule.getScore(product));
    }

    // Test for getScore method with negative value
    @Test
    public void testGetScoreNegativeValue() {
        List<Condition> conditions = new ArrayList<>();
        Product product = new Product("product3", "type3", "blue", 100.00, 700, 0);
        conditions.add(new Condition("color", "green", "=="));
        conditions.add(new Condition("cost", 9, ">"));
        Rule rule = new Rule(true, 50, conditions);
        assertEquals(-25, rule.getScore(product));
    }
}
