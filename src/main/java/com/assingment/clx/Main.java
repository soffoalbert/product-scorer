package com.assingment.clx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Please Provide the path to the salesman rules as well as the products file.");
        }
        String PRODUCT_FILEPATH = args[0];
        String CONDITIONS_FILEPATH = args[1];
        String ISNEGATIVE = args[2];
        String SCORE= args[3];
        List<Product> products = CsvFileObjectMapper.mapProductsToObjects(PRODUCT_FILEPATH);

        List<Condition> conditions = CsvFileObjectMapper.mapConditionsToObjects(CONDITIONS_FILEPATH);

        Rule rule = new Rule(Boolean.parseBoolean(ISNEGATIVE), Integer.parseInt(SCORE), conditions);

        Scorer scorer = new Scorer(rule);
        products = scorer.scoreProducts(products);

        PriceCalculator calculator = new PriceCalculator();
        double averagePrice = calculator.calculateAveragePrice(products);
        double totalPrice = calculator.calculateTotalPrice(products);

        System.out.println("Total price: " + totalPrice);
        System.out.println("Average price: " + averagePrice);
    }
}
