package com.example.treinandoamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AnswerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ArrayAdapter<CharSequence> adapter;
    private ArrayList<String> selectedSignos = new ArrayList<>();
    private Spinner[] spinners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        for (String signo : getResources().getStringArray(R.array.signos_nomes))
            selectedSignos.add(signo);

        adapter = ArrayAdapter.createFromResource(this, R.array.signos_nomes, android.R.layout.simple_expandable_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners = new Spinner[] {
                findViewById(R.id.spinner1),
                findViewById(R.id.spinner2),
                findViewById(R.id.spinner3),
                findViewById(R.id.spinner4),
                findViewById(R.id.spinner5),
                findViewById(R.id.spinner6),
                findViewById(R.id.spinner7),
                findViewById(R.id.spinner8),
                findViewById(R.id.spinner9),
                findViewById(R.id.spinner10),
                findViewById(R.id.spinner11),
                findViewById(R.id.spinner12)
        };
        for (Spinner spinner : spinners) {
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
       }
        Button button = findViewById(R.id.button);
        button.setOnClickListener((view) -> {
            Intent it = getIntent();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("selected_signos", selectedSignos);
            intent.putExtra("random_signos", it.getIntegerArrayListExtra("random_signos"));
            intent.putExtra("player", it.getSerializableExtra("player"));
            startActivity(intent);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int spinnerId = adapterView.getId();
        String signo = adapterView.getItemAtPosition(i).toString();

        for (int x = 0; x < spinners.length; x++) {
            if (spinners[x].getId() == spinnerId)
                selectedSignos.set(x, signo);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}