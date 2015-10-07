package com.example.s.wikibook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity {

    BookCollection books;
    BookFilterCatalog filters;

    boolean booksInitialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if(!booksInitialized){
            books.addBook(new Book("Oui-Oui à la cantine","Oui-oui Himself","Jeunesse","1994","Oui-Oui mange à la cantine","00001", R.drawable.icone));
            books.addBook(new Book("Kamasutra","God Himself","Chasse","-870","Recueil","00002",R.drawable.icone));
            books.addBook(new Book("Harry Potter et à l'école des sorciers","J.K. Rowling","Jeunesse","1992","Un jeune sorcier découvre la magie","00003",R.drawable.icone));
            books.addBook(new Book("Harry Potter et la chambre des secrets","J.K. Rowling","Jeunesse","1994","La chambre des secrets est ouverte ...","00004",R.drawable.icone));
            books.addBook(new Book("Harry Potter et le prisonnier d'Askaban","J.K. Rowling","Jeunesse","1999","Harry rencontre son oncle...","00005",R.drawable.icone));
            books.addBook(new Book("Titeuf","Zep","Jeunesse","2005","Tchô !!","00006",R.drawable.icone));
            books.addBook(new Book("Asterix","Uderzo","Tout public","1999","Ils sont fou ces romains","00007",R.drawable.icone));
            booksInitialized = true;
        }
    }

    public void displayCollection(View view)
    {
        Intent intent = new Intent(this, CollectionActivity.class);
        startActivity(intent);
    }

    public void displayBookCreator(View view)
    {
        Intent intent = new Intent(this, CreateBookActivity.class);
        startActivity(intent);
    }

    public void displayBookFilterCatalog(View view)
    {
        Intent intent = new Intent(this, BookFilterCatalogActivity.class);
        startActivity(intent);
    }

    public void displayBookFilterCreator(View view)
    {
        Intent intent = new Intent(this, CreateBookFilterActivity.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
