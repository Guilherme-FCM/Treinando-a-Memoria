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
    private final int time = 1000;
    private ImageView imageView;
    private TextView textView;
    private TextView countdown;
    private ArrayList<Integer> signos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_signos);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        countdown = findViewById(R.id.countdown);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String day = intent.getStringExtra("day");
        String month = intent.getStringExtra("month");
        String year = intent.getStringExtra("year");
        textView.setText(
            name.length() > 0
            ? name + ", " + textView.getText()
            : textView.getText()
        );

        TypedArray array = getResources().obtainTypedArray(R.array.signos_imagens);
        for (int i = 0; i < array.length(); i++)
            signos.add(array.getResourceId(i, 0));
        Collections.shuffle(signos);
        renderImages();
    }

    private void renderImages() {
        renderCountdown();
        renderImages(0);
    }
    private void renderImages(int position) {
        if (position < signos.size())
            new Handler().postDelayed(() -> {
                imageView.setImageResource(signos.get(position));

                this.renderCountdown();

                renderImages(position+1);
            }, time);
        else {
            Intent intent = new Intent(this, AnswerActivity.class);
            intent.putExtra("signos_imagens", signos);
            startActivity(intent);
        }
    }

    private void renderCountdown() {
        new Handler().postDelayed(() -> {
            countdown.setText("3");
        }, 0);

//        new Handler().postDelayed(() -> {
//            countdown.setText("2");
//        }, 1000);
//
//        new Handler().postDelayed(() -> {
//            countdown.setText("1");
//        }, 2000);
    }
}