package com.example.treinandoamemria.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.treinandoamemria.activities.FinalActivity;
import com.example.treinandoamemria.adapters.FinalAdapter;
import com.example.treinandoamemria.classes.Player;

import java.util.ArrayList;

public class RemovePlayerDialog extends DialogFragment {
    private ArrayList<Player> players;
    private int selectedItem;
    private FinalAdapter adapter;

    public RemovePlayerDialog(ArrayList<Player> players, int selectedItem, FinalAdapter adapter) {
        this.players = players;
        this.selectedItem = selectedItem;
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Você deseja excluir o jogador " + getPlayerName())
            .setPositiveButton(android.R.string.yes, (dialogInterface, i) -> {
                removePlayer();
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Jogador removido", Toast.LENGTH_SHORT).show();
            })
            .setNegativeButton(android.R.string.no, (dialogInterface, i) -> {});
        return builder.create();
    }

    private String getPlayerName() {
        return this.players.get(this.selectedItem).getName();
    }

    private Player removePlayer() {
        return this.players.remove(this.selectedItem);
    }
}
