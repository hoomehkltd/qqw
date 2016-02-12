package com.example.user.mapapplication;

import android.provider.BaseColumns;

import org.kymjs.kjframe.database.annotate.Table;

import java.util.ArrayList;

/**
 * Created by user on 11/12/2015.
 */
public class User {
    private int id;
    private String password;
    private String name;
    private int phoneNo;
    private ArrayList<Appointment> apartmentVisitLog;
    private ArrayList<Appointment> apartmentAppointment;
    private ArrayList<String> apartmentShoppingCart;
    private String msg;
    private ArrayList<Agent> agentList;

    public User() {
        initializeUserData();
    }

    public void initializeUserData(){
        apartmentAppointment = new ArrayList<Appointment>();
        apartmentShoppingCart = new ArrayList<String>();
        setApartmentShoppingCart(apartmentShoppingCart);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public ArrayList<Appointment> getApartmentVisitLog() {
        return apartmentVisitLog;
    }

    public void setApartmentVisitLog(ArrayList<Appointment> apartmentVisitLog) {
        this.apartmentVisitLog = apartmentVisitLog;
    }

    public ArrayList<Appointment> getApartmentAppointment() {
        return apartmentAppointment;
    }

    public void setApartmentAppointment(ArrayList<Appointment> apartmentAppointment) {
        this.apartmentAppointment = apartmentAppointment;
    }

    public ArrayList<String> getApartmentShoppingCart() {
        return apartmentShoppingCart;
    }

    public void setApartmentShoppingCart(ArrayList<String> apartmentShoppingCart) {
        this.apartmentShoppingCart = apartmentShoppingCart;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<Agent> getAgentList() {
        return agentList;
    }

    public void setAgentList(ArrayList<Agent> agentList) {
        this.agentList = agentList;
    }

    public static abstract class UserInfo implements BaseColumns {
        public static final String TableName="table_user";
        public static final String id = "id";
        public static final String password = "password";
        public static final String name = "name";
        public static final String phoneNo = "phoneNo";
        public static final String apartmentVisitLog = "apartmentVisitLog";
        public static final String apartmentAppointment = "apartmentAppointment";
        public static final String apartmentShoppingCart = "apartmentShoppingCart";
        public static final String msg = "msg";
        public static final String agentList = "agentList";
        public static final String DatabaseName = "database_user";


    }
}
