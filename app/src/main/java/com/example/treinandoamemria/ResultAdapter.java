package com.example.treinandoamemria;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.treinandoamemria.classes.Result;

import java.util.ArrayList;

public class ResultAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Result> data;

    public ResultAdapter(Context context, ArrayList<Result> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.result_list_view, null);

        Result item = data.get(i);
        TextView position = view.findViewById(R.id.position);
        TextView textView = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);

        position.setText((i + 1) + "°");
        textView.setText(item.getSigno());
        imageView.setImageResource(
                item.isCorrect() ? R.drawable.correct : R.drawable.incorrect
        );
        view.setBackgroundColor(
                item.isCorrect()? Color.GREEN : Color.RED
        );
        return view;
    }
}
