package com.assingment.clx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileObjectMapper {

    private static final String DELIMITER = ",";

    public static List<Product> mapProductsToObjects(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(DELIMITER);
                products.add(new Product(fields[0], fields[1], fields[2], Double.parseDouble(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5])));
            }
        }

        return products;
    }

    public static List<Condition> mapConditionsToObjects(String filePath) throws IOException {
        List<Condition> conditions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(DELIMITER);
                String value = fields[1];
                try {
                    conditions.add(new Condition(fields[0], Integer.parseInt(value), fields[2]));
                } catch (NumberFormatException e) {
                    try {
                        conditions.add(new Condition(fields[0], Double.parseDouble(value), fields[2]));
                    } catch (NumberFormatException ex) {
                        conditions.add(new Condition(fields[0], value, fields[2]));
                    }
                }

            }
        }
        return conditions;
    }
}
