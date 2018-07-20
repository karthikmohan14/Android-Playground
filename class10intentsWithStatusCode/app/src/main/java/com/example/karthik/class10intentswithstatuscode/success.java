package com.example.karthik.class10intentswithstatuscode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class success extends AppCompatActivity {


    TextView msg,t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        t1 = (EditText) findViewById(R.id.msg);
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        Toast.makeText(this, "something happened", Toast.LENGTH_SHORT).show();
    }
    public void passmsg(View v){
        String str = t1.getText().toString();
        Intent i = new Intent();
        i.putExtra("msg",str);
        setResult(RESULT_OK,i);
        finish();

    }

}
