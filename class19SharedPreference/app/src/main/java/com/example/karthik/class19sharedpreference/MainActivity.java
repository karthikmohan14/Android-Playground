package com.example.karthik.class19sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(View v)
    {
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        SharedPreferences sf=getSharedPreferences("myfile", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sf.edit();
        edit.putString("hello",t1.getText().toString());
        edit.putString("hai",t2.getText().toString());
        edit.commit();
        Intent i=new Intent(this,SecondActivity.class);
        startActivity(i);

    }
}
