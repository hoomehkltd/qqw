package com.example.user.mapapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.gson.Gson;

import org.kymjs.kjframe.KJDB;
import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.KJDB;
import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.ViewInject;
import org.kymjs.kjframe.utils.StringUtils;


import java.util.ArrayList;


/**
 * Created by user on 11/12/2015.
 */
public class DatabaseOperationUser extends SQLiteOpenHelper {
    public static final int database_version=1;
    public String CreateQuery =
            "CREATE TABLE " + User.UserInfo.TableName+"("+
                    User.UserInfo.id+" TEXT,"+
                    User.UserInfo.password+" TEXT,"+
                    User.UserInfo.name+" TEXT,"+
                    User.UserInfo.phoneNo+" TEXT,"+
                    User.UserInfo.apartmentVisitLog+" TEXT,"+
                    User.UserInfo.apartmentAppointment+" TEXT,"+
                    User.UserInfo.apartmentShoppingCart+" TEXT,"+
                    User.UserInfo.msg+" TEXT,"+
                    User.UserInfo.agentList+" TEXT);"
            ;

    public DatabaseOperationUser(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, User.UserInfo.DatabaseName, null, database_version);
        Log.d("Database Operations", "Database Created");
    }

    @Override
    public void onCreate (SQLiteDatabase sdb){
        sdb.execSQL(CreateQuery);
        Log.d("Table Operations", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2){

    }

    public SQLiteDatabase opendb(){
        SQLiteDatabase SQ = this.getWritableDatabase();
        return SQ;
    }

    public synchronized void closedb(SQLiteDatabase sdb){
        this.close();
    }

    public void putInfomation(SQLiteDatabase DB, int id, String password, String name, int phoneNo, ArrayList<Appointment> apartmentVisitLog,  ArrayList<Appointment> apartmentAppointment, ArrayList<String> apartmentShoppingCart, String msg, ArrayList<Agent> agentList){


        ContentValues cv = new ContentValues();

        cv.put(User.UserInfo.id, id);
        cv.put(User.UserInfo.password, password);
        cv.put(User.UserInfo.name, name);
        cv.put(User.UserInfo.phoneNo, phoneNo);
        cv.put(User.UserInfo.apartmentVisitLog, new Gson().toJson(apartmentVisitLog));
        cv.put(User.UserInfo.apartmentAppointment, new Gson().toJson(apartmentAppointment));
        cv.put(User.UserInfo.apartmentShoppingCart, new Gson().toJson(apartmentShoppingCart));
        cv.put(User.UserInfo.msg, msg);
        cv.put(User.UserInfo.agentList, new Gson().toJson(agentList));
        DB.insert(User.UserInfo.TableName, null, cv);

        Log.d("Database Operations", "One Row Inserted");
    }

    public static Cursor getCursor(SQLiteDatabase db){

        Cursor cs = db.query(User.UserInfo.TableName,null,null,null,null,null,null);

        return cs;
    }


}
