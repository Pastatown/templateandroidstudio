package com.example.appseriecorrige;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void affList(View view) {
        startActivity(new Intent(MainActivity.this,AffListSerie.class));
    }

    public void addSerie(View view) {
        startActivity(new Intent(MainActivity.this,AjoutSerie.class));
    }
}

