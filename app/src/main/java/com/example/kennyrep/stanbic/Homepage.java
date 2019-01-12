package com.example.kennyrep.stanbic;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    public void doThis(MenuItem item){
        Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show();
    }

    public void notify (MenuItem item){
        Toast.makeText(this, "Notification Clicked", Toast.LENGTH_LONG).show();
    }

    public void option (MenuItem item){
        Toast.makeText(this, "Option Clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
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
