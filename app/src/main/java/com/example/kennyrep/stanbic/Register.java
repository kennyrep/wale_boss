package com.example.kennyrep.stanbic;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.ShowDialog;
import com.example.kennyrep.stanbic.database.MyAppDatabase;
import com.example.kennyrep.stanbic.database.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Register extends AppCompatActivity {
    Intent i;
    User user;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    //"(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{7,}" +               //at least 4 characters
                    "$");


    public static MyAppDatabase myAppDatabase;

    //TODO Naming convention for variables should be PascalCasing, e.g full_name should be fullName
    public static EditText firstName, lastName, jobTitle, email, phoneNo, password;
    private Button register;
    public static String FirstName;
    public static String LastName;
    public static String currentUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb")
                .allowMainThreadQueries()
                .build();
        onCreateView();
        i = getIntent();
        if (i != null) {
            if (i.hasExtra("user")) {
                user = i.getParcelableExtra("user");
                setUpFields();
            }
        }


        //Showing the number user in the database in a Toast message
        // User[] u = myAppDatabase.myDao().load();
        //Toast.makeText(this, String.valueOf(u.length), Toast.LENGTH_SHORT).show();
    }

    private void setUpFields() {
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        jobTitle.setText(user.getJobTitle());
        email.setText(user.getEmail());
        phoneNo.setText(user.getPhoneNumber());
        password.setText(user.getPassword());

    }


    public void onCreateView() {

        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.name);
        jobTitle = findViewById(R.id.job);
        email = findViewById(R.id.email);
        phoneNo = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        register = findViewById(R.id.buttonsign);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstName = firstName.getText().toString();
                LastName = lastName.getText().toString();
                String JobTitle = jobTitle.getText().toString();
                String PhoneNo = (phoneNo.getText().toString());
                String Password = password.getText().toString();
                String validEmail =
                        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                                "\\@" +
                                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                                "(" +
                                "\\." +
                                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                                ")+";
                String Email = email.getText().toString();
                Matcher matcher = Pattern.compile(validEmail).matcher(Email);

                User user = new User();
                user.setFirstName(FirstName);
                user.setLastName(LastName);
                user.setJobTitle(JobTitle);
                user.setEmail(Email);
                user.setPhoneNumber(PhoneNo);
                user.setPassword(Password);


                if (TextUtils.isEmpty(FirstName)) {
                    firstName.setError("Full Name is required.");
                    firstName.requestFocus();
                    Toast.makeText(Register.this, "Name Field must be Filled", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Email)) {
                    email.setError("Email is required.");
                    email.requestFocus();
                    Toast.makeText(Register.this, "Email Field must be Filled", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!matcher.matches()) {
                    email.setError("Enter a Valid Email");
                    return;
                }

                if (TextUtils.isEmpty(PhoneNo)) {
                    phoneNo.setError("Phone Number is required.");
                    phoneNo.requestFocus();
                    Toast.makeText(Register.this, "Phone Number Field must be Filled", Toast.LENGTH_SHORT).show();
                    return;
                } else if (phoneNo.length() != 11) {
                    phoneNo.setError("Phone Number must be 11 Characters.");
                    phoneNo.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    password.setError("Password  is required.");
                    password.requestFocus();
                    Toast.makeText(Register.this, "Password Field must be Filled", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!PASSWORD_PATTERN.matcher(Password).matches()) {
                    password.setError("Password too weak");
                    return;
                }

                CheckBox checkBoxAccept = findViewById(R.id.accept);
                boolean checkAccept = checkBoxAccept.isChecked();
                if (!checkAccept) {
                    Toast.makeText(Register.this, "Terms and Condition must be Accepted", Toast.LENGTH_SHORT).show();
                    return;
                }
                //TODO Ensure the required fields are provided before creating the user. Similar to what i said for the login section
                //TODO I was able to register a user without even providing anything
                //Todo Asides from not being empty, Make sure the following constraints are enforced before registering the user
                //Todo 1. Must be a valid email, Phone number must be 11 digits,
                // Todo Password must be greater than 6 six characters, must contain a number, must contain an Upper Case, must contain a symbol
                //Todo Dont allow registration until and unless user accept terms and conditions
                //Todo Display a dialog instead of toast after successful registration and take the user back to login screen automatically

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Register.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("current", user.getEmail());
                editor.apply();
                myAppDatabase.myDao().addUser(user);
                openDialog();


                firstName.setText("");
                lastName.setText("");
                jobTitle.setText("");
                email.setText("");
                phoneNo.setText("");
                password.setText("");
            }
        });


    }

    public void openDialog() {
        ShowDialog showDialog = new ShowDialog();
        showDialog.show(getSupportFragmentManager(), "Dialog");

    }

    public void registerSignIn(View view) {
        Intent signup2 = new Intent(this, MainActivity.class);
        startActivity(signup2);
    }
}
