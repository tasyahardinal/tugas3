package com.example.tasya3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvhero;
    private ArrayList<Heroes> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvhero = findViewById(R.id.activtymain_rv);
        rvhero.setHasFixedSize(true);
        list.addAll(HeroesData.getHeroList());
        
        showRecyclerList ();
    }

    private void showRecyclerList() {
        rvhero.setLayoutManager(new LinearLayoutManager(this));
        HeroesAdapter heroesAdapter = new HeroesAdapter(this);
        heroesAdapter.setListHero(list);
        rvhero.setAdapter(heroesAdapter);
    }

}

