package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.treinandoamemria.adapters.ResultAdapter;
import com.example.treinandoamemria.classes.Player;
import com.example.treinandoamemria.classes.Result;
import com.example.treinandoamemria.dialogs.NextDialogFragment;
import com.example.treinandoamemria.dialogs.SignoDialog;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private ResultAdapter adapter;
    private ArrayList<Player> players;
    private Player player;

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

        player = (Player) it.getSerializableExtra("player");

        // Gera array de resultados
        ArrayList<Result> results = new ArrayList<>();
        for (int i = 0; i < selectedOrder.size(); i++) {
            Result result = new Result(selectedOrder.get(i), correctAnswer.get(i));
            results.add(result);
            if (result.isCorrect()) player.incrementScore(1);
        }

        if (player.getScore() >= player.getBirthMonth())
            player.incrementScore(player.getBirthMonth() / 2.0);

        players = (ArrayList<Player>) getIntent().getSerializableExtra("players");
        if (players == null) players = new ArrayList<>();
        players.add(player);

        adapter = new ResultAdapter(this, results);
        ListView listView = findViewById(R.id.result);
        listView.setAdapter(adapter);

        TextView nameView = findViewById(R.id.name);
        TextView ageView = findViewById(R.id.age);

        nameView.setText("Parabéns " + player.getName() + "! \nSua pontuação foi de " + player.getScore() + " ponto(s).");
        ageView.setText(player.getAge() + " anos de idade");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.next:
                NextDialogFragment nextDialog = new NextDialogFragment(this.players);
                nextDialog.show(getSupportFragmentManager(), "next-dialog");
                return true;
            case R.id.signo:
                SignoDialog signoDialog = new SignoDialog(player.getSigno());
                signoDialog.show(getSupportFragmentManager(), "signo-dialog");
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}