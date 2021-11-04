package ru.skillbox;

public class Book {
    private final String title;
    private final String autor;
    private final int pages;
    private final int iSBNNumber;

    public Book(String title, String autor, int pages, int iSBNNumber) {
        this.title = title;
        this.autor = autor;
        this.pages = pages;
        this.iSBNNumber = iSBNNumber;
    }
}
