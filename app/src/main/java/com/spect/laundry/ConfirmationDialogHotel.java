package com.spect.laundry;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ConfirmationDialogHotel extends AppCompatDialogFragment {
    private Spinner roomDropdown, housekeeperDropdown;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.confirmation_dialog_hotel, null);

        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //tambahkan method submit disini
            }
        });
        roomDropdown = view.findViewById(R.id.room_dropdown);
        housekeeperDropdown = view.findViewById(R.id.housekeeper_dropdown);
        ArrayAdapter<CharSequence> roomAdapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.room_numbers_string,
                android.R.layout.simple_spinner_item
        );
        roomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> housekeeperAdapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.housekeeper_string,
                android.R.layout.simple_spinner_item
        );
        housekeeperAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomDropdown.setAdapter(roomAdapter);
        housekeeperDropdown.setAdapter(housekeeperAdapter);
        return builder.create();
    }
}
