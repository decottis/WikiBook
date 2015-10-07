package com.example.s.wikibook;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookFilterCatalogActivity extends AppCompatActivity {
    private int lastItemClicked = -1;
    private Menu menu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_filter_catalog);
        majFilterBookList();
    }

    @Override
    protected void onResume(){
        super.onResume();
        majFilterBookList();
    }

    public void majFilterBookList(){
        ListView bookFilterList = (ListView)findViewById(R.id.bookFilterList);
        List<Map<String, String>> l_filter = new ArrayList<Map<String, String>>();
        checkAnModifyMenuItemsVisibility();
        if(BookFilterCatalog.isEmpty()){
            ActionBar actionBar = getSupportActionBar();
            //actionBar.show();
            actionBar.setTitle(this.getTitle());
        } else {
            for (BookFilter bookFilter : BookFilterCatalog.getBookFilters()) {
                Map<String, String> bookMap = new HashMap<String, String>();
                bookMap.put("name", bookFilter.getName());
                bookMap.put("author", bookFilter.getCriterion(BookFilter.FilterType.AUTHOR));
                bookMap.put("title", bookFilter.getCriterion(BookFilter.FilterType.TITLE));
                bookMap.put("gender", bookFilter.getCriterion(BookFilter.FilterType.GENDER));
                bookMap.put("isbn", bookFilter.getCriterion(BookFilter.FilterType.ISBN));
                bookMap.put("year", bookFilter.getCriterion(BookFilter.FilterType.YEAR));
                bookMap.put("description", bookFilter.getCriterion(BookFilter.FilterType.DESCRIPTION));
                l_filter.add(bookMap);
            }
        }
        SimpleAdapter listAdapter = new SimpleAdapter(this.getBaseContext(), l_filter, R.layout.book_filter_detail,
                new String[] {"name", "author", "title", "gender","isbn", "year", "description"},
                new int[] {R.id.filterName, R.id.filterAuthor, R.id.filterTitle, R.id.filterGender, R.id.filterIsbn, R.id.filterYear, R.id.filterDescription});
        bookFilterList.setAdapter(listAdapter);
        bookFilterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                ActionBar actionBar = getSupportActionBar();
                actionBar.show();
                HashMap<String, String> map = (HashMap<String, String>) parent.getItemAtPosition(position);
                actionBar.setTitle(map.get("name"));
                lastItemClicked = position;
                System.out.println(position + "   " + id);
            }
        });
    }

    private void checkAnModifyMenuItemsVisibility(){
        if(BookFilterCatalog.isEmpty()){
            if(menu != null) {
                menu.getItem(0).setVisible(false);
                menu.getItem(1).setVisible(false);
                menu.getItem(2).setVisible(false);
            }
        } else {
            if(menu != null) {
                menu.getItem(0).setVisible(true);
                menu.getItem(1).setVisible(true);
                menu.getItem(2).setVisible(true);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_filter_catalog, menu);
        this.menu = menu;
        checkAnModifyMenuItemsVisibility();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.filter_action_see) {
            actionDisplay();
            return true;
        }

        if (id == R.id.filter_action_edit) {
            actionEdit();
            return true;
        }

        if (id == R.id.filter_action_del) {
            actionDelete();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void actionDelete(){
        BookFilterCatalog.removeBookFilter(lastItemClicked);
        majFilterBookList();
    }

    private void actionDisplay(){
        BookFilterCatalog.setSelectedBookFilter(lastItemClicked);
        Intent intent = new Intent(this, FiltredCollectionActivity.class);
        startActivity(intent);
    }

    private void actionEdit(){
        BookFilterCatalog.setSelectedBookFilter(lastItemClicked);
        Intent intent = new Intent(this, EditBookFilterActivity.class);
        startActivity(intent);
    }
}
