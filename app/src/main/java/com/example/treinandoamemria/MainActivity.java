package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.treinandoamemria.activities.FormularioActivity;

public class MainActivity extends AppCompatActivity {
    private final int time = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(() -> {
            startActivity( new Intent(this, FormularioActivity.class) );
        }, time);
    }
}