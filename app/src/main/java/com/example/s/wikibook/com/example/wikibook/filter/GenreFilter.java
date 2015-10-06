package com.example.s.wikibook.com.example.wikibook.filter;

import com.example.s.wikibook.Book;

/**
 * Created by Geoffrey on 06/10/2015.
 */
public class GenreFilter extends BookFilter {
    public GenreFilter(String toSearch){
        super(toSearch);
    }

    @Override
    public boolean isSelected(Book book) {
        if(book.getGenre().toLowerCase().contains(toSearch.toLowerCase())){
            return true;
        }
        return false;
    }
}
