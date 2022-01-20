package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

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
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input input = new StubInput(new String[] {"0", "1", "New item name", "1"});
        UserAction[] actions = {
                new EditItemAction(),
                new QuitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("ItemToDelete"));
        Input input = new StubInput(new String[] {"0", "1", "1"});
        UserAction[] actions = {
                new DeleteItemAction(),
                new QuitAction()
        };

        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}