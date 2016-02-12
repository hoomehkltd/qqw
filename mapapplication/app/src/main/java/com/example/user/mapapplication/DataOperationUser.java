package com.example.user.mapapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.kymjs.kjframe.KJDB;

import java.util.ArrayList;

/**
 * Created by user on 15/12/2015.
 */
public class DataOperationUser {

    public void addItemtoShoppingCart(int userId, String ApartmentNo){
        String apartmentShoppingCartString;
        ArrayList<String> shoppingCart = new ArrayList<String>();
        String deser;
        Cursor cs = DatabaseDirectory.getUserDbCursor();
        cs.moveToFirst();
        Log.d("cs.moveToFirst()", "cs.moveToFirst()");
        while (cs.moveToNext()){
            if (cs.getString(0).equals(Integer.toString(userId))){
                apartmentShoppingCartString = cs.getString(6);
                shoppingCart = new Gson().fromJson(apartmentShoppingCartString, new TypeToken<ArrayList<String>>() {}.getType());
                if (shoppingCart!=null){
                    shoppingCart.add(ApartmentNo);
                }
                else {
                    shoppingCart = new ArrayList<String>();
                    shoppingCart.add(ApartmentNo);
                }
                Log.d("shoppingCartisRetrieved", shoppingCart.toString());
            }
        }

        deser = new Gson().toJson(shoppingCart);
        ContentValues contentValues = new ContentValues();
//        contentValues.put();
        SQLiteDatabase userDb = SQLiteDatabase.openDatabase(DatabaseDirectory.getUserDbPath(), null, 0);
        userDb.execSQL("UPDATE " + User.UserInfo.TableName + " SET " + User.UserInfo.apartmentShoppingCart + "='" + deser + "' WHERE " + User.UserInfo.id + "='" + userId + "'");

    }

    public void addtoAppointmentList(int userId, Appointment appointment){
        ArrayList<Appointment> comblinedList = new ArrayList<Appointment>();
        String appointmentListString;
        ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
        String deser;
        Cursor cs = DatabaseDirectory.getUserDbCursor();
        cs.moveToFirst();
        Log.d("cs.moveToFirst()", "cs.moveToFirst()");
        while (cs.moveToNext()){
            if (cs.getString(0).equals(Integer.toString(userId))){
                appointmentListString = cs.getString(5);
                try{
                    appointmentList = new Gson().fromJson(appointmentListString, new TypeToken<ArrayList<Appointment>>() {}.getType());
                }catch (Exception e){};

                if (appointmentList!=null){
                    comblinedList.addAll(appointmentList);
                    comblinedList.add(appointment);
                }
                else {
                    comblinedList.add(appointment);
                    Log.d("appointmentListisAdded", comblinedList.toString());
                }

            }
        }

        deser = new Gson().toJson(comblinedList);
        ContentValues contentValues = new ContentValues();
//        contentValues.put();
        SQLiteDatabase userDb = SQLiteDatabase.openDatabase(DatabaseDirectory.getUserDbPath(), null, 0);
        userDb.execSQL("UPDATE " + User.UserInfo.TableName + " SET " + User.UserInfo.apartmentAppointment + "='" + deser + "' WHERE " + User.UserInfo.id + "='" + userId + "'");

    };

    public static void deleteItemFromShoppingCart (int userId, String ApartmentNo){
        String apartmentShoppingCartString;
        ArrayList<String> shoppingCart = new ArrayList<String>();
        String deser;
        Cursor cs = DatabaseDirectory.getUserDbCursor();
        cs.moveToFirst();
        Log.d("cs.moveToFirst()", "cs.moveToFirst()");
        while (cs.moveToNext()){
            if (cs.getString(0).equals(Integer.toString(userId))){
                apartmentShoppingCartString = cs.getString(6);
                shoppingCart = new Gson().fromJson(apartmentShoppingCartString, new TypeToken<ArrayList<String>>() {}.getType());
                if (shoppingCart!=null){
                    shoppingCart.remove(shoppingCart.indexOf(ApartmentNo));
                }

                Log.d("CartItemisRemoved", shoppingCart.toString());
            }
        }

        deser = new Gson().toJson(shoppingCart);
        ContentValues contentValues = new ContentValues();
//        contentValues.put();
        SQLiteDatabase userDb = SQLiteDatabase.openDatabase(DatabaseDirectory.getUserDbPath(), null, 0);
        userDb.execSQL("UPDATE " + User.UserInfo.TableName + " SET " + User.UserInfo.apartmentShoppingCart + "='" + deser + "' WHERE " + User.UserInfo.id + "='" + userId + "'");
    }

    public static ArrayList<String> getShoppingCartItemIdList(int userId){
        String apartmentShoppingCartString = "";
        Cursor cs = DatabaseDirectory.getUserDbCursor();
        ArrayList<String> shoppingCartItemIdList = new ArrayList<String>();
        cs.moveToFirst();
        while (cs.moveToNext()){
            if (cs.getString(0).equals(Integer.toString(userId))){
                apartmentShoppingCartString = cs.getString(6);
                shoppingCartItemIdList = new Gson().fromJson(apartmentShoppingCartString, new TypeToken<ArrayList<String>>() {}.getType());
                if (shoppingCartItemIdList==null){
                    Log.d("ShoppingCart", "isEmpty");
                }
                else{
                    Log.d("shoppingCartisRetrieved", shoppingCartItemIdList.toString());
                }

            }
        }
        return shoppingCartItemIdList;
    }

    public static ArrayList<Appointment> getAppointmentList(int userId){
        String AppointmentListString = "";
        Cursor cs = DatabaseDirectory.getUserDbCursor();
        ArrayList<Appointment> AppointmentList = new ArrayList<Appointment>();
        cs.moveToFirst();
        while (cs.moveToNext()){
            if (cs.getString(0).equals(Integer.toString(userId))){
                AppointmentListString = cs.getString(5);
                try{
                    AppointmentList = new Gson().fromJson(AppointmentListString, new TypeToken<ArrayList<Appointment>>() {}.getType());
                }
                catch (Exception e){
                    Log.d("Exception", e.toString());
                }

                if (AppointmentList==null){
                    Log.d("AppointmentList", "isEmpty");
                }
                else{
                    Log.d("AppointmentRetrieved", AppointmentList.toString());
                }

            }
        }
        return AppointmentList;
    }


    public void generateRandomUserData(SQLiteDatabase db, DatabaseOperationUser dh){

        for(int i=0; i<10; i++){
            User user = new User();
            user.setId(i);
            user.setName("user" + i);
            user.setPhoneNo(randomData.getRandomPhoneNo());
            user.setPassword(Integer.toString(randomData.getRandomPhoneNo()));
            dh.putInfomation(db,user.getId(),user.getPassword(),user.getName(),user.getPhoneNo(),null,null,null,null,null);

        }

    }
}
