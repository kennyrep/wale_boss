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
        

        recyclerView = findViewById(R.id.recyclerview);
//        users = new ArrayList<>();
//        for (int i = 0; i < 100 ; i++) {
//            User user = new User("Audu Kehinde", "kenny12@gmail.com", "bethebest", "08134257687");
//            users.add(user);
//        }

        MyAppDatabase db = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb")
                .allowMainThreadQueries()
                .build();
       

        List<User> users = db.myDao().getAllUsers();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);
    }
}