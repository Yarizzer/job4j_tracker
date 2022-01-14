package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        double expected = 2;
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        Point sut = new Point(x1, y1);
        double out = sut.distance(new Point(x2, y2));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when01to00then1() {
        double expected = 1;
        int x1 = 0;
        int y1 = 1;
        int x2 = 0;
        int y2 = 0;
        Point sut = new Point(x1, y1);
        double out = sut.distance(new Point(x2, y2));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when31to10then2p23() {
        double expected = 2.23;
        int x1 = 3;
        int y1 = 1;
        int x2 = 1;
        int y2 = 0;
        Point sut = new Point(x1, y1);
        double out = sut.distance(new Point(x2, y2));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when02to20then2p82() {
        double expected = 2.82;
        int x1 = 0;
        int y1 = 2;
        int x2 = 2;
        int y2 = 0;
        Point sut = new Point(x1, y1);
        double out = sut.distance(new Point(x2, y2));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when01to22then2p23() {
        double expected = 2.23;
        int x1 = 0;
        int y1 = 1;
        int x2 = 2;
        int y2 = 2;
        Point sut = new Point(x1, y1);
        double out = sut.distance(new Point(x2, y2));
        Assert.assertEquals(expected, out, 0.01);
    }
}