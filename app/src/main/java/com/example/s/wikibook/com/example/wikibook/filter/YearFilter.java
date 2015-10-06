package com.example.s.wikibook.com.example.wikibook.filter;

import com.example.s.wikibook.Book;

/**
 * Created by Geoffrey on 06/10/2015.
 */
public class YearFilter extends BookFilter {
    public YearFilter(String toSearch){
        super(toSearch);
    }

    @Override
    public boolean isSelected(Book book) {
        if(book.getYear().toLowerCase().contains(toSearch.toLowerCase())){
            return true;
        }
        return false;
    }
}
