package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(4, -1);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isEqualTo("Unknown object");
    }

    @Test
    void setVertex8Then8() {
        Box box = new Box(8, 1);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isGreaterThan(0)
                .isEqualTo(8);
    }

    @Test
    void setVertex4ThenMinus1() {
        Box box = new Box(8, -1);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void isExistTrue() {
        Box box = new Box(8, 1);
        boolean isExist = box.isExist();
        assertThat(isExist)
                .isEqualTo(true)
                .isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(-1, 1);
        boolean isExist = box.isExist();
        assertThat(isExist)
                .isNotEqualTo(true)
                .isFalse();
    }

    @Test
    void whenSphereThenArea12dot57() {
        Box box = new Box(0, 1);
        double area = box.getArea();
        assertThat(area)
                .isPositive()
                .isEqualTo(12.57, withPrecision(0.01));
    }

    @Test
    void whenTetrahedronThenArea15dot58() {
        Box box = new Box(4, 3);
        double area = box.getArea();
        assertThat(area)
                .isPositive()
                .isEqualTo(15.58, withPrecision(0.01));
    }

    @Test
    void whenCubeThenArea96() {
        Box box = new Box(8, 4);
        double area = box.getArea();
        assertThat(area)
                .isPositive()
                .isEqualTo(96, withPrecision(0.01));
    }

    @Test
    void whenUnknownThenArea0() {
        Box box = new Box(7, 4);
        double area = box.getArea();
        assertThat(area)
                .isNotPositive()
                .isEqualTo(0);
    }
}
