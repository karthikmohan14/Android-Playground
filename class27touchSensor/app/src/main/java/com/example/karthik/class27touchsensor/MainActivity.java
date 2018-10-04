package com.example.karthik.class27touchsensor;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity  implements View.OnTouchListener{

    private String TAG = "message";
    float initialX,initialY;
    ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl = findViewById(R.id.clayout);
        cl.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            initialX = motionEvent.getX();
            initialY = motionEvent.getY();
            Log.d(TAG,"initial X "+initialX+"initial Y "+initialY);
        }
        if(action == MotionEvent.ACTION_UP){
            float finalX = motionEvent.getX();
            float finalY = motionEvent.getY();
            Log.d(TAG,"final"+finalX+" "+finalY);
            if(initialX < finalX){
                Log.d(TAG,"left to right swipe performed");
            }
            if(initialX > finalX){
                Log.d(TAG,"right to left swipe performed");
            }
            if(initialY < finalY){
                Log.d(TAG,"up to down swipe performed");
            }
            if(initialY > finalY){
                Log.d(TAG,"down to up swipe performed");
            }


        }
        if(action == MotionEvent.ACTION_MOVE){
            Log.d(TAG,"action was move");
        }
        if(action == MotionEvent.ACTION_CANCEL){
            Log.d(TAG,"action was canceled");
        }
        if(action == MotionEvent.ACTION_OUTSIDE){
            Log.d(TAG,"action was outside");
        }
        return true;
    }
}
