package com.ulp.clase10.vistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ulp.clase10.R;
import com.ulp.clase10.model.ItemPrograma;

import java.util.ArrayList;

public class AdapterLista extends ArrayAdapter<ItemPrograma> {

    ArrayList<ItemPrograma> list;
    private Context context;
    public AdapterLista(ArrayList<ItemPrograma> list, Context context) {
        super(context, R.layout.activity_nombres_items,list);
        this.context = context;
        this.list=list;

    }

    public View getView (int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = lf.inflate(R.layout.activity_nombres_items, parent, false);
        }

        ItemPrograma itemActual = list.get(position);


        TextView tv = (TextView) itemView.findViewById(R.id.tvNombreItem);
        tv.setText(itemActual.getNombre());

        return itemView;
    }

}
