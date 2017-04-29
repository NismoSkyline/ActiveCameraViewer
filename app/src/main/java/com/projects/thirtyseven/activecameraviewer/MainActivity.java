package com.projects.thirtyseven.activecameraviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout cameraLinear1, cameraLinear2, cameraLinear3, cameraLinear4, cameraLinear5, cameraLinear6;
    Button viewerModButton;
    Camera camera;
    View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.cameraLinear1:
                        break;
                    case R.id.cameraLinear2:
                        break;
                    case R.id.cameraLinear3:
                        break;
                    case R.id.cameraLinear4:
                        break;
                    case R.id.cameraLinear5:
                        break;
                    case R.id.cameraLinear6:
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

    private void init() {
        cameraLinear1 = (FrameLayout) findViewById(R.id.cameraLinear1);
        cameraLinear2 = (FrameLayout) findViewById(R.id.cameraLinear2);
        cameraLinear3 = (FrameLayout) findViewById(R.id.cameraLinear3);
        cameraLinear4 = (FrameLayout) findViewById(R.id.cameraLinear4);
        cameraLinear5 = (FrameLayout) findViewById(R.id.cameraLinear5);
        cameraLinear6 = (FrameLayout) findViewById(R.id.cameraLinear6);
        viewerModButton = (Button) findViewById(R.id.viewerButton);
    }
}
