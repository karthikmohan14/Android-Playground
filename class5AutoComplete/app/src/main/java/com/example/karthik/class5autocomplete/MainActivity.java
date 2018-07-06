package com.example.karthik.class5autocomplete;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    String[] language = {"dhanya","amrita","arjun","aishwarya","hamad"};
    AutoCompleteTextView atv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.select_dialog_item, language
        );
        AutoCompleteTextView atv = (AutoCompleteTextView) findViewById(R.id.atvlist);
        atv.setThreshold(1);
        atv.setAdapter(adapter);
        atv.setTextColor(Color.RED);
    }

}