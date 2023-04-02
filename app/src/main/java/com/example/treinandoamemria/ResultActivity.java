package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent it = getIntent();
        ArrayList<Integer> signos_imagens = it.getIntegerArrayListExtra("signos_imagens");
        ArrayList<String> signos_nomes = it.getStringArrayListExtra("signos_nomes");

        Toast.makeText(this, signos_imagens.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, signos_nomes.toString(), Toast.LENGTH_SHORT).show();
    }
}