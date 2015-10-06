package com.example.s.wikibook;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class CreateBookFilterActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book_filter);
    }

    public void createBookFilter(View view)
    {
        Map<BookFilter.FilterType, String> criteria = new HashMap<BookFilter.FilterType, String>();
        EditText title = (EditText)findViewById(R.id.EditTitle);
        EditText author = (EditText)findViewById(R.id.EditAuthor);
        EditText description = (EditText)findViewById(R.id.EditDescription);
        EditText year = (EditText)findViewById(R.id.EditYear);
        EditText genre = (EditText)findViewById(R.id.EditGenre);
        EditText isbn = (EditText)findViewById(R.id.EditIsbn);

        criteria.put(BookFilter.FilterType.TITLE, title.getText().toString());
        criteria.put(BookFilter.FilterType.AUTHOR, author.getText().toString());
        criteria.put(BookFilter.FilterType.DESCRIPTION, description.getText().toString());
        criteria.put(BookFilter.FilterType.YEAR, year.getText().toString());
        criteria.put(BookFilter.FilterType.GENDER, genre.getText().toString());
        criteria.put(BookFilter.FilterType.ISBN, isbn.getText().toString());

        BookFilter newBookFilter = new BookFilter(criteria);

        BookFilterCatalog.addBookFilter(newBookFilter);

        title.getText().clear();
        author.getText().clear();
        description.getText().clear();
        year.getText().clear();
        genre.getText().clear();
        isbn.getText().clear();

        Context context = getApplicationContext();
        CharSequence text = "Your book filter has been created";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_book, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
