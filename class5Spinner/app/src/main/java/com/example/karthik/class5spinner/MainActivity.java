package com.example.karthik.class5spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String days[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    Spinner sp ;
    @Override
    protected void onCreate(    Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp =findViewById(R.id.spinner);
        ArrayAdapter<String> spaa = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_dropdown_item,days
        );
        sp.setAdapter(spaa);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView temp = (TextView) view;
                Toast.makeText(getApplicationContext(),temp.getText().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}
