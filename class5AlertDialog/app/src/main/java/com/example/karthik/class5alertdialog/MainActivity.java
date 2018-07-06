package com.example.karthik.class5alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = (Button) findViewById(R.id.button);
        setContentView(R.layout.activity_main);
    }

    public void delete(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        //setting dialog title
        alertDialog.setTitle("Confirm action !");
        //setting dialog message
        alertDialog.setMessage("Are you sure you want delete this ? ");
        //setting icon to dialog
//        alertDialog.setIcon(R.drawable.ic_launcher_background);
        alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"you clicked yes",Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setCancelable(false);
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"you clicked no",Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
        Toast.makeText(getApplicationContext(),"you clicked button",Toast.LENGTH_SHORT).show();
    }

}
