package com.example.karthik.menu;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    EditText eName,eRoll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eName = (EditText) findViewById(R.id.editName);
        eRoll = (EditText) findViewById(R.id.editRoll);


    }

    public void addVal(View view) {
    }

    public void displayVal(View view) {
    }

    public void modVal(View view) {
    }
}
