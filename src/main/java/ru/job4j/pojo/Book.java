package ru.job4j.pojo;

public class Book {
    private String title;
    private int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPagesCount() {
        return pages;
    }

    public void setPagesCount(int pages) {
        this.pages = pages;
    }
}
