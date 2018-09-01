package com.example.karthik.class19sharedpreference;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void getval(View v)
    {
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        SharedPreferences sf=getSharedPreferences("myfile", Context.MODE_PRIVATE);
        String p=sf.getString("hello","NA");
        String q=sf.getString("pwd","NA");
        t1.setText(p);
        t2.setText(q);

    }
}
