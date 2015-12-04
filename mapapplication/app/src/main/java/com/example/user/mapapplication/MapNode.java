package com.example.user.mapapplication;

import java.util.ArrayList;
import com.google.android.*;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by user on 1/12/2015.
 */
public class MapNode {
    private ArrayList<MapNode> nodes;
    private float minScaleFactor;
    private float maxScaleFactor;
    private String name;
    private int flatCount;
    private float mapX;
    private float mapY;
    private LatLng coord;

    public MapNode(String locationName, int a ,int b)
    {
        nodes = new ArrayList<MapNode>();
        name = locationName;
        coord = new LatLng(a,b);
    }

    public float getMinScaleFactor()
    {
        return minScaleFactor;
    }

    public void setMinScaleFactor(float value)
    {
        minScaleFactor = value;
    }

    public void addChild(MapNode child)
    {
        nodes.add(child);
    }

    public LatLng getCoordination(){
        return coord;
    }
}
