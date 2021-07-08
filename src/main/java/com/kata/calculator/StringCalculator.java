package com.kata.calculator;

import java.util.Arrays;

public class StringCalculator {

    String DEFAULT_DELIMITER = ",";
    String NEW_LINE_DELIMITER = "\n";
    String DELIMITER_COMBINER = "|";
    String CUSTOM_DELIMITER = "";

    public int add(String input) {
        if (input.isEmpty())
            return 0;
        if(isCustomerDelimiterPresent(input.split("\n")[0])){
            String delimiterInput = input.split("\n")[0];
            CUSTOM_DELIMITER = delimiterInput.replace("//","").replace("[","").replace("]","");
            return Arrays.stream(
                    input.split("\n")[1].split(CUSTOM_DELIMITER)
            ).mapToInt(Integer::parseInt).sum();
        }

        return Arrays.stream(
                input.split(DEFAULT_DELIMITER + DELIMITER_COMBINER + NEW_LINE_DELIMITER)
        ).mapToInt(Integer::parseInt).sum();
    }

    private boolean isCustomerDelimiterPresent(String input){
        if(input.contains("//") && input.contains("[") && input.contains("]"))
            return true;
        return false;
    }
}
