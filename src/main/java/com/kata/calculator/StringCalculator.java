package com.kata.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    String DEFAULT_DELIMITER = ",";
    String NEW_LINE_DELIMITER = "\n";
    String DELIMITER_COMBINER = "|";
    String CUSTOM_DELIMITER = "";

    public int add(String input) {
        List<String> arguments = new ArrayList();
        if (input.isEmpty())
            return 0;

        if (isCustomerDelimiterPresent(input.split("\n")[0])) {
            String delimiterInput = input.split("\n")[0];
            CUSTOM_DELIMITER = delimiterInput
                    .replace("//", "")
                    .replace("][", " ")
                    .replace("[", "")
                    .replace("]", "")
                    .replace(" ", DELIMITER_COMBINER);
            arguments = Arrays.asList(input.split("\n")[1].split(CUSTOM_DELIMITER));
            checkForNegativeNumber(arguments);
            return arguments.stream().mapToInt(Integer::parseInt).sum();
        }
        arguments = Arrays.asList(input.split(DEFAULT_DELIMITER + DELIMITER_COMBINER + NEW_LINE_DELIMITER));
        checkForNegativeNumber(arguments);
        return arguments.stream().mapToInt(Integer::parseInt).sum();
    }

    private void checkForNegativeNumber(List<String> arguments) {
        List<String> negativeNumbers = new ArrayList();
        for (String argument : arguments) {
            if (Integer.parseInt(argument) < 0)
                negativeNumbers.add(argument);
        }
        if (negativeNumbers.size() > 0) {
            throw new IllegalArgumentException(
                    "Negative number not allowed " + String.join(" ", negativeNumbers));
        }
    }

    private boolean isCustomerDelimiterPresent(String input) {
        if (input.contains("//") && input.contains("[") && input.contains("]"))
            return true;
        return false;
    }
}
