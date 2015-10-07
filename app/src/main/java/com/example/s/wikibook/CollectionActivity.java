package com.example.s.wikibook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.view.menu.ActionMenuItemView;
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

    final String BOOK_TO_EDIT = "book_edit";
    int lastItemClicked = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        majListBook();
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        ActionBar actionBar = getSupportActionBar();
        lastItemClicked = -1;
        actionBar.setTitle("WikiBook");
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
                HashMap<String, String> map = (HashMap<String, String>) parent.getItemAtPosition(position);
                actionBar.setTitle(map.get("title"));
                lastItemClicked = position;
                System.out.println(position + "   " + id);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar_book, menu);

        if(BookCollection.getBooks().size() == 0) {
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(false);
        }

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
        if(id == R.id.action_edit) {
            editAction();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void deleteAction() {
        if(lastItemClicked != -1) {
            BookCollection.getBooks().remove(lastItemClicked);
            majListBook();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("WikiBook");
            if (BookCollection.getBooks().size() == 0) {
                ActionMenuItemView menuItem = (ActionMenuItemView) findViewById(R.id.action_del);
                menuItem.setVisibility(View.INVISIBLE);
                menuItem = (ActionMenuItemView) findViewById(R.id.action_edit);
                menuItem.setVisibility(View.INVISIBLE);
            }
            lastItemClicked = -1;
        }
    }

    public void editAction() {
        if(lastItemClicked != -1) {
            Intent intent = new Intent(this, EditBookActivity.class);
            intent.putExtra(BOOK_TO_EDIT, lastItemClicked);
            startActivity(intent);
        }
    }
}
