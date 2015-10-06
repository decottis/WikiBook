package com.example.s.wikibook.com.example.wikibook.filter;

import com.example.s.wikibook.Book;

/**
 * Created by Geoffrey on 06/10/2015.
 */
public abstract class BookFilter{

    protected String toSearch;

    public BookFilter(String toSearch){
        this.toSearch = toSearch;
    }

    public abstract boolean isSelected(Book book);

}
