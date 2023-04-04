package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.treinandoamemria.classes.Player;
import com.example.treinandoamemria.classes.Result;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private ResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent it = getIntent();
        ArrayList<Integer> randomImages = it.getIntegerArrayListExtra("random_signos");
        ArrayList<String> selectedOrder = it.getStringArrayListExtra("selected_signos");

        String[] originalOrderNames = getResources().getStringArray(R.array.signos_nomes);
        TypedArray originalOrderImages = getResources().obtainTypedArray(R.array.signos_imagens);

        // Compara a ordem aleatória com a selecionada pelo usuário
        ArrayList<String> correctAnswer = new ArrayList<>();
        for (int imageId : randomImages) {
            for (int i = 0; i < originalOrderImages.length(); i++) {
                int id = originalOrderImages.getResourceId(i, 0);
                if (id == imageId) {
                    correctAnswer.add(originalOrderNames[i]);
                    break;
                }
            }
        }

        Player player = (Player) it.getSerializableExtra("player");

        // Gera array de resultados
        ArrayList<Result> results = new ArrayList<>();
        for (int i = 0; i < selectedOrder.size(); i++) {
            boolean equal = selectedOrder.get(i).equals(correctAnswer.get(i));
            results.add( new Result(selectedOrder.get(i), equal) );
            if (equal) player.incrementScore(1);
        }

        if (player.getScore() >= player.getBirthMonth())
            player.incrementScore(player.getBirthMonth() / 2.0);

        adapter = new ResultAdapter(this, results);
        ListView listView = findViewById(R.id.result);
        listView.setAdapter(adapter);


        TextView nameView = findViewById(R.id.name);
        TextView ageView = findViewById(R.id.age);

        nameView.setText("Parabéns " + player.getName() + "! \nSua pontuação foi de " + player.getScore() + " ponto(s).");
        ageView.setText(player.getAge() + " anos de idade");
    }
}