package com.assingment.clx;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private boolean negative;
    private int score;
    private List<Condition> conditions;

    public Rule(boolean negative, int score, List<Condition> conditions) {
        this.negative = negative;
        this.score = score;
        this.conditions = conditions;
    }

    public int getScore(Product product) {
        int matchingConditions = 0;
        for (Condition condition : conditions) {
            if (condition.isMatching(product)) {
                matchingConditions++;
            }
        }
        int result = (int) (matchingConditions * 1.0 / conditions.size() * score);
        return negative ? -result : result;
    }
}