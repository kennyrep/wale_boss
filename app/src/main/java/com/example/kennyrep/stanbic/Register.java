package com.example.kennyrep.stanbic;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.MyAppDatabase;
import com.User;

public class Register extends AppCompatActivity {

    public static MyAppDatabase myAppDatabase;

    private EditText full_name, email, phone_no, password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb").allowMainThreadQueries().build();
        onCreateView();

        //Showing the number user in the database in a Toast message
        User[] u = myAppDatabase.myDao().load();
        Toast.makeText(this, String.valueOf(u.length), Toast.LENGTH_SHORT).show();
    }


    public void onCreateView(){

        full_name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone_no = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        register = findViewById(R.id.buttonsign);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Full_name = full_name.getText().toString();
                String Email = email.getText().toString();
                String Phone_no = (phone_no.getText().toString());
                String Password = password.getText().toString();

                User user = new User();
                user.setFullName(Full_name);
                user.setEmail(Email);
                user.setPhoneNumber(Phone_no);
                user.setPassword(Password);

                Register.myAppDatabase.myDao().addUser(user);
                Toast.makeText(Register.this, "User Successfully Added", Toast.LENGTH_SHORT).show();

                full_name.setText("");
                email.setText("");
                phone_no.setText("");
                password.setText("");
            }
        });


    }

    public void registerSignIn(View view) {
            Intent signup2 = new Intent(this, MainActivity.class);
            startActivity(signup2);
        }
    }
