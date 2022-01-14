package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max sut = new Max();
        int result = sut.max(1, 2);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax3To2Then3() {
        Max sut = new Max();
        int result = sut.max(3, 2);
        int expected = 3;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax4To4Then4() {
        Max sut = new Max();
        int result = sut.max(4, 4);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax324Then4() {
        Max sut = new Max();
        int result = sut.max(3, 2, 4);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax4322Then4() {
        Max sut = new Max();
        int result = sut.max(4, 3, 2, 2);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }
}