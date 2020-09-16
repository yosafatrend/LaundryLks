package com.spect.laundry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ServiceAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Service> service = new ArrayList<>();

    public ServiceAdapter(Context context, ArrayList<Service> service) {
        this.context = context;
        this.service = service;
    }

    public void setItem(ArrayList<Service> service) {
        this.service = service;
    }

    @Override
    public int getCount() {
        return service.size();
    }

    @Override
    public Object getItem(int position) {
        return service.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.item, null);
        TextView tvItemName = (TextView) v.findViewById(R.id.txt_item);
        TextView tvQty = (TextView) v.findViewById(R.id.txt_qty);

        tvItemName.setText(service.get(position).getServiceName());
        tvQty.setText(String.valueOf(service.get(position).getServiceQty()));

        return v;
    }

}
