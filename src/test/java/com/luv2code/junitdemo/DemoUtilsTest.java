package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class) // Responsible with the generation of test names (optional to @DisplayName)
@TestMethodOrder(MethodOrderer.Random.class) // Responsible with the order of test execution
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
    @Order(-1) //you can also declare your custom order; the lowest value has the highest priority --> will be executed first
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
    @Order(2)
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
        String actual = sut.getAcademyDuplicate();

        assertSame(expected, actual, "Should be the same");
    }

    @Test
    @DisplayName("Array equals")
    void testArrayEquals() {
        String[] expected = {"A", "B", "C"};
        assertArrayEquals(expected, sut.getFirstThreeLettersOfAlphabet(), "Should be the same");
    }

    @Test
    @DisplayName("List equals")
    void testIterableEquals() {
        var expected = List.of("luv", "2", "code");
        assertIterableEquals(expected, sut.getAcademyInList(), "Should be the same");
    }


    @Test
    @DisplayName("This is the multiply method")
    void multiply() {
        int expected = 15;
        int actual = sut.multiply(5, 3);
        assertEquals(expected, actual, "5 * 3 should equal 15");
        assertNotEquals(24, actual, "Should not equal 25");
    }



    @Test
    void isGreater() {
    }

    @Test
    @DisplayName("Test if Exception is thrown")
    void throwException() {
        assertThrows(Exception.class, () -> sut.throwException(-1), "Should throw");
        assertDoesNotThrow(() ->  sut.throwException(1), "Should not throw");
    }

    @Test
    @DisplayName("Test if method resumes execution after timeout expires")
    void checkTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> sut.checkTimeout(),
                "Should resume after 2 seconds");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Called 'afterAll()' once");
    }

}