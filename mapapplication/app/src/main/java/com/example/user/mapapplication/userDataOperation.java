package com.example.user.mapapplication;

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
public class userDataOperation {
    public userDataOperation() {
    }

    public void generateRandomUserData(KJDB db){

        for(int i=0; i<10; i++){
            User user = new User();
            user.setId(i);
            user.setName("user" + i);
            user.setPhoneNo(randomData.getRandomPhoneNo());
            user.setPassword(Integer.toString(randomData.getRandomPhoneNo()));
            db.save(user);

        }

    }

    public void addItemtoShoppingCartInput(User user, BuildingData buildingData, KJDB db){
        ArrayList<BuildingData> shoppingCart = user.getBuildingShoppingCart();
        shoppingCart.add(buildingData);
        user.setBuildingShoppingCart(shoppingCart);
        db.update(user, "phoneNo="+user.getPhoneNo());

    }

    public void deleteItemFromShoppingCart (User user, int position, KJDB db){
        ArrayList<BuildingData> shoppingCart = user.getBuildingShoppingCart();
        shoppingCart.remove(position);
        user.setBuildingShoppingCart(shoppingCart);
        db.update(user, "phoneNo="+user.getPhoneNo());
    }
}
