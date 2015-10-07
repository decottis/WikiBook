package com.example.s.wikibook;

/**
 * Created by S on 24/09/2015.
 */
public class Book {

    public String title, author, genre, year, description, isbn;

    public Book(String title, String author, String genre, String year, String description, String isbn) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.description = description;
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }

    public String getGender() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
