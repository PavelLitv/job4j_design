package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array)
                .hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list)
                .hasSize(5)
                .contains("first", "four", "three")
                .filteredOn(s -> s.length() < 5)
                .hasSize(2);
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("Anna", "Pavel", "Alexandr", "Karl", "Natali", "Pavel");
        assertThat(set)
                .hasSize(5)
                .contains("Karl")
                .allSatisfy(s -> assertThat(s).contains(String.valueOf('a')));
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("Anna", "Pavel", "Alexandr", "Karl", "Natali", "Pavel");
        assertThat(map)
                .hasSize(5)
                .containsKeys("Anna", "Natali")
                .containsValues(0, 1, 4)
                .containsEntry("Pavel", 1)
                .doesNotContainEntry("Pavel", 5);
    }
}
