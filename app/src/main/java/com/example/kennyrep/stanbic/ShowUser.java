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
    UserAdapter adapter;
    List<User> users;
    //    ArrayList<User> users;
    public static MyAppDatabase myAppDatabase;
    MyAppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        FloatingActionButton fab1 = findViewById(R.id.fab);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowUser.this, NavDrawerActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerview);
        db = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb")
                .allowMainThreadQueries()
                .build();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(this, new ArrayList<User>());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        users = db.myDao().getAllUsers();
        adapter.setData(users);
        adapter.notifyDataSetChanged();
    }
}