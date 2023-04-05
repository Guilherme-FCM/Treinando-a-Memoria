package com.example.treinandoamemria.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.treinandoamemria.R;


public class SignoDialog extends DialogFragment {
    private int signo;

    public SignoDialog(int signo) {
        this.signo = signo;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String[] originalOrderNames = getResources().getStringArray(R.array.signos_nomes);
        TypedArray originalOrderImages = getResources().obtainTypedArray(R.array.signos_imagens);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Você é do signo de " + originalOrderNames[this.signo])
                .setIcon(originalOrderImages.getResourceId(this.signo, 0))
                .setPositiveButton(android.R.string.ok, (dialogInterface, i) -> {});
        return builder.create();
    }
}
