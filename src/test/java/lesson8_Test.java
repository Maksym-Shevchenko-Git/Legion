import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

import lesson8.Lesson_8;

public class lesson8_Test {
    //positive tests
    @ParameterizedTest
    @CsvSource({"1,Sunday",
            "2, Monday",
            "3,Tuesday",
            "4,Wednesday",
            "5,Thursday",
            "6,Friday",
            "7,Saturday"})
    public void positiveTest(int dayNumber, String expectedResult) {

        String actualResult = Lesson_8.getDay(dayNumber);
        assertEquals(expectedResult, actualResult);
    }

    //negative tests
    @ParameterizedTest
    @CsvSource({"0,The number should be equal or larger than 1",
            "8, The number should be equal or smaller than 7",
            "-5,The number should be equal or larger than 1"})
    public void negativeTest(int dayNumber, String expectedResult) {

        String actualResult = Lesson_8.getDay(dayNumber);
        assertEquals(expectedResult, actualResult);
    }

    //null test
    @Test
    public void nullTest() {
        assertThrows(NullPointerException.class, () -> Lesson_8.getDay(null));
    }

    //String as int Tests
    @ParameterizedTest
    @CsvSource({"sdf",
            "-5a",
            "1.55",
            "(*^&%$"})
    public void incorrectInputTest(String dayNumber) {
        assertThrows(NumberFormatException.class, () -> Integer.valueOf(dayNumber));
    }
}

