package ru.job4j.ex;

import org.junit.Test;
import static org.junit.Assert.assertThat;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenNIsNegative() {
        Fact sut = new Fact();
        sut.calc(-3);
    }
}