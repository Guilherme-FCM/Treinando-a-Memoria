package com.example.treinandoamemria.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.treinandoamemria.R;
import com.example.treinandoamemria.classes.Player;

import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        EditText editName = findViewById(R.id.name);
        EditText editDay = findViewById(R.id.day);
        EditText editMonth = findViewById(R.id.month);
        EditText editYear = findViewById(R.id.year);

        Button button = findViewById(R.id.button);
        button.setOnClickListener((view -> {
            try {
                String name = editName.getText().toString();
                int day = Integer.parseInt(editDay.getText().toString());
                int month = Integer.parseInt(editMonth.getText().toString());
                int year = Integer.parseInt(editYear.getText().toString());

                if (
                    name.length() == 0 ||
                    day < 1 || day > 31 ||
                    month < 1 || month > 12 ||
                    year < 1000 || year > Calendar.getInstance().get(Calendar.YEAR)
                ) throw new Exception();

                Intent intent = new Intent(this, RandomSignosActivity.class);
                Player player = new Player(name, day, month, year);
                intent.putExtra("player", player);
                intent.putExtra("players", getIntent().getSerializableExtra("players"));
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Os campos devem ser preenchidos adequadamente.", Toast.LENGTH_SHORT).show();
            }
        }));
    }
}