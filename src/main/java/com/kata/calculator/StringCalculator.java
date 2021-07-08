package com.kata.calculator;

import java.util.Arrays;

public class StringCalculator {

    String DEFAULT_DELIMITER = ",";

    public int add(String input) {
        if(input.isEmpty())
            return 0;
        return Arrays.stream(input.split(DEFAULT_DELIMITER)).mapToInt(Integer::parseInt).sum();
    }
}
