package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ItemDescByNameTest {
    @Test
    public void whenSortItems() {
        Item a = new Item("A");
        Item b = new Item("B");
        Item c = new Item("C");
        Item d = new Item("D");
        List<Item> items = new ArrayList<>();
        items.add(a);
        items.add(d);
        items.add(b);
        items.add(c);
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(d);
        expected.add(c);
        expected.add(b);
        expected.add(a);
        assertArrayEquals(items.toArray(), expected.toArray());
    }
}