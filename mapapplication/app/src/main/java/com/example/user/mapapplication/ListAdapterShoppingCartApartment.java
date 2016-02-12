package com.example.user.mapapplication;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14/12/2015.
 */
public class ListAdapterShoppingCartApartment extends ArrayAdapter<Apartment> {
    private Activity activity;
    private ArrayList<Apartment> list;
    public int userId;
    public Adapter adapter;
    public ArrayList<Apartment> apartmentArrayList ;;
    private Context context;
    public ArrayList<String> apartmentSelectedList= new ArrayList<String>();
    public int layout;

    public static class viewHolder{
        static TextView textprice ;
        static Button deleteBtn;
        static Button confirmTimeBtn ;
    }


    public ListAdapterShoppingCartApartment(Context context, int resource, ArrayList<Apartment> objects, int id) {
        super(context, resource, objects);
        userId = id;
        apartmentArrayList = objects;
        this.context = context;
        layout = resource;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final viewHolder holder = new viewHolder();
        adapter = ListAdapterShoppingCartApartment.this;
        View v = convertView;
        if (v==null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v= vi.inflate(layout, null);
            holder.textprice = (TextView) v.findViewById(R.id.textcartprice);
            holder.deleteBtn = (Button) v.findViewById(R.id.deleteItemBtn);
            holder.confirmTimeBtn  = (Button) v.findViewById(R.id.confirmbtn);
            Log.d("confirmTimeBtn",holder.confirmTimeBtn.toString());
            v.setTag(holder);

        }

        final Apartment apartmentItem = getItem(position);

        if (apartmentItem!=null){

            if (holder.textprice!=null){
                Log.d("getFlatPrice", apartmentItem.getFlatPrice());
                holder.textprice.setText(apartmentItem.getFlatPrice());
                holder.textprice.setTag(position);
            }

            if (holder.deleteBtn !=null){
                Log.d("deleteBtnisSet", apartmentItem.getApartmentNo());
                holder.deleteBtn.setTag(position);
                Log.d("HiThere","");


            }

            if (holder.confirmTimeBtn!=null){
                holder.confirmTimeBtn.setTag(position);
                Log.d("confirmTimeBtnisSet", apartmentItem.getApartmentNo());
            }

            View.OnClickListener deleteItemListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    new DataOperationUser().deleteItemFromShoppingCart(userId, apartmentItem.getApartmentNo());
                    apartmentArrayList.remove(position);
                    notifyDataSetChanged();
                    Log.d("deleteItemdeleted",  apartmentItem.getApartmentNo());
                }
            };

            View.OnClickListener confirmTimeBtn = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (apartmentSelectedList!= null){
                        apartmentSelectedList.clear();
                    }
                    apartmentSelectedList.add(apartmentItem.getApartmentNo());
                    Intent intent = new Intent(context, AppointmentConfirmActivity.class);
                    intent.putExtra("userId",userId);
                    intent.putExtra("apartmentSelectedList", apartmentSelectedList);
                    context.startActivity(intent);
                }
            };

            holder.deleteBtn.setOnClickListener(deleteItemListener);
            holder.confirmTimeBtn.setOnClickListener(confirmTimeBtn);

        }



        return v;
    }



}
