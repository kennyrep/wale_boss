package com.example.kennyrep.stanbic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Homepage extends AppCompatActivity {



    //TODO ****Task of the week***
    //Todo Now that you have learnt how to save information in database, there is still more to it.
    //Todo 0. During registration, also take the user job title, and a brief info about themselves
    //Todo 1. Once a user registered and they login, do the following
    //Todo 2. Display a list(RecyclerView) of the registered users (except the logged in user) with just their name and email
    //Todo 3. When a user clicks on an item(a user) on the list, display more information of the user in another activity
    //Todo 4. On the user detail page in 3, I should be able to edit(update) the user information or delete the user from the database
    //Todo 5. A deleted user should be able to login again
    //Todo 6. On the navigation drawer, display the name and email of the logged in user

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void newProspect(View view) {
        Intent newProspect = new Intent(this, NewProspect.class);
        startActivity(newProspect);

    }

    public void callPlan(View view) {
        Intent call = new Intent(this, CallPlan.class);
        startActivity(call);
    }

    public void visitor(View view) {

        Intent visit = new Intent(this, Visitor.class);
        startActivity(visit);
    }

    public void addNewProspect(View view) {

        Intent newProspect = new Intent(this, AddNewProspect.class);
        startActivity(newProspect);
    }
}
