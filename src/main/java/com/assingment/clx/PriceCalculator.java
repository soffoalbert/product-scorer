package com.assingment.clx;

import com.assingment.clx.Product;

import java.util.List;

public class PriceCalculator {
    public double calculateAveragePrice(List<Product> products) {
        double totalPrice = 0.0;
        int count = 0;
        for (Product product : products) {
            if (product.getScore() >= 50) {
                totalPrice += product.getCost();
                count++;
            }
        }
        return totalPrice / count;
    }

    public double calculateTotalPrice(List<Product> products) {
        double totalPrice = 0.0;
        for (Product product : products) {
            if (product.getScore() >= 50) {
                totalPrice += product.getCost();
            }
        }
        return totalPrice;
    }
}
