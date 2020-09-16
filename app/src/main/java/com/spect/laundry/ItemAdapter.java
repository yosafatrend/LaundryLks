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

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> item = new ArrayList<>();

    public ItemAdapter(Context context, ArrayList<Item> item) {
        this.context = context;
        this.item = item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
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

        tvItemName.setText(item.get(position).getItemName());
        tvQty.setText(String.valueOf(item.get(position).getItemQty()));

        return v;
    }

}
