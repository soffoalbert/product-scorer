package com.assingment.clx;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConditionTest {

    //Test isMatching method with a matching product:
    @Test
    public void testIsMatchingWithMatchingProduct() {
        String attributeName = "cost";
        Object value = 100.0;
        String operator = ">=";
        Condition condition = new Condition(attributeName, value, operator);
        Product product = new Product("product3", "type3", "blue", 100.00, 700);
        assertTrue(condition.isMatching(product));
    }

    //Test isMatching method with a non-matching product:
    @Test
    public void testIsMatchingWithNonMatchingProduct() {
        String attributeName = "cost";
        Object value = 100.0;
        String operator = ">=";
        Condition condition = new Condition(attributeName, value, operator);
        Product product = new Product("product3", "type3", "blue", 8, 700);
        assertFalse(condition.isMatching(product));
    }

    //Test compare method with String type:
    @Test
    public void testCompareWithStringType() {
        String a = "red";
        String b = "red";
        String operator = "==";
        Condition condition = new Condition(null, null, null);
        assertTrue(condition.compare(a, b, operator));
    }

    //Test compare method with Integer type:
    @Test
    public void testCompareWithIntegerType() {
        Integer a = 10;
        Integer b = 20;
        String operator = "<";
        Condition condition = new Condition(null, null, null);
        assertTrue(condition.compare(a, b, operator));
    }

    // Test compare method with Double type:
    @Test
    public void testCompareWithDoubleType() {
        Double a = 10.0;
        Double b = 20.0;
        String operator = "<";
        Condition condition = new Condition(null, null, null);
        assertTrue(condition.compare(a, b, operator));
    }

    // Test compareNumber method with less than operator:
    @Test
    public void testCompareNumberWithLessThanOperator() {
        Integer a = 10;
        Integer b = 20;
        String operator = "<";
        Condition condition = new Condition(null, null, null);
        assertTrue(condition.compareNumber(a, b, operator));
    }

    @Test
    public void testStringComparisonEqual() {
        Condition condition = new Condition("name", "apple", "==");
        Product product = new Product("apple", "type3", "blue", 100.00, 700);
        assertTrue(condition.isMatching(product));
    }

    @Test
    public void testStringComparisonNotEqual() {
        Condition condition = new Condition("name", "apple", "!=");
        Product product = new Product("product3", "type3", "blue", 100.00, 700);
        assertTrue(condition.isMatching(product));
    }

    @Test
    public void testDoubleComparisonGreaterThan() {
        Condition condition = new Condition("cost", 1.0, ">");
        Product product = new Product("product3", "type3", "blue", 100.00, 700);
        assertTrue(condition.isMatching(product));
    }

    @Test
    public void testDoubleComparisonLessThan() {
        Condition condition = new Condition("weight", 0.5, "<");
        Product product = new Product("product3", "type3", "blue", 100.00, 0.2);
        assertTrue(condition.isMatching(product));
    }

    @Test
    public void testDoubleComparisonEqual() {
        Condition condition = new Condition("cost", 1.0, "==");
        Product product = new Product("product3", "type3", "blue", 1.0, 700);
        assertTrue(condition.isMatching(product));
    }

    @Test
    public void testDoubleComparisonNotEqual() {
        Condition condition = new Condition("cost", 1.0, "!=");
        Product product = new Product("product3", "type3", "blue", 100.00, 700);
        assertTrue(condition.isMatching(product));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownAttribute() {
        Condition condition = new Condition("unknown", 1.0, "==");
        Product product = new Product("product3", "type3", "blue", 100.00, 700);
        condition.isMatching(product);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperator() {
        Condition condition = new Condition("cost", 1.0, "=");
        Product product = new Product("apple", "red", "Blue", 0.5,1);
        condition.isMatching(product);
    }

}
