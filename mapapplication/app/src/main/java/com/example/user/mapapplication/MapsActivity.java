//package com.example.user.mapapplication;
//
//import android.content.Context;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.net.Uri;
//import android.os.Handler;
//import android.os.SystemClock;
//import android.support.v4.app.FragmentActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.Window;
//import android.view.animation.BounceInterpolator;
//import android.view.animation.Interpolator;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//import java.lang.Float;
//
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
//import java.util.ArrayList;
//import java.util.Iterator;
//import shared.ui.actionscontentview.ActionsContentView;
//import com.gc.materialdesign.widgets.Dialog;
//import com.gc.materialdesign.widgets.*;
//import com.google.gson.Gson;
//
//import android.view.View.OnClickListener;
//
//import org.kymjs.kjframe.KJDB;
//import org.kymjs.kjframe.database.DaoConfig;
//import org.w3c.dom.Element;
//
//
//public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, OnInfoWindowClickListener {
//
//    private static GoogleMap mMap;
//    public DatabaseOperationApartment dh;
//    private SQLiteDatabase db;
//    public Cursor cs;
//    public DatabaseOperationUser userDH;
//    public SQLiteDatabase userDb;
//    public String userDbPath;
//    public Cursor userCs;
//    private MapNode HKNode;
//    private Marker mLastSelectedMarker;
//    private RadioGroup mOptions;
//    public static float regionZoomLevel = 10;
//    public static float districtZoomLevel = 11;
//    private static ActionsContentView viewActionsContentView;
//    public static ArrayList<Apartment> apartmentList;
//    public ListView viewActionsList;
//    public static int zoomLevel =0;
//    private Apartment myLastApartmentClick;
//    public String apartmentDbPath;
//    public User user;
//
//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    private GoogleApiClient client;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//
//        //View Initiation
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        apartmentList = new DataOperationApartment().getInitialApartmentList(cs);
//        viewActionsContentView = (ActionsContentView) findViewById(R.id.actionsContentView);
//        viewActionsList = (ListView) findViewById(R.id.apartmentlist);
////        viewActionsList = setViewActionsList(viewActionsList, apartmentList);
//        viewActionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapter, View v, int position,
//                                    long flags) {
//                Apartment apartmentItem = (Apartment) viewActionsList.getItemAtPosition(position);
//                String apartmentNo = apartmentItem.getApartmentNo();
//
//                Intent apartmentBundle = new Intent(MapsActivity.this, ApartmentActivity.class);
//                apartmentBundle.putExtra("apartmentNo", apartmentNo);
//                apartmentBundle.putExtra("apartmentDbPath", apartmentDbPath);
//                apartmentBundle.putExtra("userId", getUser().getId());
//                apartmentBundle.putExtra("userDbPath", userDbPath);
//                apartmentBundle.putExtra("pricePerMonth", apartmentItem.getFlatPrice());
//                startActivity(apartmentBundle);
//            }
//        });
//
//
//        showMap();
//
//
//
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
//    }
//
//    public ListView setViewActionsList(ListView viewActionsList, ArrayList<Apartment> apartmentList){
//        // Set Apartment Text, Set Number of Apartment, Set Adapter
//        TextView textapartment = (TextView) findViewById(R.id.textapartment);
//        TextView textnumofapartment = (TextView) findViewById(R.id.textnumofapartment);
//        if(mLastSelectedMarker!=null){
//            textapartment.setText(mLastSelectedMarker.getTitle());
//        }
//        textnumofapartment.setText(Integer.toString(apartmentList.size()));
//        final ArrayAdapter<Apartment> adapter = new ListAdapterApartment(this,R.layout.item_apartmentitem,apartmentList);
//        viewActionsList.setAdapter(adapter);
//
//
//        return viewActionsList;
//    }
////    public void userInitialize(SQLiteDatabase userdb, DatabaseOperationUser userdh){
////    user = new User();
////    int userId = 0;
////    user.setId(userId);
////    Cursor userCs = userdh.getCursor(userdb);
////        userCs.moveToFirst();
////        while(userCs.moveToNext()){
////            if(userCs.getString(0).equals(userId)){
////                user.setPhoneNo(Integer.parseInt(userCs.getString(3)));
////            }
////        }
////
////    }
//    public void showMap(){
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//        getSupportFragmentManager().beginTransaction().show(mapFragment).commit();
//        viewActionsContentView.showContent();
//
//    };
//    @Override
//    public boolean onMarkerClick(final Marker marker) {
//        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
//        mLastSelectedMarker = marker;
//
//        if (zoomLevel == 0) {
//            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLastSelectedMarker.getPosition(), markertZoomLevel), 2000, null);
//            addMarkersToMap.addDistrictMarkersToMap(cs, mMap);
//            apartmentList = new DataOperationApartment().getRegionList(cs, mLastSelectedMarker.getTitle());
//            viewActionsList = setViewActionsList(viewActionsList, apartmentList);
//            zoomLevel +=1;
//        }
//        else if (zoomLevel==1){
//            apartmentList = new DataOperationApartment().getDistrictList(cs, mLastSelectedMarker.getTitle());
////            viewActionsList = setViewActionsList(viewActionsList, apartmentList);
//            zoomLevel +=1;
//
//        }
//        else if (zoomLevel==2){
//            apartmentList = new DataOperationApartment().getDistrictList(cs, mLastSelectedMarker.getTitle());
////            viewActionsList = setViewActionsList(viewActionsList, apartmentList);
//
//        }
//        return false;
//    }
//
//    @Override
//    public void onInfoWindowClick(Marker marker) {
//        Toast.makeText(this, "Click Info Window", Toast.LENGTH_SHORT).show();
//    }
//
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        mMap.getUiSettings().setZoomGesturesEnabled(true);
//        addMarkersToMap.addInitialMarkersToMap(cs, mMap);
//        mMap.setOnMarkerClickListener(this);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(22.447088, 114.137932)));
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(regionZoomLevel), 2000, null);
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Maps Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.user.mapapplication/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        Log.d("Mapis", "Stop");
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Maps Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.user.mapapplication/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }
//
//
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Apartment getMyLastApartmentClick() {
//        return myLastApartmentClick;
//    }
//
//    public void setMyLastApartmentClick(Apartment myLastApartmentClick) {
//        this.myLastApartmentClick = myLastApartmentClick;
//    }
//
//
//
//}
//
////    public void addFlatMarkersToMap(ArrayList<Object> ApartmentList){
////        for(int i = 0; i< ApartmentList.size(); i++){
////            apartment Apartment = (apartment) ApartmentList.get(i);
////            LatLng latlng = Apartment.getLatLng();
////            Log.d(Integer.toString(i) + " latlng figure", Double.toString(latlng.latitude) + " ,  " + Double.toString(latlng.longitude));
////            mMap.addMarker(new MarkerOptions().position(latlng).title(Apartment.getApartmentName()).snippet("Price: "+Apartment.getFlatPrice()));
////        }
////    }