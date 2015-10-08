package com.example.s.wikibook;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class CreateBookFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book_filter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.BookFilterCreator);
    }

    public void createBookFilter(View view){
        Map<BookFilter.FilterType, String> criteria = new HashMap<BookFilter.FilterType, String>();
        EditText name = (EditText)findViewById(R.id.CriterionName);
        EditText title = (EditText)findViewById(R.id.CriterionTitle);
        EditText author = (EditText)findViewById(R.id.CriterionAuthor);
        EditText description = (EditText)findViewById(R.id.CriterionDescription);
        EditText year = (EditText)findViewById(R.id.CriterionYear);
        EditText genre = (EditText)findViewById(R.id.CriterionGenre);
        EditText isbn = (EditText)findViewById(R.id.CriterionIsbn);

        criteria.put(BookFilter.FilterType.TITLE, title.getText().toString());
        criteria.put(BookFilter.FilterType.AUTHOR, author.getText().toString());
        criteria.put(BookFilter.FilterType.DESCRIPTION, description.getText().toString());
        criteria.put(BookFilter.FilterType.YEAR, year.getText().toString());
        criteria.put(BookFilter.FilterType.GENDER, genre.getText().toString());
        criteria.put(BookFilter.FilterType.ISBN, isbn.getText().toString());

        BookFilter newBookFilter = new BookFilter(name.getText().toString(),criteria);

        if(BookFilterCatalog.containsNamedFilter(name.getText().toString().trim())){
            Context context = getApplicationContext();
            CharSequence text = "Your book filter already exist. Change the filter name !";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            BookFilterCatalog.addBookFilter(newBookFilter);

            name.getText().clear();
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_book_filter, menu);
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
