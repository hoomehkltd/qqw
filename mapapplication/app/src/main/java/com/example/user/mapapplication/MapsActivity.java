package com.example.user.mapapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.lang.Float;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
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
import shared.ui.actionscontentview.ActionsContentView;
import com.gc.materialdesign.widgets.Dialog;
import com.gc.materialdesign.widgets.*;
import android.view.View.OnClickListener;

import org.kymjs.kjframe.KJDB;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, OnInfoWindowClickListener {

    private static GoogleMap mMap;
    public BuildingDatabaseOperation dh;
    private SQLiteDatabase db;
    public Cursor cs;
    private MapNode HKNode;
    private Marker mLastSelectedMarker;
    private RadioGroup mOptions;
    public static float regionZoomLevel = 10;
    public static float districtZoomLevel = 11;
    private static ActionsContentView viewActionsContentView;
    public ArrayList<BuildingData> buildingList;
    public ListView viewActionsList;
    public static int zoomLevel =0;
    private User user;
    private BuildingData myLastBuildingClick;
    private KJDB userDb;
    public String dbpath;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //Database Initiation
        dh = new BuildingDatabaseOperation(this, BuildingData.BuildingInfo.DatabaseName, null, 1);
        db = dh.opendb();
        dbpath = db.getPath();
        cs = BuildingDatabaseOperation.getInformation(db);
        BuildingDataInput Input = new BuildingDataInput();
        Input.BuildingData(dh, db);

        //View Initiation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewActionsContentView = (ActionsContentView) findViewById(R.id.actionsContentView);
        viewActionsList = (ListView) findViewById(R.id.buildinglist);
        buildingList = new BuildingDataExtract().getInitialBuildingList(cs);
        final ArrayAdapter<BuildingData> adapter = new BuildingListAdapter(this,R.layout.item_buildingitem,buildingList);
        viewActionsList.setAdapter(adapter);
        viewActionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long flags) {
                BuildingData buildingItem = (BuildingData)viewActionsList.getItemAtPosition(position);
                String buildingNo = buildingItem.getBuildingNo();

                Intent buildingDataBundle = new Intent(MapsActivity.this, BuildingActivity.class);
                buildingDataBundle.putExtra("BuildingNo", buildingNo);
                buildingDataBundle.putExtra("dbpath", dbpath);
                startActivity(buildingDataBundle);
            }
        });


        showMap();




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void showMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getSupportFragmentManager().beginTransaction().show(mapFragment).commit();
        viewActionsContentView.showContent();

    };
    @Override
    public boolean onMarkerClick(final Marker marker) {
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        mLastSelectedMarker = marker;

        if (zoomLevel == 0) {
            Log.d("ZoomLevel Comparison", "zoomLevel==regionZoomLevel");
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLastSelectedMarker.getPosition(), districtZoomLevel), 2000, null);
            Log.d("New ZoomLevel", Float.toString(zoomLevel));
            addMarkersToMap.addDistrictMarkersToMap(cs, mMap);
            buildingList.clear();
            Log.d("marker region",marker.getTitle());
            ArrayList<String>regionBuildingNameList = new BuildingListOperation().getRegionBuildingNameList(cs, marker.getTitle());

            Iterator<String> regionBuildingNameListIterator =  regionBuildingNameList.iterator() ;
            while(regionBuildingNameListIterator.hasNext()){
                Log.d("regionBuildingName",regionBuildingNameListIterator.next());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,regionBuildingNameList);
            viewActionsList.setAdapter(adapter);
            zoomLevel +=1;


        }
        else if (zoomLevel==1){
            Log.d("ZoomLevel Comparison", "zoomLevel==districtZoomLevel");
            ArrayList<String>districtBuildingNameList = new BuildingListOperation().getDistrictBuildingNameList(cs, marker.getTitle());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,districtBuildingNameList);
            viewActionsList.setAdapter(adapter);

        }

        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Click Info Window", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        addMarkersToMap.addInitialMarkersToMap(cs, mMap);
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(22.447088, 114.137932)));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(regionZoomLevel), 2000, null);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.user.mapapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.user.mapapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BuildingData getMyLastBuildingClick() {
        return myLastBuildingClick;
    }

    public void setMyLastBuildingClick(BuildingData myLastBuildingClick) {
        this.myLastBuildingClick = myLastBuildingClick;
    }

    public KJDB getUserDb() {
        return userDb;
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