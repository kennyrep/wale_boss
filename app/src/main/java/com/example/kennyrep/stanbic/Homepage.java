package com.example.kennyrep.stanbic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void newProspect(View view) {
        Intent newProspect = new Intent(this, New_Prospect.class);
        startActivity(newProspect);
    }

    public void callPlan(View view) {
        Intent call = new Intent(this, Call_Plan.class);
        startActivity(call);
    }

    public void visitor(View view) {

        Intent visit = new Intent(this, Visitor.class);
        startActivity(visit);
    }

    public void addNewProspect(View view) {

        Intent newProspect = new Intent(this, AddNewProspect.class);
        startActivity(newProspect);
    }
}
