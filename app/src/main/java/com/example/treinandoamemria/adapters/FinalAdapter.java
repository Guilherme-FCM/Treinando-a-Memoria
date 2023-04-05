package com.example.treinandoamemria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.treinandoamemria.R;
import com.example.treinandoamemria.classes.Player;

import java.util.ArrayList;

public class FinalAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Player> players;

    public FinalAdapter(Context context, ArrayList<Player> players) {
        this.inflater = LayoutInflater.from(context);
        this.players = players;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int i) {
        return players.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.final_list_view, null);

        Player player = players.get(i);
        TextView playerView = view.findViewById(R.id.player);
        TextView scoreView = view.findViewById(R.id.score);

        playerView.setText(player.getName());
        scoreView.setText(player.getScore() + " Ponto(s)");

        return view;
    }
}
