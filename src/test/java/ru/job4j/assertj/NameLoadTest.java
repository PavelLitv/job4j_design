package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    static Stream<Arguments> provideStringsForValidateTest() {
        return Stream.of(
                Arguments.of("key:value", "%s does not contain the symbol '='"),
                Arguments.of("=value", "%s does not contain a key"),
                Arguments.of("key=", "%s does not contain a value")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForValidateTest")
    void isValidate(String name, String message) {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message.formatted(name));
    }

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void namesIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }
}