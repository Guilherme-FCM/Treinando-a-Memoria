package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.treinandoamemria.classes.Player;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        EditText name = findViewById(R.id.name);
        EditText day = findViewById(R.id.day);
        EditText month = findViewById(R.id.month);
        EditText year = findViewById(R.id.year);

        Button button = findViewById(R.id.button);
        button.setOnClickListener((view -> {
            Intent intent = new Intent(this, RandomSignosActivity.class);
            Player player = new Player(
                    name.getText().toString(),
                    Integer.parseInt(day.getText().toString()),
                    Integer.parseInt(month.getText().toString()),
                    Integer.parseInt(year.getText().toString())
            );
            intent.putExtra("player", player);
            startActivity(intent);
        }));
    }
}