package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class RandomSignosActivity extends AppCompatActivity {
    private int time = 3000;
    private ImageView imageView;
    private TextView textView;
    private ArrayList<Integer> signos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_signos);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView.setText(name + ", " + textView.getText());

        TypedArray array = getResources().obtainTypedArray(R.array.signos);
        for (int i = 0; i < array.length(); i++)
            signos.add(array.getResourceId(i, 0));
        Collections.shuffle(signos);
        renderImages();
    }

    private void renderImages() { renderImages(0); }
    private void renderImages(int position) {
        if (position < signos.size())
            new Handler().postDelayed(() -> {
                imageView.setImageResource(signos.get(position));
                renderImages(position+1);
            }, time);
    }
}