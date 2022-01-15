package ru.job4j.pojo;

public class Library {
    private static Book[] getModel() {
        Book first = new Book("Clean code", 10);
        Book second = new Book("second", 4);
        Book third = new Book("third", 19);
        Book fourth = new Book("fourth", 21);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        return books;
    }

    public static void main(String[] args) {
        Book[] books = getModel();
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " with index " + i);
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book book : books) {
            if (book.getTitle() == "Clean code") {
                System.out.println(book.getTitle() + " pages count " + book.getPagesCount());
            }
        }
    }
}
