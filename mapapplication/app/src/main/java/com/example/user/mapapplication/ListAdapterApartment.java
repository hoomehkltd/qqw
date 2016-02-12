package com.example.user.mapapplication;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14/12/2015.
 */
public class ListAdapterApartment extends ArrayAdapter<Apartment> {
    private Activity activity;
    private ArrayList<Apartment> list;


    public ListAdapterApartment(Context context, int resource, ArrayList<Apartment> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View v = convertView;

        if (v==null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v= vi.inflate(R.layout.item_apartmentitem, null);
        }

        Apartment apartmentItem = getItem(position);

        if (apartmentItem!=null){
            TextView textprice = (TextView) v.findViewById(R.id.textprice);
            if (textprice!=null){
                textprice.setText(apartmentItem.getFlatPrice());
            }
        }

        return v;
    }


}
