package ru.job4j.lambda;


import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiapasonCountTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        DiapasonCount function = new DiapasonCount();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSqrFunctionThenLinearResults() {
        DiapasonCount function = new DiapasonCount();
        List<Double> result = function.diapason(5, 8, x -> x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(36D, 49D, 64D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExpFunctionThenLinearResults() {
        DiapasonCount function = new DiapasonCount();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}