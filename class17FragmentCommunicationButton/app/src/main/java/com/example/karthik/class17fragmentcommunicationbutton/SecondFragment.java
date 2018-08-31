package com.example.karthik.class17fragmentcommunicationbutton;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {
    TextView txt; // object to hold the text view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
  /*  This method we discussed in class. But having the logic to get the activity inside changedata method also works.
  @Override
   public void onActivityCreated( Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);
	// get access to the textview object
       txt=(TextView)getActivity().findViewById(R.id.tv);
   }*/

    // method to accept the message from the activity and update the UI
    public void changedata(String i)
    {

// get access to the textview object
        txt=(TextView)getActivity().findViewById(R.id.tv);
        txt.setText(i);
    }

}
