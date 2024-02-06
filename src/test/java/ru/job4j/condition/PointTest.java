package ru.job4j.condition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    void when00To20Then2() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 2);
        double out = first.distance(second);
        double expected = 2.0;
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when510To1258Then48dot50() {
        Point first = new Point(5, 10);
        Point second = new Point(12, 58);
        double out = first.distance(second);
        double expected = 48.50;
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when64minus128To256512Then668dot17() {
        Point first = new Point(64, -128);
        Point second = new Point(256, 512);
        double out = first.distance(second);
        double expected = 668.17;
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void when024To3612Then9dot43() {
        Point first = new Point(0, 2, 4);
        Point second = new Point(3, 6, 12);
        double out = first.distance3d(second);
        double expected = 9.43;
        Assertions.assertEquals(out, expected, 0.01);
    }

    @Test
    public void when554322To3854Then9dot43() {
        Point first = new Point(55, 43, 22);
        Point second = new Point(3, 8, 54);
        double out = first.distance3d(second);
        double expected = 70.37;
        Assertions.assertEquals(out, expected, 0.01);
    }
}