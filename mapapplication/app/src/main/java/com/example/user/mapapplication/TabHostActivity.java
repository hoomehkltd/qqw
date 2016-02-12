package com.example.user.mapapplication;

import android.app.*;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;

import me.next.slidebottompanel.SlideBottomPanel;

/**
 * Created by user on 19/12/2015.
 */
public class TabHostActivity extends FragmentActivity implements TabHost.OnTabChangeListener, GoogleMap.OnMarkerClickListener, OnMapReadyCallback {
    public static SlideBottomPanel sbv;
    public DatabaseOperationApartment dh;
    private SQLiteDatabase db;
    public Cursor cs;
    public DatabaseOperationUser userDH;
    public SQLiteDatabase userDb;
    public String userDbPath;
    public Cursor userCs;
    public String apartmentDbPath;
    public User user;
    public static int userId;
    public static ArrayList<Apartment> apartmentList;
    ListView apartmentListView;
    private Marker mLastSelectedMarker;
    public static int zoomLevel =0;
    public static float districtZoomLevel = 11;
    public static float regionZoomLevel = 10;
    private GoogleApiClient client;
    private static GoogleMap mMap;
    private MapView mapView;
    public static LocalActivityManager mLocalActivityManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        DatabaseDirectory.CreateXML();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_bottom_panel);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //Apartment Database Initiation
        dh = new DatabaseOperationApartment(this, Apartment.ApartmentInfo.DatabaseName, null, 1);
        db = dh.opendb();
        apartmentDbPath = db.getPath();
        cs = DatabaseOperationApartment.getCursor(db);
        DataOperationApartment Input = new DataOperationApartment();
        Input.randomApartment(dh, db);
        DatabaseDirectory.setApartmentDbPath(apartmentDbPath);
        Log.d("ApartmentIsSet" ,"ApartmentIsSet");

        //User Database Initiation
        userDH = new DatabaseOperationUser(this,User.UserInfo.DatabaseName,null,1);
        userDb = userDH.opendb();
        userDbPath = userDb.getPath();
        new DataOperationUser().generateRandomUserData(userDb,userDH);
        userCs= userDH.getCursor(userDb);
        userInitialize(userDb, userDH);
        DatabaseDirectory.setUserDbPath(userDbPath);

        // Residential District Database Initiation
        DatabaseOperationResidentialDistrict dh = new DatabaseOperationResidentialDistrict(this, ResidentialDistrict.ResidentialDistrictInfo.DatabaseName, null, 1);
        SQLiteDatabase resDisDb = dh.opendb();
        String resDisDbPath = resDisDb.getPath();
        DatabaseDirectory.setResidentialDistrictDbPath(resDisDbPath);
        DataOperationResidentialDistrict.generateRandomResDis(10);

        //Set MapView
        final View mapFragmentView = CreateMapFragmentView();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragmentMap);
        mapFragment.getMapAsync(TabHostActivity.this);

        //Set Tabhost View
        sbv = (SlideBottomPanel) findViewById(R.id.slidebottompanel);
        TabHost th = (TabHost)this.findViewById(android.R.id.tabhost);
        th.setup();
        mLocalActivityManager = new LocalActivityManager(this, false);
        mLocalActivityManager.dispatchCreate(savedInstanceState);
        th.setup(mLocalActivityManager);

        //Setup Tab
        setUpTab(th, mapFragmentView);




        apartmentList = new DataOperationApartment().getInitialApartmentList(cs);
        apartmentListView = (ListView) findViewById(R.id.buildinglist);
        apartmentListView = setApartmentListView(apartmentListView, apartmentList);
        apartmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long flags) {
                Apartment apartmentItem = (Apartment) apartmentListView.getItemAtPosition(position);
                String apartmentNo = apartmentItem.getApartmentNo();

                Intent apartmentBundle = new Intent(TabHostActivity.this, ApartmentActivity.class);
                apartmentBundle.putExtra("apartmentNo", apartmentNo);
                apartmentBundle.putExtra("apartmentDbPath", apartmentDbPath);
                apartmentBundle.putExtra("userId", getUser().getId());
                apartmentBundle.putExtra("userDbPath", userDbPath);
                apartmentBundle.putExtra("pricePerMonth", apartmentItem.getFlatPrice());
                startActivity(apartmentBundle);
            }
        });

    }



    public void userInitialize(SQLiteDatabase userdb, DatabaseOperationUser userdh){
        user = new User();
        userId = 0;
        user.setId(userId);
        Cursor userCs = userdh.getCursor(userdb);
        userCs.moveToFirst();
        while(userCs.moveToNext()){
            if(userCs.getString(0).equals(userId)){
                user.setPhoneNo(Integer.parseInt(userCs.getString(3)));
            }
        }

    }
    public User getUser() {
        return user;
    }
    public ListView setApartmentListView(ListView viewActionsList, ArrayList<Apartment> apartmentList){
        // Set Apartment Text, Set Number of Apartment, Set Adapter
        TextView textapartment = (TextView) findViewById(R.id.textapartment);
        TextView textnumofapartment = (TextView) findViewById(R.id.textnumofapartment);
        if(mLastSelectedMarker!=null){
            textapartment.setText(mLastSelectedMarker.getTitle());
        }
        textnumofapartment.setText(Integer.toString(apartmentList.size()));
        final ArrayAdapter<Apartment> adapter = new ListAdapterApartment(this,R.layout.item_apartmentitem,apartmentList);
        viewActionsList.setAdapter(adapter);


        return viewActionsList;
    }

    @Override
    public void onBackPressed() {
        Log.d("onBackPressed","");
        sbv.hide();
        super.onBackPressed();
        return;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("onKeyDown", "");
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            sbv.hidePanel();

        }
        return true;
    }


    @Override
    public boolean onMarkerClick(final Marker marker) {
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        mLastSelectedMarker = marker;

        if (zoomLevel == 0) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLastSelectedMarker.getPosition(), districtZoomLevel), 2000, null);
            addMarkersToMap.addDistrictMarkersToMap(cs, mMap);
            apartmentList = new DataOperationApartment().getRegionList(cs, mLastSelectedMarker.getTitle());
            apartmentListView = changeApartmentListApapter(apartmentListView, apartmentList);
            zoomLevel +=1;
            sbv.displayPanel();

        }
        else if (zoomLevel==1){
            apartmentList = new DataOperationApartment().getDistrictList(cs, mLastSelectedMarker.getTitle());
            apartmentListView = changeApartmentListApapter(apartmentListView, apartmentList);
            zoomLevel +=1;
            sbv.displayPanel();
        }
        else if (zoomLevel==2){
            apartmentList = new DataOperationApartment().getDistrictList(cs, mLastSelectedMarker.getTitle());
            apartmentListView = changeApartmentListApapter(apartmentListView, apartmentList);
            sbv.displayPanel();
        }
        return false;
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
    public void onPause() {
        super.onPause();
        try {
            mLocalActivityManager.dispatchPause(isFinishing());
        } catch (Exception e) {}
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            mLocalActivityManager.dispatchResume();
        } catch (Exception e) {}
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("Mapis", "Stop");
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

    public View CreateMapFragmentView(){
        View view = LayoutInflater.from(this).inflate(R.layout.fragment_event_map, null);
        return view;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.87365, 151.20689), 14.0f));
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        addMarkersToMap.addInitialMarkersToMap(cs, mMap);
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(22.447088, 114.137932)));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(regionZoomLevel), 2000, null);
    }

    public ListView changeApartmentListApapter(ListView apartmentListView, ArrayList<Apartment> apartmentList){
        // Set Apartment Text, Set Number of Apartment, Set Adapter
        TextView textapartment = (TextView) findViewById(R.id.textapartment);
        TextView textnumofapartment = (TextView) findViewById(R.id.textnumofapartment);
        if(mLastSelectedMarker!=null){
            textapartment.setText(mLastSelectedMarker.getTitle());
        }
        textnumofapartment.setText(Integer.toString(apartmentList.size()));
        final ArrayAdapter<Apartment> adapter = new ListAdapterApartment(this,R.layout.item_apartmentitem,apartmentList);
        apartmentListView.setAdapter(adapter);


        return apartmentListView;
    }

    public void setUpTab(TabHost th, final View mapFragmentView){
        TabHost.TabSpec tabSpec1 = th.newTabSpec("Map View");
        tabSpec1.setIndicator("Map View");
        tabSpec1.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                return mapFragmentView;
            }
        });
        th.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = th.newTabSpec("ShoppingCart");
        tabSpec2.setIndicator("Shopping Cart");
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        intent.putExtra("userId", userId);
        tabSpec2.setContent(intent);
        th.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = th.newTabSpec("Booked");
        tabSpec3.setIndicator("Booked Cart");
        Intent intent2 = new Intent(this, BookedAppointmentActivity.class);
        intent2.putExtra("userId",userId);
        tabSpec3.setContent(intent2);
        th.addTab(tabSpec3);
    }

    @Override
    public void onTabChanged(String tabId) {

    }
}