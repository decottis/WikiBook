package com.example.s.wikibook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by S on 24/09/2015.
 */
public class BookCollection implements Serializable{

    ArrayList<Book> l_books;

    public BookCollection() {
        l_books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {
        return l_books;
    }

    public void addBook(Book book) {
        this.l_books.add(book);
    }

    public void setL_books(ArrayList<Book> l_books) {
        this.l_books = l_books;
    }
}
