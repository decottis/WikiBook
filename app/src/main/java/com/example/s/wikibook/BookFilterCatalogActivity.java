package com.example.s.wikibook;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
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
    int lastItemClicked = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ListView bookList = (ListView)findViewById(R.id.bookFilterList);
        List<Map<String, String>> l_filter = new ArrayList<Map<String, String>>();

        for( BookFilter bookFilter : BookFilterCatalog.getBookFilters()) {
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

        SimpleAdapter listAdapter = new SimpleAdapter(this.getBaseContext(), l_filter, R.layout.book_filter_detail,
                new String[] {"name", "author", "title", "gender","isbn", "year", "description"},
                new int[] {R.id.filterName, R.id.author, R.id.title, R.id.gender, R.id.isbn, R.id.year, R.id.description});

        bookList.setAdapter(listAdapter);
        /*bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                ActionBar actionBar = getSupportActionBar();
                actionBar.show();
                HashMap<String,String> map = (HashMap<String,String>)parent.getItemAtPosition(position);
                actionBar.setTitle(map.get("title"));
                lastItemClicked = position;
                System.out.println(position +"   " + id);
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar_book, menu);

        return super.onCreateOptionsMenu(menu);
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

        return super.onOptionsItemSelected(item);
    }
}
