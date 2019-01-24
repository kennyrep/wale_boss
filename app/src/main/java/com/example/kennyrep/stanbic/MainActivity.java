package com.example.kennyrep.stanbic;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kennyrep.stanbic.database.MyAppDatabase;
import com.example.kennyrep.stanbic.database.User;

public class MainActivity extends AppCompatActivity {

    //TODO Naming convention for variables should be PascalCasing, e.g full_name should be fullName
    private static Button btn_new;
    private static Button btn_dont;

    public static MyAppDatabase myAppDatabase;

    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO Ensure there is a ScrollView in the layout and make sure it works
        setContentView(R.layout.activity_main);
        onClickListener();

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb").allowMainThreadQueries().build();
    }

    public void onClickListener() {
        btn_new = (Button) findViewById(R.id.buttonsign);
        final EditText emailEditText = findViewById(R.id.email);
        final EditText passwordEdittext = findViewById(R.id.password);
        btn_new.setOnClickListener(
                new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {

                        email = emailEditText.getText().toString();
                        password = passwordEdittext.getText().toString();
                        //TODO Ensure the email and password are provided before making attempt to login
                        //something like below
                        if(TextUtils.isEmpty(email)){
                            emailEditText.setError("Email is required.");
                        }
                        User user = myAppDatabase.myDao().loadone(email, password);
                        if (user == null){
                            Toast.makeText(MainActivity.this, "user not found", Toast.LENGTH_SHORT).show();
                        }else {

                            Intent i = new Intent(".congratulations");
                            startActivity(i);
                        }

                    }
                }
        );
    }

    public void signup(View view) {
        Intent signup2 = new Intent(this, Register.class);
        startActivity(signup2);
    }
}
