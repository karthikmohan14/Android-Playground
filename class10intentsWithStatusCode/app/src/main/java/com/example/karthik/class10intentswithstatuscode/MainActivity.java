package com.example.karthik.class10intentswithstatuscode;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText un,pwd;
    Integer Result_OK = 111;
    TextView msg;
    final int MYREQUEST = 111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        un = (EditText) findViewById(R.id.name);
        pwd = (EditText) findViewById(R.id.pwd);
        msg = (TextView) findViewById(R.id.er);
    }

    public void checkCred(View view) {
        if(un.getText().toString().trim().equals("admin") && pwd.getText().toString().trim().equals("password")){
            Intent i = new Intent( this,success.class);
            i.putExtra("name",un.getText().toString().trim());
            i.putExtra("pwd",pwd.getText().toString().trim());
            i.putExtra("msg","hello!!!");
            startActivityForResult(i,MYREQUEST);
            startActivity(i);
        }else{
            msg.setTextColor(Color.RED);
            msg.setText("Error");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == MYREQUEST){
            if(resultCode == RESULT_OK){
                String str = data.getStringExtra("msg");
                t1.setText("response : ")
            }
        }
    }
}
