package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    FizzBuzz sut;

    @BeforeEach
    void setUp() {
        sut = new FizzBuzz();
    }

    // if number divisible by 3, print Fizz
    @Test
    @DisplayName("Should divide by 3")
    @Order(1)
    void testForDivisibleBy3() {
        String expected = "Fizz";
        assertEquals(expected, sut.compute(3), "Should print 'Fizz'" );
    }

    // if number divisible by 5, print Buzz
    @Test
    @DisplayName("Should divide by 5")
    @Order(2)
    void testForDivisibleBy5() {
        String expected = "Buzz";
        assertEquals(expected, sut.compute(5), "Should return 'Buzz'");
    }


    // if number divisible by 3 and 5, print FizzBuzz
    @Test
    @DisplayName("Should divide by 3 and 5")
    @Order(3)
    void testForDivisibleBy3And5() {
        String expected = "FizzBuzz";
        assertEquals(expected, sut.compute(15), "Should return 'FizzBuzz'");
    }

    // else print number
    @Test
    @Disabled
    @DisplayName("Should print number")
    @Order(4)
    void testForNonDivisibleBy3Or5() {
        String expected = "7";
        assertEquals(expected, sut.compute(7), "Should return a string");
    }


    @Order(5)
    @ParameterizedTest(name = "input = {0}, expected = {1}")
    @CsvSource({"1, 1", "2, 2", "3, Fizz", "4, 4", "5, Buzz", "15, FizzBuzz"})
    void parametrizedTestExampleOne(int input, String expected) {
        assertEquals(expected, sut.compute(input));
    }

    @Order(6)
    @ParameterizedTest(name = "input = {0}, expected = {1}")
    @CsvFileSource(resources = "/large-test-data.csv") // you can call the test method with small or medium-test-data.csv
    void parametrizedTestExampleTwo(int input, String expected) {
        assertEquals(expected, sut.compute(input));
    }

}
