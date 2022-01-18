package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    private Scanner scanner = new Scanner(System.in);
    private Tracker tracker = new Tracker();

    public void init() {
        boolean run = true;
        while (run) {
            showMenu();
            run = switch (requestInput()) {
                case 0 -> createItemRequest();
                case 1 -> printItemsRequest();
                case 2 -> replaceRequest();
                case 3 -> deleteRequest();
                case 4 -> getItemWithIdRequest();
                case 5 -> printItemWithName();
                case 6 -> performQuit();
                default -> true;
            };
        }
    }

    private boolean createItemRequest() {
        System.out.println("=== Create a new Item ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
        return true;
    }

    private boolean printItemsRequest() {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }

    private boolean replaceRequest() {
        System.out.println("=== Edit item ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }

    private boolean deleteRequest() {
        System.out.println("=== Delete item ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
        return true;
    }

    private boolean getItemWithIdRequest() {
        System.out.println("=== Find item by id ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }

    private boolean printItemWithName() {
        System.out.println("=== Find items by name ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }

    private boolean performQuit() {
        return false;
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    private int requestInput() {
        System.out.print("Select: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {
        new StartUI().init();
    }
}
