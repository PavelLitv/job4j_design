package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterLastElement() {
        ListUtils.addAfter(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 3, 2);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIfThenUnevenNumbers() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 8));
        ListUtils.removeIf(list, i -> i % 2 == 0);
        assertThat(list).hasSize(2).containsSequence(1, 5);
    }

    @Test
    void whenReplaceIfThenEvenNumbersIsZero() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 8));
        ListUtils.replaceIf(list, i -> i % 2 == 0, 0);
        assertThat(list).hasSize(5).containsSequence(1, 0, 0, 5, 0);
    }

    @Test
    void whenRemoveAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));
        ListUtils.removeAll(list, input);
        assertThat(list).hasSize(3).containsSequence(2, 5, 8);
    }
}
