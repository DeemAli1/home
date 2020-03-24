package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addnew (View view ){
        Intent in = new Intent(this,register.class);
        startActivity(in);
        finish();

    }
    public void retrieve (View view ){
        Intent in = new Intent(this,retrieve.class);
        startActivity(in);
        finish();

    }
}
