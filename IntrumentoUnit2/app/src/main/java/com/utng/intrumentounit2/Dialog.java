package com.utng.intrumentounit2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment{
    private EditText userName;
    private EditText userAge;
    private DialogListener listener;

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflanter = getActivity().getLayoutInflater();
        View view = inflanter.inflate(R.layout.item_dialog, null);

        builder.setView(view)
                .setTitle("Datos")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (userName.getText().length() > 3 && (userAge.getText().length() == 1 || userAge.getText().length() == 2) ) {
                            Log.i("Dialog.java", "Con datos");
                            listener.applyTexts(userName.getText().toString(), userAge.getText().toString());
                        } else {
                            Log.i("Dialog.java", "Sin datos");
                            // TODO : Mostrar alerta de no permitir espacios vacios
                        }
                    }
                });

        userName = view.findViewById(R.id.userName);
        userAge = view.findViewById(R.id.userAge);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement DialogListener");
        }
    }

    public interface DialogListener {
        void applyTexts(String userName, String userAge);
    }
}
