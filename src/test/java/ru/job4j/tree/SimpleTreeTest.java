package ru.job4j.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTreeTest {

    @Test
    void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6)).isPresent();
    }

    @Test
    void whenElFindNotExistThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7)).isEmpty();
    }

    @Test
    void whenChildExistOnLeafThenNotAdd() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.add(2, 6)).isFalse();
    }

    @Test
    void whenParentNotExistThenNotAdd() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertThat(tree.add(2, 6)).isFalse();
    }

    @Test
    void whenParentNotExistAndChildExistThenNotAdd() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertThat(tree.add(2, 1)).isFalse();
    }

    @Test
    void whenBinaryTreeThenIsBinaryTrue() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        tree.add(2, 6);
        tree.add(2, 7);
        assertThat(tree.isBinary()).isTrue();
    }

    @Test
    void whenNotBinaryTreeThenIsBinaryFalse() {
        SimpleTree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        tree.add(2, 6);
        tree.add(2, 7);
        tree.add(2, 8);
        assertThat(tree.isBinary()).isFalse();
    }
}
