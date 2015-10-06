package com.example.s.wikibook.com.example.wikibook.filter;

import com.example.s.wikibook.Book;

/**
 * Created by Geoffrey on 06/10/2015.
 */
public class ISBNFilter extends BookFilter {
    public ISBNFilter(String toSearch){
        super(toSearch);
    }

    @Override
    public boolean isSelected(Book book) {
        if(book.getIsbn().toLowerCase().contains(toSearch.toLowerCase())){
            return true;
        }
        return false;
    }
}
