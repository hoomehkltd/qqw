package com.example.user.mapapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.lang.Float;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import java.util.ArrayList;
import java.util.Iterator;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener,OnInfoWindowClickListener{

    private  GoogleMap mMap;
    public BuildingDatabaseOperation dh;
    private SQLiteDatabase db;
    private MapNode HKNode;
    private Cursor cs;
    private Marker mLastSelectedMarker;
    private RadioGroup mOptions;
    public static int regionZoomLevel=10;
    public static int districtZoomLevel=11;
    public static int zoomLevel = 10;
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
    public boolean onMarkerClick(final Marker marker)  {
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        mLastSelectedMarker = marker;
        zoomLevel = Math.round(mMap.getCameraPosition().zoom);

        if (zoomLevel==regionZoomLevel){
            addMarkersToMap.addDistrictMarkersToMap(cs,mMap,marker.getPosition());
        }
        else if (zoomLevel==districtZoomLevel){
//            addMarkersToMap.addDistrictMarkersToMap(cs,mMap,marker.getPosition());
        }

        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Click Info Window", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        cs = BuildingDatabaseOperation.getInformation(db);
        addMarkersToMap.addInitialMarkersToMap(cs, mMap);
        mMap.setOnMarkerClickListener(this);

    }

}

//    public void addFlatMarkersToMap(ArrayList<Object> BuildingList){
//        for(int i = 0; i< BuildingList.size(); i++){
//            BuildingData Building = (BuildingData) BuildingList.get(i);
//            LatLng latlng = Building.getLatLng();
//            Log.d(Integer.toString(i) + " latlng figure", Double.toString(latlng.latitude) + " ,  " + Double.toString(latlng.longitude));
//            mMap.addMarker(new MarkerOptions().position(latlng).title(Building.getBuildingName()).snippet("Price: "+Building.getFlatPrice()));
//        }
//    }