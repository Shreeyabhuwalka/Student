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
        for(int i = 0; i < 3; ++i)
        {
            String drivers = "Driver_"+(i+1);
            drivers_array[i] = drivers;
        }
       final String[] route_arr = new String[10];
        for(int i = 0; i <= 3; ++i)
        {
            String current_route = "Route_"+(i+1);
            route_arr[i] = current_route;
        }


        final DatabaseReference mChildRef1 = mRootRef.child(route_arr[0]).child(drivers_array[0]);
        final DatabaseReference mChildRef2 = mRootRef.child(route_arr[1]);
        final DatabaseReference mChildRef3 = mRootRef.child(route_arr[2]);
        Log.i("Ayushi", route_arr[0]);
        mChildRef1.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Log.i("Shreeay", "onCreate: abcd1234");
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Log.i("Shreeay", "onCreate: abcd");
                LocationClass obj = dataSnapshot.getValue(LocationClass.class);
                Log.i("Output",dataSnapshot.getKey());
                Log.i("output", obj.getLatitude().toString());
                String obj1 = dataSnapshot.getValue(String.class);
                Log.i("Output", obj1);
             //   DatabaseReference mDriverChild1 = mChildRef1.child(drivers_array[0]);
               // DatabaseReference mDriverChild2 = mChildRef1.child(drivers_array[1]);
                //DatabaseReference mDriverChild3 = mChildRef1.child(drivers_array[2]);
            /*mDriverChild1.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    LocationClass obj = dataSnapshot.getValue(LocationClass.class);
                    Log.i("Output",dataSnapshot.getKey());
                    Log.i("output", obj.getLatitude().toString());
                   String obj1 = dataSnapshot.getValue(String.class);
                   Log.i("Output", obj1);
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
            });*/
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
       /* mChildRef2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DatabaseReference mDriverChild1 = mChildRef1.child(drivers_array[0]);
                mDriverChild1.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        LocationClass obj = dataSnapshot.getValue(LocationClass.class);
                        Log.d("Output",dataSnapshot.getKey());
                        Log.d("output", (obj).getLatitude().toString());
                        String obj1 = dataSnapshot.getValue(String.class);
                        Log.d("Output", obj1);
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
                DatabaseReference mDriverChild2 = mChildRef1.child(drivers_array[1]);
                DatabaseReference mDriverChild3 = mChildRef1.child(drivers_array[2]);
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
        mChildRef3.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DatabaseReference mDriverChild1 = mChildRef1.child(drivers_array[0]);
                DatabaseReference mDriverChild2 = mChildRef1.child(drivers_array[1]);
                DatabaseReference mDriverChild3 = mChildRef1.child(drivers_array[2]);
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
        });*/

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Add a marker in Sydney and move the camera
        LatLng vellore = new LatLng(0, 0);
        mMap.addMarker(new MarkerOptions().position(vellore).title("Marker"));
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
