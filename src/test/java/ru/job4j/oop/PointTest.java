package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        double expected = 2;
        Point sut = new Point(0, 0);
        double out = sut.distance(new Point(2, 0));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when01to00then1() {
        double expected = 1;
        Point sut = new Point(0, 1);
        double out = sut.distance(new Point(0, 0));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when31to10then2p23() {
        double expected = 2.23;
        Point sut = new Point(3, 1);
        double out = sut.distance(new Point(1, 0));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when02to20then2p82() {
        double expected = 2.82;
        Point sut = new Point(0, 2);
        double out = sut.distance(new Point(2, 0));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when01to22then2p23() {
        double expected = 2.23;
        Point sut = new Point(0, 1);
        double out = sut.distance(new Point(2, 2));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when020to212then2p23() {
        double expected = 2.23;
        Point sut = new Point(0, 2, 0);
        double out = sut.distance(new Point(2, 1, 2));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when010to333then3p60() {
        double expected = 3.60;
        Point sut = new Point(0, 1, 0);
        double out = sut.distance(new Point(3, 3, 3));
        Assert.assertEquals(expected, out, 0.01);
    }
}