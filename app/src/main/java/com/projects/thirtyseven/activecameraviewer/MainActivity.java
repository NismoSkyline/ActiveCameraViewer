package com.projects.thirtyseven.activecameraviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FrameLayout cameraLinear1, cameraLinear2, cameraLinear3, cameraLinear4, cameraLinear5, cameraLinear6;
    Camera camera;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    View.OnClickListener onClickListener;

    int number, status = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                childEvent(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                childEvent(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.cameraLinear1:
                        databaseReference = database.getReference("Camera").child("camera1");
                        number = 1;
                        camera.setNumber(number);
                        cameraStatusChange();
                        camera.setStatus(status);
                        databaseReference.setValue(camera);

                        break;
                    case R.id.cameraLinear2:
                        databaseReference = database.getReference("Camera").child("camera2");
                        number = 2;
                        camera.setNumber(number);
                        cameraStatusChange();
                        camera.setStatus(status);
                        databaseReference.setValue(camera);
                        break;
                    case R.id.cameraLinear3:
                        databaseReference = database.getReference("Camera").child("camera3");
                        number = 3;
                        camera.setNumber(number);
                        cameraStatusChange();
                        camera.setStatus(status);
                        databaseReference.setValue(camera);
                        break;
                    case R.id.cameraLinear4:
                        databaseReference = database.getReference("Camera").child("camera4");
                        number = 4;
                        camera.setNumber(number);
                        cameraStatusChange();
                        camera.setStatus(status);
                        databaseReference.setValue(camera);
                        break;
                    case R.id.cameraLinear5:
                        databaseReference = database.getReference("Camera").child("camera5");
                        number = 5;
                        camera.setNumber(number);
                        cameraStatusChange();
                        camera.setStatus(status);
                        databaseReference.setValue(camera);
                        break;
                    case R.id.cameraLinear6:
                        databaseReference = database.getReference("Camera").child("camera6");
                        number = 6;
                        camera.setNumber(number);
                        cameraStatusChange();
                        camera.setStatus(status);
                        databaseReference.setValue(camera);
                        break;
                }
            }
        };

        cameraLinear1.setOnClickListener(onClickListener);
        cameraLinear2.setOnClickListener(onClickListener);
        cameraLinear3.setOnClickListener(onClickListener);
        cameraLinear4.setOnClickListener(onClickListener);
        cameraLinear5.setOnClickListener(onClickListener);
        cameraLinear6.setOnClickListener(onClickListener);
    }

    private void childEvent(DataSnapshot dataSnapshot) {
        camera = dataSnapshot.getValue(Camera.class);
        switch (camera.getNumber()) {
            case 1:
                cameraImageChange(imageView1);
                break;
            case 2:
                cameraImageChange(imageView2);
                break;
            case 3:
                cameraImageChange(imageView3);
                break;
            case 4:
                cameraImageChange(imageView4);
                break;
            case 5:
                cameraImageChange(imageView5);
                break;
            case 6:
                cameraImageChange(imageView6);
                break;
        }
    }

    private void cameraStatusChange() {
        if (camera.getStatus() == 1) {
            status = 2;
        } else if (camera.getStatus() == 2) {
            status = 3;
        } else if (camera.getStatus() == 3) {
            status = 1;
        }
    }

    private void cameraImageChange(ImageView v) {
        if (camera.getStatus() == 1) {
            v.setImageResource(R.drawable.grey_status);
        } else if (camera.getStatus() == 2) {
            v.setImageResource(R.drawable.yellow_status);
        } else if (camera.getStatus() == 3) {
            v.setImageResource(R.drawable.red_status);
        }
    }

    private void init() {
        cameraLinear1 = (FrameLayout) findViewById(R.id.cameraLinear1);
        cameraLinear2 = (FrameLayout) findViewById(R.id.cameraLinear2);
        cameraLinear3 = (FrameLayout) findViewById(R.id.cameraLinear3);
        cameraLinear4 = (FrameLayout) findViewById(R.id.cameraLinear4);
        cameraLinear5 = (FrameLayout) findViewById(R.id.cameraLinear5);
        cameraLinear6 = (FrameLayout) findViewById(R.id.cameraLinear6);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Camera");
        camera = new Camera();
        imageView1 = (ImageView) findViewById(R.id.imageStatus1);
        imageView2 = (ImageView) findViewById(R.id.imageStatus2);
        imageView3 = (ImageView) findViewById(R.id.imageStatus3);
        imageView4 = (ImageView) findViewById(R.id.imageStatus4);
        imageView5 = (ImageView) findViewById(R.id.imageStatus5);
        imageView6 = (ImageView) findViewById(R.id.imageStatus6);
    }
}
