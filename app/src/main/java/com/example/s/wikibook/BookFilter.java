package com.example.s.wikibook;

import com.example.s.wikibook.Book;

import java.util.Map;

/**
 * Created by Geoffrey on 06/10/2015.
 */
public class BookFilter{

    public enum FilterType{
        TITLE, AUTHOR, YEAR, GENDER, DESCRIPTION, ISBN
    }
    private Map<FilterType, String> criteria;

    public BookFilter(Map<FilterType, String> criteria){
        this.criteria = criteria;
    }

    public boolean isSelected(Book book){
        String tCrit = getCriterion(FilterType.TITLE);
        if(!book.getTitle().toLowerCase().contains(tCrit.toLowerCase())){
            return false;
        }
        String tAuthor = getCriterion(FilterType.AUTHOR);
        if(!book.getAuthor().toLowerCase().contains(tAuthor.toLowerCase())){
            return false;
        }
        String tYEAR = getCriterion(FilterType.YEAR);
        if(!book.getYear().toLowerCase().contains(tYEAR.toLowerCase())){
            return false;
        }
        String tGender = getCriterion(FilterType.GENDER);
        if(!book.getGenre().toLowerCase().contains(tGender.toLowerCase())){
            return false;
        }
        String tDescription = getCriterion(FilterType.DESCRIPTION);
        if(!book.getDescription().toLowerCase().contains(tDescription.toLowerCase())){
            return false;
        }
        String tISBN = getCriterion(FilterType.ISBN);
        if(!book.getDescription().toLowerCase().contains(tISBN.toLowerCase())){
            return false;
        }
        return true;
    }

    private String getCriterion(FilterType filterType){
        return (criteria.get(filterType) != null) ? criteria.get(filterType) : "";
    }

}
