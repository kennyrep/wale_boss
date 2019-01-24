package com.example.kennyrep.stanbic;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kennyrep.stanbic.database.MyAppDatabase;
import com.example.kennyrep.stanbic.database.User;

public class Register extends AppCompatActivity {

    public static MyAppDatabase myAppDatabase;

    //TODO Naming convention for variables should be PascalCasing, e.g full_name should be fullName
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

                //TODO Ensure the required fields are provided before creating the user. Similar to what i said for the login section
                //TODO I was able to register a user without even providing anything
                //Todo Asides from not being empty, Make sure the following constraints are enforced before registering the user
                //Todo 1. Must be a valid email, Phone number must be 11 digits,
                // Todo Password must be greater that 6 six characters, must contain a number, must contain an Upper Case, must contain a symbol
                //Todo Dont allow registration until and unless user accept terms and conditions
                //Todo Display a dialog instead of toast after successful registration and take the user back to login screen automatically

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
