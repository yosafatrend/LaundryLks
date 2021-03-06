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

public class LaundryCustomerFragment extends Fragment {
    EditText edtQty;
    Button btnAdd, btnSubmit;
    Spinner serviceDropdown;
    ListView listItem;
    ArrayList<Service> arrayService;
    ServiceAdapter serviceAdapter;

    public LaundryCustomerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_laundry_customer, container, false);

        serviceDropdown = v.findViewById(R.id.service_dropdown);
        edtQty = v.findViewById(R.id.edt_qty_hotel);
        btnAdd = v.findViewById(R.id.btn_add_hotel);
        btnSubmit = v.findViewById(R.id.btn_submit_hotel);
        listItem = v.findViewById(R.id.list_item1);

        //dropdown item array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.service_dropdown_string,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceDropdown.setAdapter(adapter);

        //list item array
        arrayService = new ArrayList<>();
        serviceAdapter = new ServiceAdapter(getActivity(),  arrayService);
        listItem.setAdapter(serviceAdapter);
        addItem();
        onSubmit();

        return v;
    }

    public void addItem(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String service = serviceDropdown.getSelectedItem().toString();
                String qty = edtQty.getText().toString();
                arrayService.add(new Service(service, qty));
                serviceAdapter.notifyDataSetChanged();
            }
        });
    }

    public void onSubmit(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmationDialogCustomer confirmationDialog = new ConfirmationDialogCustomer();
                confirmationDialog.show(getFragmentManager(), "Confirmation");
            }
        });
    }

}