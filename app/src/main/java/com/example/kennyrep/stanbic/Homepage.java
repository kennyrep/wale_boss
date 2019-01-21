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

import com.example.kennyrep.stanbic.AddNewProspect;
import com.example.kennyrep.stanbic.CallPlan;
import com.example.kennyrep.stanbic.NewProspect;
import com.example.kennyrep.stanbic.R;
import com.example.kennyrep.stanbic.Visitor;

public class Homepage extends AppCompatActivity {

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
