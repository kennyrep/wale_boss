package com.example.kennyrep.stanbic;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import com.example.kennyrep.stanbic.database.MyAppDatabase;
import com.example.kennyrep.stanbic.database.User;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ShowUser extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
//    ArrayList<User> users;
public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        FloatingActionButton fab1 = findViewById(R.id.fab);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowUser.this, Homepage.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerview);
        MyAppDatabase db = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb")
                .allowMainThreadQueries()
                .build();


        List<User> users = db.myDao().getAllUsers();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);
    }
}