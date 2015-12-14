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
public class BuildingListAdapter extends ArrayAdapter<BuildingData> {
    private Activity activity;
    private ArrayList<BuildingData> list;


    public BuildingListAdapter(Context context, int resource, List<BuildingData> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View v = convertView;

        if (v==null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v= vi.inflate(R.layout.item_buildingitem, null);
        }

        BuildingData buildingItem = getItem(position);

        if (buildingItem!=null){
            TextView textprice = (TextView) v.findViewById(R.id.textprice);
            if (textprice!=null){
                textprice.setText(buildingItem.getFlatPrice());
            }

        }

        return v;
    }


}
