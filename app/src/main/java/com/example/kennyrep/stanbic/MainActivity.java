package com.example.kennyrep.stanbic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private static Button btn_new;
    private static Button btn_dont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListener();
    }

    public void onClickListener() {
        btn_new = (Button) findViewById(R.id.buttonsign);
        btn_new.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(".congratulations");
                        startActivity(i);

                    }
                }
        );
    }

    public void signup(View view) {
        Intent signup2 = new Intent(this, Register.class);
        startActivity(signup2);
    }
}
