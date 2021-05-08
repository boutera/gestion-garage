package com.example.project_youssef;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import android.graphics.Color;
public class MyAdapter extends ArrayAdapter<Vehicule> {

    ArrayList<Vehicule> ListVehicule = new ArrayList<>();

    public MyAdapter(Context context, int textViewResourceId, ArrayList<Vehicule> objects) {
        super(context, textViewResourceId, objects);
        ListVehicule = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_view_items, null);
        TextView name = (TextView) v.findViewById(R.id.nameView);
        TextView desc = (TextView) v.findViewById(R.id.descView);
        ImageView image = (ImageView) v.findViewById(R.id.imageView);
        name.setText(ListVehicule.get(position).getVehiculeName());
        desc.setText(ListVehicule.get(position).getVehiculeDesc());
        image.setImageDrawable(ListVehicule.get(position).getVehiculeImage());
        return v;


    }

}
