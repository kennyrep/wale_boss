package com;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

import com.example.kennyrep.stanbic.MainActivity;
import com.example.kennyrep.stanbic.Register;

public class ShowDialog extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Welcome");
        builder.setMessage("Registration Successfull!");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent dialog = new Intent(getContext(), MainActivity.class);
                startActivity(dialog);
            }
        });
        return builder.create();

    }
}
