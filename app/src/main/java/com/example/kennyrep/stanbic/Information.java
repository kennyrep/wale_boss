package com.example.kennyrep.stanbic;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kennyrep.stanbic.database.MyAppDatabase;
import com.example.kennyrep.stanbic.database.User;

import java.util.List;

public class Information extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView job;
    TextView phone;
    Button delete;
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        final MyAppDatabase db = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb")
                .allowMainThreadQueries()
                .build();

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", -1);
        Toast.makeText(this, "user id is " + id, Toast.LENGTH_LONG).show();

        final User users = db.myDao().getAUser(id);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        job = findViewById(R.id.job);
        phone = findViewById(R.id.phone);

        name.setText(users.getFirstName() + " " + users.getLastName());
        email.setText(users.getEmail());
        job.setText(users.getJobTitle());
        phone.setText(users.getPhoneNumber());

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int deleteAUser = db.myDao().deleteAUser(id);
                if (deleteAUser > 0) {
                    Toast.makeText(Information.this, users.getFirstName().concat(" deleted"), Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

        update = findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int update = db.myDao().update(users);
                Intent intent = new Intent(Information.this, Register.class);
                intent.putExtra("user", users);
                startActivity(intent);
            }
        });

    }
}
