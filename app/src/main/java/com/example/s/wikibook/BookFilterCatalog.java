package com.example.s.wikibook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geoffrey on 07/10/2015.
 */
public class BookFilterCatalog {
    private static List<BookFilter> filters = new ArrayList<BookFilter>();

    public static List<BookFilter> getBookFilters(){
        return filters;
    }

    public static void addBookFilter(BookFilter bookFilter){
        filters.add(bookFilter);
    }

    public static void removeBookFilter(BookFilter filter){
        filters.remove(filter);
    }
}
