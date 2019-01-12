package com.example.kennyrep.stanbic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CallPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__plan);
    }

    public void ventures(View view) {
        Intent ajayi = new Intent(this, AjayiVentures.class);
        startActivity(ajayi);
    }
}
