package com.example.treinandoamemria.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.treinandoamemria.FinalActivity;
import com.example.treinandoamemria.FormularioActivity;
import com.example.treinandoamemria.classes.Player;

import java.util.ArrayList;

public class NextDialogFragment extends DialogFragment {
    private ArrayList<Player> players;

    public NextDialogFragment(ArrayList<Player> players) {
        this.players = players;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Deseja jogar novamente?")
                .setPositiveButton("Sim", (dialogInterface, i) -> {
                    Intent intent = new Intent(getContext(), FormularioActivity.class);
                    intent.putExtra("players", this.players);
                    startActivity(intent);
                })
                .setNegativeButton("Não", (dialogInterface, i) -> {
                    Intent intent = new Intent(getContext(), FinalActivity.class);
                    intent.putExtra("players", this.players);
                    startActivity(intent);
                });
        return builder.create();
    }
}
