package com.example.karthik.class17fragmentcommunicationbutton;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // implementing the method defined in the interface
    @Override
    public void respond(String i) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        SecondFragment f2= (SecondFragment)fm.
                findFragmentById(R.id.fragment2);
        f2.changedata(i);
    }

}
