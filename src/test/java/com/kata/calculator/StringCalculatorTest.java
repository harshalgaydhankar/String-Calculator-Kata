package com.kata.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void shouldReturnTheSameNumberForOneNumberString() {
        assertEquals(3, stringCalculator.add("3"));
    }

    @Test
    public void shouldReturnSumOfTwoNumbersProvidedUsingDefaultDelimiter() {
        assertEquals(7, stringCalculator.add("2,5"));
    }

    @Test
    public void shouldReturnSumOfMoreNumbersProvidedUsingDefaultDelimiter() {
        assertEquals(25, stringCalculator.add("1,3,5,7,9"));
    }
}