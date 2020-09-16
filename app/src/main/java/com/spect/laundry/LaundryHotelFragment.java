package com.spect.laundry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class LaundryHotelFragment extends Fragment {
    EditText edtQty;
    Button btnAdd, btnSubmit;
    Spinner itemDropdown;
    ListView listItem;
    ArrayList<Item> arrayItem;
    ItemAdapter itemAdapter;

    public LaundryHotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_laundry_hotel, container, false);

        itemDropdown = v.findViewById(R.id.service_dropdown);
        edtQty = v.findViewById(R.id.edt_qty_hotel);
        btnAdd = v.findViewById(R.id.btn_add_hotel);
        btnSubmit = v.findViewById(R.id.btn_submit_hotel);
        listItem = v.findViewById(R.id.list_item1);

        //dropdown item array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.item_dropdown_string,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemDropdown.setAdapter(adapter);

        //list item array
        arrayItem = new ArrayList<>();
        itemAdapter = new ItemAdapter(getActivity(),  arrayItem);
        listItem.setAdapter(itemAdapter);
        addItem();
        onSubmit();

        return v;
    }

    public void addItem(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemDropdown.getSelectedItem().toString();
                String qty = edtQty.getText().toString();
                arrayItem.add(new Item(item, qty));
                itemAdapter.notifyDataSetChanged();
            }
        });
    }

    public void onSubmit(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmationDialogHotel confirmationDialog = new ConfirmationDialogHotel();
                confirmationDialog.show(getFragmentManager(), "Confirmation");
            }
        });
    }

}