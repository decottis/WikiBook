package com.example.s.wikibook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geoffrey on 07/10/2015.
 */
public class BookFilterCatalog {
    private static List<BookFilter> filters = new ArrayList<BookFilter>();

    public BookFilterCatalog(){
        filters = new ArrayList<BookFilter>();
    }

    private static BookFilter selectedBookFilter;

    public static List<BookFilter> getBookFilters(){

        return filters;
    }

    public static void addBookFilter(BookFilter bookFilter){
        filters.add(bookFilter);
    }

    public static void addBookFilter(int location, BookFilter bookFilter){

        filters.add(location, bookFilter);
    }

    public static void removeBookFilter(int filterId){

        filters.remove(filterId);
    }

    public static BookFilter getSelectedBookFilter(){

        return selectedBookFilter;
    }

    public static void setSelectedBookFilter(BookFilter bookFilter){
       selectedBookFilter = bookFilter;
    }

    public static void setSelectedBookFilter(int bookFilterId){
        selectedBookFilter = filters.get(bookFilterId);
    }

    public static boolean isEmpty(){
        return filters == null || filters.isEmpty();
    }
}
