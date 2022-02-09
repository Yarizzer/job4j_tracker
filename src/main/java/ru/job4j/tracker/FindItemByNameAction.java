package ru.job4j.tracker;

import java.util.ArrayList;

public class FindItemByNameAction implements UserAction {
    private final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        ArrayList<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            items.forEach((item) -> out.println(item));
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
