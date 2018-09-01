package com.example.karthik.class18fragmentcommunicationlistview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {
    private TextView text;
    private Activity activity;

//    public void onAttach(Activity activity){
//        super.onAttach(activity);
//        this.activity = activity;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_text, container, false);
    }

//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        text = (TextView) activity.findViewById(R.id.textView);
//    }

    public void change(int data){

        text = getActivity().findViewById(R.id.textView);
        Resources res = getResources();
        String[] desc = res.getStringArray(R.array.versiom);
        text.setText(desc[data]);
    }

}
