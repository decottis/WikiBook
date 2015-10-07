package com.example.s.wikibook;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
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

public class CollectionActivity extends ActionBarActivity {
    int lastItemClicked = -1;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        majListBook();
    }
    private void majListBook() {
        ListView bookList = (ListView) findViewById(R.id.bookList);
        List<Map<String, String>> l_books = new ArrayList<Map<String, String>>();

        for (Book book : BookCollection.getBooks()) {
            Map<String, String> bookMap = new HashMap<String, String>();
            bookMap.put("img", String.valueOf(book.getId_img())); // use available img
            bookMap.put("author", book.getAuthor());
            bookMap.put("title", book.getTitle());
            bookMap.put("gender", book.getGender());
            bookMap.put("isbn", book.getIsbn());
            bookMap.put("year", book.getYear());
            bookMap.put("description", book.getDescription());
            l_books.add(bookMap);
        }

        SimpleAdapter listAdapter = new SimpleAdapter(this.getBaseContext(), l_books, R.layout.book_detail,
                /*ajout gender*/
                new String[] {"img", "author", "title", "gender", "isbn", "year", "description"},
                new int[] {R.id.img_cover, R.id.author, R.id.title, R.id.gender, R.id.isbn, R.id.year, R.id.description});

        bookList.setAdapter(listAdapter);
        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        });
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
        if (id == R.id.action_del) {
            deleteAction();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void deleteAction() {
        BookCollection.getBooks().remove(lastItemClicked);
        majListBook();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        actionBar.hide();
    }
}
