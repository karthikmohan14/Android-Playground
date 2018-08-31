package com.example.karthik.class17fragmentcommunicationbutton;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment implements View.OnClickListener{
    int count=0; // int to maintain the no of button clicks
    Button bt; //object for button
    Communicator comm; //object for interface to pass the message to the activity
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Get access to the activity object to pass the message
        comm= (Communicator) getActivity();
        bt=(Button)getActivity().findViewById(R.id.btn);
        bt.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
// on button click increment the counter and pass the message to the activity using the //method defined in the interface
        count++;
        comm.respond("The button is clicked "+ count+" times");
    }
}
