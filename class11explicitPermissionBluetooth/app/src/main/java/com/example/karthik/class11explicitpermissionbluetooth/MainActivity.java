package com.example.karthik.class11explicitpermissionbluetooth;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public BluetoothAdapter mba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mba = BluetoothAdapter.getDefaultAdapter();
    }

    public void turnOffOnClick(View view) {

    }

    public void discoOnClick(View view) {
    }

    public void turnOnClick(View view) {
        Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(turnOn, 0);
    }
}
