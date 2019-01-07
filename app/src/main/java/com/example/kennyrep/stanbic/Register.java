package com.example.kennyrep.stanbic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void signup2(View view) {
        Intent sign = new Intent(this, Congratulations.class);
        startActivity(sign);
    }

    public void signup3(View view) {
        Intent sign3 = new Intent(this, Congratulations.class);
        startActivity(sign3);
    }
}
