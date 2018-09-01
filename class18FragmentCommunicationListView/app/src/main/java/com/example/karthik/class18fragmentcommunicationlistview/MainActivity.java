package com.example.karthik.class18fragmentcommunicationlistview;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void respond(int data) {
        FragmentManager manager = getFragmentManager();
        TextFragment frag = (TextFragment)manager.
                findFragmentById(R.id.textfragment);
        frag.change(data);
    }
}
