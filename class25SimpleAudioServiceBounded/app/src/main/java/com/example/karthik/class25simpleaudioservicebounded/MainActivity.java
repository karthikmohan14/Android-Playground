package com.example.karthik.class25simpleaudioservicebounded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    Button bstart,bstop,bfwd,brwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        bstart = (Button) findViewById(R.id.bstart);
//        bstop = (Button) findViewById(R.id.bstop);
//        bfwd = (Button) findViewById(R.id.bfwd);
//        brwd = (Button) findViewById(R.id.brwd);
//
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bstart:
                break;
            case R.id.bstop:
                break;
            case R.id.bfwd:

                break;
            case R.id.brwd:
                break;

        }
    }

    private serviceConnection = new serv
}
