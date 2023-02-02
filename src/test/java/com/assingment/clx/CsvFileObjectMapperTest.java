package com.assingment.clx;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CsvFileObjectMapperTest {
    // Test for mapping products to objects successfully
    @Test
    public void testMapProductsToObjectsSuccess() throws IOException {
        String filePath = "src/test/resources/testProductFilePath.csv";
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product("item1", "item2", "item3", 1.0, 2.0, 3.0));
        expectedProducts.add(new Product("item4", "item5", "item6", 4.0, 5.0, 6.0));
        List<Product> actualProducts = CsvFileObjectMapper.mapProductsToObjects(filePath);
        assertEquals(expectedProducts, actualProducts);
    }

    // Test for mapping conditions to objects successfully
    @Test
    public void testMapConditionsToObjectsSuccess() throws IOException {
        String filePath = "src/test/resources/testConditionsFilePath.csv";
        List<Condition> expectedConditions = new ArrayList<>();
        expectedConditions.add(new Condition("item1", 1, "item3"));
        expectedConditions.add(new Condition("item4", 2.0, "item6"));
        List<Condition> actualConditions = CsvFileObjectMapper.mapConditionsToObjects(filePath);
        assertEquals(expectedConditions, actualConditions);
    }

    // Test for IOException while reading file
    @Test(expected = IOException.class)
    public void testMapProductsToObjectsIOException() throws IOException {
        String filePath = "invalidFilePath.csv";
        CsvFileObjectMapper.mapProductsToObjects(filePath);
    }

    // Test for NumberFormatException while parsing string to integer in mapConditionsToObjects
    @Test
    public void testMapConditionsToObjectsNumberFormatException() throws IOException {
        String filePath = "src/test/resources/testInvalidConditionFilePath.csv";
        List<Condition> expectedConditions = new ArrayList<>();
        expectedConditions.add(new Condition("item1", "invalidInt", "item3"));
        expectedConditions.add(new Condition("item4", 2.0, "item6"));
        List<Condition> actualConditions = CsvFileObjectMapper.mapConditionsToObjects(filePath);
        assertEquals(expectedConditions, actualConditions);
    }
}
