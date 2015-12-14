package com.example.user.mapapplication;

import org.kymjs.kjframe.KJDB;

import java.util.ArrayList;

/**
 * Created by user on 11/12/2015.
 */
public class shoppingCartActivity {
    public shoppingCartActivity() {
    }

    public ArrayList<BuildingData> initializeShoppingCart(KJDB kjdb, User user) {
        ArrayList<BuildingData> buildingShoppingCart = kjdb.findAllByWhere(User.class, "phoneNo=" + Integer.toString(user.getPhoneNo())).get(0).getBuildingShoppingCart();
        return buildingShoppingCart;
    }
}
