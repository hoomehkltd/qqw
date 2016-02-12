package com.example.user.mapapplication;

import android.provider.BaseColumns;

/**
 * Created by user on 20/12/2015.
 */
public class ResidentialDistrict {

    private String ResidentialDistrictKind;
    private int ResidentialDistrictCount;
    private String districtArea;
    private String constructionArea;
    private String managementCompany;
    private float managementFee;
    private int carParkCount;
    private String developer;
    private float greenPercentage;
    private String description;

    public String getResidentialDistrictKind() {
        return ResidentialDistrictKind;
    }

    public void setResidentialDistrictKind(String ResidentialDistrictKind) {
        this.ResidentialDistrictKind = ResidentialDistrictKind;
    }

    public int getResidentialDistrictCount() {
        return ResidentialDistrictCount;
    }

    public void setResidentialDistrictCount(int ResidentialDistrictCount) {
        this.ResidentialDistrictCount = ResidentialDistrictCount;
    }

    public String getDistrictArea() {
        return districtArea;
    }

    public void setDistrictArea(String districtArea) {
        this.districtArea = districtArea;
    }

    public String getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(String constructionArea) {
        this.constructionArea = constructionArea;
    }

    public String getManagementCompany() {
        return managementCompany;
    }

    public void setManagementCompany(String managementCompany) {
        this.managementCompany = managementCompany;
    }

    public float getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(float managementFee) {
        this.managementFee = managementFee;
    }

    public int getCarParkCount() {
        return carParkCount;
    }

    public void setCarParkCount(int carParkCount) {
        this.carParkCount = carParkCount;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public float getGreenPercentage() {
        return greenPercentage;
    }

    public void setGreenPercentage(float greenPercentage) {
        this.greenPercentage = greenPercentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static abstract class ResidentialDistrictInfo implements BaseColumns {
        public static final String ResidentialDistrictNo = "ResidentialDistrictNo";
        public static final String ResidentialDistrictKind = "ResidentialDistrictKind";
        public static final String ResidentialDistrictCount = "ResidentialDistrictCount";
        public static final String districtArea = "districtArea";
        public static final String constructionArea = "constructionArea";
        public static final String managementCompany = "managementCompany";
        public static final String managementFee = "managementFee";
        public static final String carParkCount = "carParkCount";
        public static final String developer = "developer";
        public static final String greenPercentage = "greenPercentage";
        public static final String description = "description";
        public static final String DatabaseName = "residentialDistrictDatabase";
        public static final String TableName="residentialDistrictTable";
    }
}
