package com.example.karthik.adithlab;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
//import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imgButton1,imgButton2;
    Spinner s1;
  String songs[]={"Ringtone","Aquila","Andromeda","Atria","Backroad","Bell Phone","Boots","cairo","Centaurus","Chimey Phone","Dione","Digital Phone","Eridani","Flutey Phone","Free Flight","Growl","Hydra","Insert coin","Luna","Mildly Alarming","Orion","Rockin","World"};

    EditText et1=(EditText)findViewById(R.id.edit_text1) ;
    EditText et2=(EditText)findViewById(R.id.edit_text2) ;

    CheckBox c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        imgButton1 =(ImageButton)findViewById(R.id.imageButton4);
//        imgButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                et1.setText("");
//                Toast.makeText(getApplicationContext(),"Removed number",Toast.LENGTH_LONG).show();
//            }
//        });
//
//        imgButton2 =(ImageButton)findViewById(R.id.imageButton5);
//        imgButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                et2.setText("");
//                Toast.makeText(getApplicationContext(),"Removed email",Toast.LENGTH_LONG).show();
//            }
//        });
//
//        s1=(Spinner)findViewById(R.id.spinner);
//        ArrayAdapter<String>adapter1= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,songs);
//        s1.setAdapter(adapter1);
//        s1.setOnItemSelectedListener(new SongOnItemSelectedListener());
//    }



    public class SongOnItemSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(parent.getContext(),"SongOnItemSelectedListener:"+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    public void Clickinfo(View v){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        // Setting Dialog Title
        alertDialog.setTitle("Confirm Delete...");
        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want delete this?");
        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_launcher_background);
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked on YES :   "+which, Toast.LENGTH_SHORT).show();
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                et1.setText("");
                et2.setText("");
                Toast.makeText(getApplicationContext(), "You clicked on NO :   "+which, Toast.LENGTH_SHORT).show();

                // dialog.cancel();
            }
        });
        // Setting Netural "Cancel" Button
        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User pressed Cancel button. Write Logic Here
                Toast.makeText(getApplicationContext(), "You clicked on Cancel :   "+which,
                        Toast.LENGTH_SHORT).show();
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

}

