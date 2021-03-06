package com.example.kennyrep.stanbic;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kennyrep.stanbic.database.MyAppDatabase;
import com.example.kennyrep.stanbic.database.User;

import static com.example.kennyrep.stanbic.Register.FirstName;
import static com.example.kennyrep.stanbic.Register.LastName;
import static com.example.kennyrep.stanbic.Register.firstName;
import static com.example.kennyrep.stanbic.Register.myAppDatabase;

public class NavDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView name2;
    TextView email2;
    View hview;
    SharedPreferences preferences;
    MyAppDatabase db;
    //MainActivity mymainactivity = new MainActivity();

    //Todo Nice work here. Well done!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        db = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb")
                .allowMainThreadQueries()
                .build();

        // User users = db.myDao().getAUser(id);


        name2 = findViewById(R.id.username);
        email2 = findViewById(R.id.useremail);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(NavDrawerActivity.this, ShowUser.class);
//                startActivity(intent);
//            }
//        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        hview = navigationView.getHeaderView(0);
        name2 = (TextView) hview.findViewById(R.id.username);
        email2 = (TextView) hview.findViewById(R.id.useremail);

        if (preferences.contains("current")) {
            String email = preferences.getString("current", "");
            User user = db.myDao().loadonewithmail(email);
            if (user != null) {
                name2.setText(user.getFirstName() + " " + user.getLastName());
                email2.setText(user.getEmail());
            } else {
                finish();
            }        }
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if
                (id == R.id.nav_gallery) {

        } else if
                (id == R.id.nav_slideshow) {

        } else if
                (id == R.id.nav_manage) {

        } else if
                (id == R.id.nav_share) {

        } else if
                (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
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


    public void homepage(MenuItem item) {
        Intent intent = new Intent(this, NavDrawerActivity.class);
        startActivity(intent);
    }

    public void newProspect(MenuItem item) {
        Intent intent = new Intent(this, NewProspect.class);
        startActivity(intent);
    }

    public void callPlan(MenuItem item) {
        Intent intent = new Intent(this, CallPlan.class);
        startActivity(intent);
    }

    public void visitReport(MenuItem item) {
        Intent intent = new Intent(this, VisitorInformation.class);
        startActivity(intent);
    }
}
