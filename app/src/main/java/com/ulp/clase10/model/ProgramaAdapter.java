package com.ulp.clase10.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ulp.clase10.R;

import java.util.ArrayList;

public class ProgramaAdapter extends ArrayAdapter<Programa> {
    public ProgramaAdapter(Context context, ArrayList<Programa> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // Get the data item for this position
        Programa programa = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_nombres_items, parent, false);
        }
        // Lookup view for data population
        TextView tvNombreItem = (TextView) view.findViewById(R.id.tvNombreItem);
        // Populate the data into the template view using the data object
        tvNombreItem.setText(programa.getNombre());
        // Return the completed view to render on screen
        return view;
    }
}