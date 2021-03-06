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

    private static int selectedBookFilter;

    public static List<BookFilter> getBookFilters(){

        return filters;
    }

    public static void addBookFilter(BookFilter bookFilter){
        filters.add(bookFilter);
    }

    public static void addBookFilter(int location, BookFilter bookFilter){

        filters.add(location, bookFilter);
    }

    public static BookFilter removeBookFilter(int filterId){
        return filters.remove(filterId);
    }

    public static int removeBookFilter(BookFilter bookFilter){
        int index = filters.indexOf(bookFilter);
        filters.remove(bookFilter);
        return index;
    }

    public static BookFilter getSelectedBookFilter(){
        return filters.get(selectedBookFilter);
    }

    public static boolean containsNamedFilter(String name){
        for(BookFilter bookFilter : filters){
            if(bookFilter.getName().toLowerCase().equals(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public static void setSelectedBookFilter(BookFilter bookFilter){
       selectedBookFilter = filters.indexOf(bookFilter);
    }

    public static void setSelectedBookFilter(int bookFilterId){
        selectedBookFilter = bookFilterId;
    }

    public static boolean isEmpty(){
        return filters == null || filters.isEmpty();
    }
}
