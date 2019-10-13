package com.example.student;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
   DatabaseReference mRootRef = database.getReference();
   //DatabaseReference mChildref;
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        //Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

       final String[] drivers_array = new String[10];
        for(int i = 0; i <=3; ++i)
        {
            String drivers = "Driver_"+(i+1);
            drivers_array[i] = drivers;
        }
       final String[] route_arr = new String[10];
        for(int i = 0; i < 3; ++i)
        {
            String current_route = "Route_"+(i+1);
            route_arr[i] = current_route;
        }
        //mapFragment.getMapAsync(this);
        final Marker route11 = mMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).visible(false));
        //mapFragment.getMapAsync(this);
        final Marker route12 = mMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).visible(false));
        final LocationClass obj11 = new LocationClass();
        final LocationClass obj12 = new LocationClass();
        final LocationClass obj13 = new LocationClass();
        final LocationClass obj21 = new LocationClass();
        final LocationClass obj22 = new LocationClass();
        final LocationClass obj31 = new LocationClass();
        final LocationClass obj32 = new LocationClass();
        final LocationClass obj33 = new LocationClass();
        final LocationClass obj34 = new LocationClass();

        drivers obj= new drivers();
        final DatabaseReference mChildRef11 = mRootRef.child(route_arr[0]).child(drivers_array[0]);
        final DatabaseReference mChildRef12 = mRootRef.child(route_arr[0]).child(drivers_array[1]);
        final DatabaseReference mChildRef13 = mRootRef.child(route_arr[0]).child(drivers_array[2]);
        final DatabaseReference mChildRef21 = mRootRef.child(route_arr[1]).child(drivers_array[0]);
        final DatabaseReference mChildRef22 = mRootRef.child(route_arr[1]).child(drivers_array[1]);
        final DatabaseReference mChildRef34 = mRootRef.child(route_arr[2]).child(drivers_array[3]);
        final DatabaseReference mChildRef31 = mRootRef.child(route_arr[2]).child(drivers_array[0]);
        final DatabaseReference mChildRef32 = mRootRef.child(route_arr[2]).child(drivers_array[1]);
        final DatabaseReference mChildRef33 = mRootRef.child(route_arr[2]).child(drivers_array[2]);
        //mapFragment.getMapAsync(this);
        mChildRef11.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                // LocationClass obj = dataSnapshot.getValue(LocationClass.class);
              //  Log.i("output", obj.getLatitude().toString());
                //String obj1 = dataSnapshot.getValue(String.class);
                //Log.i("Output", obj1);
                String key = dataSnapshot.getKey();
                String val = dataSnapshot.getValue().toString();
             //   Log.d("Output", key);
              //  Log.d("Output", val);
                if(key.equals("Latitude")){
                    Double lat = Double.parseDouble(val);

                    obj11.setLatitude(lat);
                } else if(key.equals("Longitude")){
                    Double lon = Double.parseDouble(val);
                    obj11.setLongitude(lon);
                }
                if(obj11.isLatitude_flag() && obj11.isLongitude_flag()) {

                   // route11 = mMap.addMarker(new MarkerOptions().position(new LatLng(obj11.getLatitude(), obj11.getLongitude())).title("Bus 1"));
                    //route11.remove();
                    route11.setVisible(true);
                    route11.setPosition(new LatLng(obj11.getLatitude(), obj11.getLongitude()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(obj11.getLatitude(), obj11.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10));

                }


                //      Log.i("output", obj.getLatitude().toString());
                //   String obj1 = dataSnapshot.getValue(String.class);
                // Log.i("Output", obj1);


            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mChildRef12.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                String key = dataSnapshot.getKey();
                String val = dataSnapshot.getValue().toString();
                Log.d("Output", key);
                Log.d("shr", val);
                if(key.equals("Latitude"))
                {
                    Double lat = Double.parseDouble(val);

                    obj12.setLatitude(lat);
                } else if(key.equals("Longitude")){
                    Double lon = Double.parseDouble(val);
                    obj12.setLongitude(lon);
                }
                if(obj12.isLatitude_flag() && obj12.isLongitude_flag()) {
                    //mMap.clear();
                    //mMap.addMarker(new MarkerOptions().position(new LatLng(obj12.getLatitude(), obj12.getLongitude())).title("Bus 1"));
                    route12.setVisible(true);
                    route12.setPosition(new LatLng(obj12.getLatitude(), obj12.getLongitude()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(obj12.getLatitude(), obj12.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mChildRef13.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                String val = dataSnapshot.getValue().toString();
                if(key.equals("Latitude")){
                    Double lat = Double.parseDouble(val);

                    obj13.setLatitude(lat);
                } else if(key.equals("Longitude")){
                    Double lon = Double.parseDouble(val);
                    obj13.setLongitude(lon);
                }
                if(obj13.isLatitude_flag() && obj13.isLongitude_flag()) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(obj13.getLatitude(), obj13.getLongitude())).title("Bus 1"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(obj13.getLatitude(), obj13.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mChildRef21.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                String val = dataSnapshot.getValue().toString();
                if(key.equals("Latitude")){
                    Double lat = Double.parseDouble(val);

                    obj21.setLatitude(lat);
                } else if(key.equals("Longitude")){
                    Double lon = Double.parseDouble(val);
                    obj21.setLongitude(lon);
                }
                if(obj21.isLatitude_flag() && obj21.isLongitude_flag()) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(obj21.getLatitude(), obj21.getLongitude())).title("Bus 1"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(obj21.getLatitude(), obj21.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mChildRef22.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                String val = dataSnapshot.getValue().toString();
                if(key.equals("Latitude")){
                    Double lat = Double.parseDouble(val);

                    obj22.setLatitude(lat);
                } else if(key.equals("Longitude")){
                    Double lon = Double.parseDouble(val);
                    obj22.setLongitude(lon);
                }
                if(obj22.isLatitude_flag() && obj22.isLongitude_flag()) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(obj22.getLatitude(), obj22.getLongitude())).title("Bus 1"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(obj22.getLatitude(), obj22.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mChildRef31.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                String val = dataSnapshot.getValue().toString();
                if(key.equals("Latitude")){
                    Double lat = Double.parseDouble(val);

                    obj31.setLatitude(lat);
                } else if(key.equals("Longitude")){
                    Double lon = Double.parseDouble(val);
                    obj31.setLongitude(lon);
                }
                if(obj31.isLatitude_flag() && obj31.isLongitude_flag()) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(obj31.getLatitude(), obj31.getLongitude())).title("Bus 1"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(obj31.getLatitude(), obj31.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mChildRef32.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                String val = dataSnapshot.getValue().toString();
                if(key.equals("Latitude")){
                    Double lat = Double.parseDouble(val);

                    obj32.setLatitude(lat);
                } else if(key.equals("Longitude")){
                    Double lon = Double.parseDouble(val);
                    obj32.setLongitude(lon);
                }
                if(obj32.isLatitude_flag() && obj32.isLongitude_flag()) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(obj32.getLatitude(), obj32.getLongitude())).title("Bus 1"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(obj32.getLatitude(), obj32.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mChildRef33.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                String val = dataSnapshot.getValue().toString();
                if(key.equals("Latitude")){
                    Double lat = Double.parseDouble(val);

                    obj33.setLatitude(lat);
                } else if(key.equals("Longitude")){
                    Double lon = Double.parseDouble(val);
                    obj33.setLongitude(lon);
                }
                if(obj33.isLatitude_flag() && obj33.isLongitude_flag()) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(obj33.getLatitude(), obj33.getLongitude())).title("Bus 1"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(obj33.getLatitude(), obj33.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mChildRef34.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                String val = dataSnapshot.getValue().toString();
                if(key.equals("Latitude")){
                    Double lat = Double.parseDouble(val);

                    obj34.setLatitude(lat);
                } else if(key.equals("Longitude")){
                    Double lon = Double.parseDouble(val);
                    obj34.setLongitude(lon);
                }
                if(obj34.isLatitude_flag() && obj34.isLongitude_flag()) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(obj34.getLatitude(), obj34.getLongitude())).title("Bus 1"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(obj34.getLatitude(), obj34.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(8));
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Add a marker in Sydney and move the camera
        LatLng vellore = new LatLng(12.972, 79.159);
        //mMap.addMarker(new MarkerOptions().position(vellore).title("Marker"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(vellore));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));

    }
    @SuppressLint("MissingPermission")
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    public void onBusLocationChanged(Double lat, Double lng){
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title("Your place!"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng( lat,lng),12));
    }
}
