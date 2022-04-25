package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
class DemoUtilsTest {

    DemoUtils sut;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Called 'beforeAll()'");
    }

    @BeforeEach
    void setUp() {
        sut = new DemoUtils();
        System.out.println("Called 'setUp()' before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Called 'tearDown()' after each tests");
    }

    @Test
    void add() {
        System.out.println("This is the 'add()' test method");
        // arrange
        int expected = 6;
        int unexpected = 7;
        // act
        int result = sut.add(4, 2 );

        //assert
        assertEquals(expected, result, "2 + 4 should = 6");
        assertNotEquals(unexpected, result, "2 + 4 should not = 7");
    }


    @Test
    void checkNull() {
        System.out.println("This is the 'checkNull()' test method");
        // arrange
        String nullString = null;
        String notNull = "Some string";

        // act & assert
        assertNull(sut.checkNull(nullString), "Should be null");
        assertNotNull(sut.checkNull(notNull), "Should not be null");

    }

    @Test
    @DisplayName("Checks if string is the same")
    void isSame() {

        String expected = sut.getAcademy();
        var notExpected = sut.getFirstThreeLettersOfAlphabet();
        String actual = sut.getAcademyDuplicate();

        assertSame(expected, actual, "Should be the same");
        assertNotSame(notExpected, actual, "Should not be the same");
    }


    @Test
    @DisplayName("This is the multiply method")
    void multiply() {
    }



    @Test
    void isGreater() {
    }

    @Test
    void throwException() {
    }

    @Test
    void checkTimeout() {
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Called 'afterAll()' once");
    }

}