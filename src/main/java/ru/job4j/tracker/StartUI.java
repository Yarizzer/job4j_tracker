package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = requestInput(scanner);
            if (select == 0) {
                createItemRequest(scanner, tracker);
            } else if (select == 1) {
                printItemsRequest(scanner, tracker);
            } else if (select == 2) {
                replaceRequest(scanner, tracker);
            } else if (select == 3) {
                deleteRequest(scanner, tracker);
            } else if (select == 4) {
                getItemWithIdRequest(scanner, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void createItemRequest(Scanner scanner, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    private void printItemsRequest(Scanner scanner, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
    }

    private void replaceRequest(Scanner scanner, Tracker tracker) {
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
    }

    private void deleteRequest(Scanner scanner, Tracker tracker) {
        System.out.println("=== Delete item ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    private void getItemWithIdRequest(Scanner scanner, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
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

    private int requestInput(Scanner scanner) {
        System.out.print("Select: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
