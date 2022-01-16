package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        TextView textoBemVindo = findViewById(R.id.textBemVindo);
        Intent intent = getIntent();
        String login = intent.getStringExtra("login");
        textoBemVindo.setText("Olá "+login+"!!");
    }
}