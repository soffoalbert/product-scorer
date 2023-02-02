package com.assingment.clx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {

    // Test for calculating average price successfully
    @Test
    public void testCalculateAveragePriceSuccess() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("item1", "item2", "item3", 50.0, 1.0, 50));
        products.add(new Product("item4", "item5", "item6", 60.0, 3.0, 60));
        products.add(new Product("item7", "item8", "item9", 40.0, 5.0, 60));
        double expectedAveragePrice = 50.0;
        double actualAveragePrice = PriceCalculator.calculateAveragePrice(products);
        assertEquals(expectedAveragePrice, actualAveragePrice, 0.0);
    }

    // Test for calculating total price successfully
    @Test
    public void testCalculateTotalPriceSuccess() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("item1", "item2", "item3", 50.0, 1.0, 50));
        products.add(new Product("item4", "item5", "item6", 60.0, 3.0, 60));
        products.add(new Product("item7", "item8", "item9", 40.0, 5.0, 45));
        double expectedTotalPrice = 110;
        double actualTotalPrice = PriceCalculator.calculateTotalPrice(products);
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.0);
    }

    // Test for empty list of products
    @Test
    public void testCalculateAveragePriceEmptyList() {
        List<Product> products = new ArrayList<>();
        double expectedAveragePrice = Double.NaN;
        double actualAveragePrice = PriceCalculator.calculateAveragePrice(products);
        assertEquals(expectedAveragePrice, actualAveragePrice, 0.0);
    }
}
