package com.example.user.mapapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public BuildingDatabaseOperation dh;
    private SQLiteDatabase db;
    private MapNode HKNode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dh = new BuildingDatabaseOperation(this,BuildingData.BuildingInfo.DatabaseName,null,1);
        db=dh.opendb();
        BuildingDataInput Input = new BuildingDataInput();
        Input.BuildingData(dh,db);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MapNode abuildingnode = new MapNode("abuiding",-24,151);
        MapNode bbuildingnode = new MapNode("bbuiding",-24,141);
        MapNode cbuildingnode = new MapNode("cbuiding",-24,131);
        MapNode dbuildingnode = new MapNode("dbuiding",-24,121);
        MapNode ebuildingnode = new MapNode("ebuiding",-24,111);
        MapNode fbuildingnode = new MapNode("fbuiding",-24,101);


//        LatLng bbuildingnodecoord = Tree.bbuildingnode.getCoordination();
//        LatLng cbuildingnodecoord = Tree.cbuildingnode.getCoordination();
//        LatLng dbuildingnodecoord = Tree.dbuildingnode.getCoordination();
//        LatLng ebuildingnodecoord = Tree.ebuildingnode.getCoordination();
//        LatLng fbuildingnodecoord = Tree.fbuildingnode.getCoordination();
//        LatLng gbuildingnodecoord = Tree.gbuildingnode.getCoordination();

        mMap.addMarker(new MarkerOptions().position(abuildingnode.getCoordination()));
        mMap.addMarker(new MarkerOptions().position(bbuildingnode.getCoordination()));
        mMap.addMarker(new MarkerOptions().position(cbuildingnode.getCoordination()));
        mMap.addMarker(new MarkerOptions().position(dbuildingnode.getCoordination()));
        mMap.addMarker(new MarkerOptions().position(ebuildingnode.getCoordination()));
        mMap.addMarker(new MarkerOptions().position(fbuildingnode.getCoordination()));

//        mMap.addMarker(new MarkerOptions().position(cbuildingnodecoord).title("Marker in Sydney"));
//        mMap.addMarker(new MarkerOptions().position(dbuildingnodecoord).title("Marker in Sydney"));
//        mMap.addMarker(new MarkerOptions().position(ebuildingnodecoord).title("Marker in Sydney"));
//        mMap.addMarker(new MarkerOptions().position(fbuildingnodecoord).title("Marker in Sydney"));
//        mMap.addMarker(new MarkerOptions().position(gbuildingnodecoord).title("Marker in Sydney"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(bbuildingnode.getCoordination()));
    }






}
