package com.example.user.mapapplication;

import java.util.ArrayList;

/**
 * Created by user on 11/12/2015.
 */
public class User {
    private int id;
    private String password;
    private String name;
    private int phoneNo;
    private ArrayList<Appointment> buildingVisitLog;
    private ArrayList<Appointment> buildingAppointment;
    private ArrayList<BuildingData> buildingShoppingCart;
    private String msg;
    private ArrayList<Agent> agentList;

    public User() {
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

    public ArrayList<Appointment> getBuildingVisitLog() {
        return buildingVisitLog;
    }

    public void setBuildingVisitLog(ArrayList<Appointment> buildingVisitLog) {
        this.buildingVisitLog = buildingVisitLog;
    }

    public ArrayList<Appointment> getBuildingAppointment() {
        return buildingAppointment;
    }

    public void setBuildingAppointment(ArrayList<Appointment> buildingAppointment) {
        this.buildingAppointment = buildingAppointment;
    }

    public ArrayList<BuildingData> getBuildingShoppingCart() {
        return buildingShoppingCart;
    }

    public void setBuildingShoppingCart(ArrayList<BuildingData> buildingShoppingCart) {
        this.buildingShoppingCart = buildingShoppingCart;
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
}
