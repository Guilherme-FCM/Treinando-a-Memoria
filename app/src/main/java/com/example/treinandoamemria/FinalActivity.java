package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.treinandoamemria.classes.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        ArrayList<Player> players = (ArrayList<Player>) getIntent().getSerializableExtra("players");
        Toast.makeText(this, players.toString(), Toast.LENGTH_SHORT).show();
    }
}