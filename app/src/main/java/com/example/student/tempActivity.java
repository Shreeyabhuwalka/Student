package com.example.student;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.xmlpull.v1.sax2.Driver;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class tempActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference rootRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        FirebaseAuth.getInstance().signInWithEmailAndPassword("asdf@asdf.com","asdfqwer").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("zxcv", "Successfully logged in");
                    Log.d("zxcv", rootRef.child("Route_1").child("Driver_1").toString());
                    //DatabaseReference childRef = rootRef.child("Route_1");
                   /* childRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                                Log.d("key", childSnapshot.getKey().toString());
                                LocationClass obj = childSnapshot.getValue(LocationClass.class);
                                Log.d("zxcv", obj.getLatitude().toString());
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });*/


                }
            }
        });

    }
}
