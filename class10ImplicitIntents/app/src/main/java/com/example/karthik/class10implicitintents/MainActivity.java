package com.example.karthik.class10implicitintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browseButton = (Button) findViewById(R.id.webButton);
        e = (EditText) findViewById(R.id.e1);

    }


}
