package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public void info() {
        System.out.println("active - " + active + ", status - " + status + ", message - " + message);
    }

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(true, 1, "Second error");
        Error third = new Error(false, 3, "Third error");
        Error fourth = new Error(true, 3, "Fourth error");
        first.info();
        second.info();
        third.info();
        fourth.info();
    }
}
