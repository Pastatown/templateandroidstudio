package com.example.appseriecorrige;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AffListSerie extends AppCompatActivity {

    ArrayList<Serie> lesSeries = new ArrayList<Serie>();
    ListView lstView;
    SerieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_list_serie);
        //JSONHelper listeSerieJson = new JSONHelper(MainActivity.this, "serie.json");
        //lesSeries = listeSerieJson.getLesSerie();

        SerieSqlHelper listeSerieSql = new SerieSqlHelper(AffListSerie.this);
        lesSeries = listeSerieSql.getLesSeries();

        lstView = findViewById(R.id.lstView);
        mAdapter = new SerieAdapter(AffListSerie.this, lesSeries);
        lstView.setAdapter(mAdapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = lstView.getItemAtPosition(position);
                Serie serie=(Serie)listItem;
                Intent detailSerieActivity = new Intent(AffListSerie.this, DetailSerie.class);
                detailSerieActivity.putExtra("pos",serie.getId());
                startActivity(detailSerieActivity);
            }
        });
    }
}