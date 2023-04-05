package com.example.treinandoamemria.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.treinandoamemria.R;
import com.example.treinandoamemria.adapters.FinalAdapter;
import com.example.treinandoamemria.classes.Player;
import com.example.treinandoamemria.dialogs.RemovePlayerDialog;

import java.io.Serializable;
import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {
    ArrayList<Player> players;
    FinalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        ListView listView = findViewById(R.id.listView);

        players = (ArrayList<Player>) getIntent().getSerializableExtra("players");
        adapter = new FinalAdapter(this, players);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this::openDialog);
    }

    private void openDialog(AdapterView<?> adapterView, View view, int i, long l) {
        RemovePlayerDialog dialog = new RemovePlayerDialog(players, i, adapter);
        dialog.show(getSupportFragmentManager(), "final-dialog");
    }
}