package ru.job4j.kiss.fool;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FoolTest {
    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(3, "Fizz"),
                Arguments.of(9, "Fizz"),
                Arguments.of(5, "Buzz"),
                Arguments.of(25, "Buzz"),
                Arguments.of(15, "FizzBuzz"),
                Arguments.of(60, "FizzBuzz")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void test(int number, String expected) {
        String actual = Fool.getAnswer(number);
        assertThat(actual).isEqualTo(expected);
    }
}
