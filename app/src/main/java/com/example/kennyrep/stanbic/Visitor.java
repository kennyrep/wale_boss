package com.example.kennyrep.stanbic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Visitor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);
    }

    public void check(View view) {

        Intent check = new Intent(this, Visitor_Information.class);
        startActivity(check);
    }
}
