package com.example.treinandoamemria.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.treinandoamemria.R;
import com.example.treinandoamemria.classes.Player;

import java.util.ArrayList;
import java.util.Collections;

public class RandomSignosActivity extends AppCompatActivity {
    private final int time = 3000;
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
        Player player = (Player) intent.getSerializableExtra("player");
        String mensagem = textView.getText().toString();
        if (player.getName().length() > 0)
            textView.setText("Olá " + player.getName() + ". Seja muito bem-vindo!\n" + mensagem);

        TypedArray array = getResources().obtainTypedArray(R.array.signos_imagens);
        for (int i = 0; i < array.length(); i++)
            signos.add(array.getResourceId(i, 0));
        Collections.shuffle(signos);
        renderCountdown();
        renderImages();
    }

    private void renderImages() { renderImages(0); }
    private void renderImages(int position) {
        if (position < signos.size())
            new Handler().postDelayed(() -> {
                imageView.setImageResource(signos.get(position));

                this.renderCountdown();

                renderImages(position+1);
            }, time);
        else {
            Intent it = getIntent();
            Intent intent = new Intent(this, AnswerActivity.class);
            intent.putExtra("random_signos", signos);
            intent.putExtra("player", it.getSerializableExtra("player"));
            intent.putExtra("players", it.getSerializableExtra("players"));
            startActivity(intent);
        }
    }

    private void renderCountdown() {
        new Handler().postDelayed(() -> {
            countdown.setText("3");
        }, 0);

        new Handler().postDelayed(() -> {
            countdown.setText("2");
        }, 1000);

        new Handler().postDelayed(() -> {
            countdown.setText("1");
        }, 2000);
    }
}