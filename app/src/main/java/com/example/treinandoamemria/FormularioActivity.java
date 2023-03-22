package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class FormularioActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        button = findViewById(R.id.button);
        button.setOnClickListener((view -> {
            startActivity( new Intent(this, RandomSignosActivity.class) );
        }));
    }
}