package com.kata.calculator;

import java.util.Arrays;

public class StringCalculator {

    String DEFAULT_DELIMITER = ",";
    String NEW_LINE_DELIMITER = "\n";
    String DELIMITER_COMBINER = "|";


    public int add(String input) {
        if(input.isEmpty())
            return 0;
        return Arrays.stream(input.split(DEFAULT_DELIMITER+DELIMITER_COMBINER+NEW_LINE_DELIMITER)).mapToInt(Integer::parseInt).sum();
    }
}
