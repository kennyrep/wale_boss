package com.example.kennyrep.stanbic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class AjayiVentures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajayi__ventures);
    }
}
//TODO 1.0 It now generally looks better but there are still issues predominantly on the toolbar/action, follow my comments in TODO 1.1.
//TODO Also the video you get from Ola T will help solidify your design instincts.


//TODO 2.0 For this week, our main focus is learning how users are ideally gonna use the app. The following comes to mind:
//TODO User registration and login - how do we obtain what has been typed into those edit texts
//TODO Validating these input data, e.g is the email valid? checking that the user's name is not empty, etc
//TODO Simulating a real flow by storing the information/input retrieved during registration to a database.
//TODO User login against information saved during registration
// TODO Here we shall use a local database i.e a database on the phone to store those information
// Todo You must have heard about SQLite before - its the local database we use on Android but its a bit difficult to grasp at first.
//TODO So, an abstraction on top of it is called ROOM which you will use. The truth is, I have not used this ROOM before too, so, you are learning to teach me. It wont be easy but we can do it! so brace up to learn!
//TODO Start reading here: https://developer.android.com/training/data-storage/room/#java
//TODO you will see lot of new terms and concepts, Google is your friend.

//Todo Once you grab the concept behind the database, there are two basic things to do:
// Todo save the user registration information
// Todo use the saved information to log user in!