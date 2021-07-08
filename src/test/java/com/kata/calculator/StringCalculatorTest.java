package com.kata.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();
    private static int expectedCount = 0;

    @AfterEach
    public void incrementAddCallCount(){
        expectedCount ++;
    }

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

    @Test
    public void shouldReturnSumOfMoreNumbersProvidedUsingDefaultDelimiterAndNewLineDelimiter() {
        assertEquals(12, stringCalculator.add("2\n5,5"));
    }

    @Test
    public void shouldReturnSumOfMoreNumbersProvidedUsingCustomDelimiterPresentInInput() {
        assertEquals(10, stringCalculator.add("//[-]\n5-5"));
    }

    @Test
    public void shouldReturnSumOfMoreNumbersProvidedUsingMultipleCustomDelimiterPresentInInput() {
        assertEquals(12, stringCalculator.add("//[-][;]\n5-5;2"));
    }

    @Test
    public void shouldThrowExceptionIfNegativeNumberIsPresent() {
        try {
            stringCalculator.add("2,-5");
        }catch (IllegalArgumentException e){
            assertEquals("Negative number not allowed -5", e.getMessage());
        }
    }

    @Test
    public void shouldThrowExceptionForAllNegativeNumbersInInput() {
        try {
            stringCalculator.add("2,-5,3,-6");
        }catch (IllegalArgumentException e){
            assertEquals("Negative number not allowed -5 -6", e.getMessage());
        }
    }

    @Test
    public void shouldReturnCountOfNumberOfTimesAddCalled() {
        assertEquals(expectedCount, StringCalculator.getCalledCount());
    }

    @Test
    public void shouldReturnSumOfNumbersWithIgnoringNumbersGreaterThan1000() {
        assertEquals(2, stringCalculator.add("2,1001"));
    }

    @Test
    public void shouldReturnSumOfMoreNumbersProvidedUsingCustomDelimiterWhoseLengthIsGreaterThanZero() {
        assertEquals(10, stringCalculator.add("//[;;]\n5;;5"));
    }
}