package ru.job4j.tracker;

import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        Input input = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new QuitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Input input = new StubInput(new String[] {"0", "new item", "1", "1", "edited item", "2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new EditItemAction(),
                new QuitAction()
        };
        new StartUI().init(input, tracker, actions);
        Item edited = tracker.findById(1);
        assertThat(edited.getName(), is("edited item"));
    }

    @Test
    public void whenDeleteItem() {
        Input input = new StubInput(new String[] {"0", "new item", "1", "1", "2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new DeleteIItemAction(),
                new QuitAction()
        };

        new StartUI().init(input, tracker, actions);
        assertNull(tracker.findById(1));
    }
}