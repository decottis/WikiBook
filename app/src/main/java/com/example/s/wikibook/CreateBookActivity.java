package com.example.s.wikibook;

import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateBookActivity extends AppCompatActivity {

    private ImageSwitcher switcher;
    private Button b1, b2;
    private int[] drawables = new int[]{R.drawable.icone, R.drawable.icone2};
    public int cpt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.BookCreator);

        switcher = (ImageSwitcher)findViewById(R.id.imageSwitcher1);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        //init the Image switcher

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                return myView;
            }
        });

        switcher.setImageResource(drawables[cpt]);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);

        //button next/previous image
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDrawable("previous");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDrawable("next");
            }
        });
    }

    public void createBook(View view)
    {

        EditText title = (EditText)findViewById(R.id.EditTitle);
        EditText author = (EditText)findViewById(R.id.EditAuthor);
        EditText description = (EditText)findViewById(R.id.EditDescription);
        EditText year = (EditText)findViewById(R.id.EditYear);
        EditText genre = (EditText)findViewById(R.id.EditGenre);
        EditText isbn = (EditText)findViewById(R.id.EditIsbn);

        String s_title = (!title.getText().toString().isEmpty()) ? title.getText().toString() : getResources().getString(R.string.u_title);
        String s_author = (!author.getText().toString().isEmpty()) ? author.getText().toString() : getResources().getString(R.string.u_author);
        String s_description = (!description.getText().toString().isEmpty()) ? description.getText().toString() : getResources().getString(R.string.u_description);
        String s_year= (!year.getText().toString().isEmpty()) ? year.getText().toString() : getResources().getString(R.string.u_year);
        String s_genre = (!genre.getText().toString().isEmpty()) ? genre.getText().toString() : getResources().getString(R.string.u_genre);
        String s_isbn = (!isbn.getText().toString().isEmpty()) ? isbn.getText().toString() : getResources().getString(R.string.u_isbn);

        Book newBook = new Book(s_title,
                                s_author,
                                s_description,
                                s_year,
                                s_genre,
                                s_isbn,
                                drawables[cpt]);


        BookCollection.addBook(newBook);

        title.getText().clear();
        author.getText().clear();
        description.getText().clear();
        year.getText().clear();
        genre.getText().clear();
        isbn.getText().clear();


        Context context = getApplicationContext();
        CharSequence text = "Your book has been created";
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

    public void setDrawable(String type)
    {
        if(type.equals("previous")) {
            if (this.cpt - 1 >= 0) {
                this.cpt--;

            } else {
                this.cpt = drawables.length -1;
            }

        } else {
            if (this.cpt + 1 < drawables.length) {
                this.cpt++;

            } else {
                this.cpt = 0;
            }
        }
        switcher.setImageResource(drawables[this.cpt]);
    }
}
