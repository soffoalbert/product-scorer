package com.assingment.clx;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Condition {
    private final String attributeName;
    private final Object value;
    private final String operator;

    public Condition(String attributeName, Object value, String operator) {
        this.attributeName = attributeName;
        this.value = value;
        this.operator = operator;
    }

    public boolean isMatching(Product product) {
        Object actualValue = product.getProductAttributeValue(attributeName);
        return compare(actualValue, value, operator);
    }

    protected boolean compare(Object a, Object b, String operator) {
        if (a instanceof String) {
            return compareString((String) a, (String) b, operator);
        } else if (a instanceof Double || a instanceof Integer) {
            return compareNumber(a, b, operator);
        } else {
            throw new IllegalArgumentException("Incompatible types for comparison");
        }
    }

    protected boolean compareNumber(Object a, Object b, String operator) {
        double aValue = a instanceof Integer ? (int) a : (double) a;
        double bValue = b instanceof Integer ? (int) b : (double) b;

        switch (operator) {
            case "<":
                return aValue < bValue;
            case ">":
                return aValue > bValue;
            case "<=":
                return aValue <= bValue;
            case ">=":
                return aValue >= bValue;
            case "==":
                return aValue == bValue;
            case "!=":
                return aValue != bValue;
            default:
                throw new IllegalArgumentException("Invalid operator for number comparison: " + operator);
        }
    }

    protected boolean compareString(String a, String b, String operator) {
        switch (operator) {
            case "==":
                return a.equals(b);
            case "!=":
                return !a.equals(b);
            default:
                throw new IllegalArgumentException("Invalid operator for string comparison: " + operator);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condition condition = (Condition) o;
        return Objects.equals(attributeName, condition.attributeName) && Objects.equals(value, condition.value) && Objects.equals(operator, condition.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, value, operator);
    }
}
