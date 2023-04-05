package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.treinandoamemria.adapters.FinalAdapter;
import com.example.treinandoamemria.classes.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        ListView listView = findViewById(R.id.listView);

        ArrayList<Player> players = (ArrayList<Player>) getIntent().getSerializableExtra("players");
        listView.setAdapter(new FinalAdapter(this, players));

    }
}