package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent it = getIntent();
        ArrayList<Integer> randomImages = it.getIntegerArrayListExtra("signos_imagens");
        ArrayList<String> selectedOrder = it.getStringArrayListExtra("signos_nomes");

        String[] originalOrderNames = getResources().getStringArray(R.array.signos_nomes);
        TypedArray originalOrderImages = getResources().obtainTypedArray(R.array.signos_imagens);

        ArrayList<String> correctAnswer = new ArrayList<>();
        for (int imageId : randomImages) {
            for (int j = 0; j < originalOrderImages.length(); j++) {
                int id = originalOrderImages.getResourceId(j, 0);
                if (id == imageId) {
                    correctAnswer.add(originalOrderNames[j]);
                    break;
                }
            }
        }


    }
}