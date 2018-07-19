package com.example.karthik.labassignment1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String ringtone[] = {"nokia","breeze","wake","buhaha"};
    Spinner sp ;
    Button b,d1,d2;
    EditText pn,ei;
    CheckBox ch;
    TextView temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //element ids starts
        b = (Button) findViewById(R.id.MoreInfo);
        setContentView(R.layout.activity_main);
        pn = (EditText) findViewById(R.id.PhoneNumber);
        ei = (EditText) findViewById(R.id.EmalAddress);
        d1 = (Button) findViewById(R.id.del1);
        d2 = (Button) findViewById(R.id.del2);
        ch = (CheckBox) findViewById(R.id.VoiceCheckBox);
        //element ids ends

        // spinner start
        sp =findViewById(R.id.Ringspinner);
        ArrayAdapter<String> spaa = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_dropdown_item,ringtone
        );
        sp.setAdapter(spaa);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                temp = (TextView) view;
                Toast.makeText(getApplicationContext(),temp.getText().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // spinner end
    }

    // alert dialog start
    public void reqMoreInfo(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        //setting dialog title
        alertDialog.setTitle("Confirm action !");
        //setting dialog message
        alertDialog.setMessage("Are you sure ? ");
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
                pn.setText("");
                ei.setText("");
                Toast.makeText(getApplicationContext(),"you clicked no",Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
        Toast.makeText(getApplicationContext(),"you clicked button",Toast.LENGTH_SHORT).show();
    }
    // alert dialog end

    // Discard changes start
    public void closeApp(View view) {
        finish();
        System.exit(0);
    }
    // Discard changes end

    // save changes start
    public void saveData(View view) {
        String a = pn.getText().toString();
        String b = ei.getText().toString();
        if(a.isEmpty()){
            Toast.makeText(getApplicationContext(),"you haven't entered phone no ",Toast.LENGTH_SHORT).show();
        }else if(b.isEmpty()){
            Toast.makeText(getApplicationContext(),"you haven't entered email id ",Toast.LENGTH_SHORT).show();
        }else if(ch.isChecked()){
            Toast.makeText(getApplicationContext(),"Phone no : "+pn.getText().toString()+" email :"+ei.getText().toString()+" with voice mail : "+temp.getText().toString(),Toast.LENGTH_SHORT).show();
        }
        else
        Toast.makeText(getApplicationContext(),"Phone no : "+pn.getText().toString()+" email :"+ei.getText().toString(),Toast.LENGTH_SHORT).show();

    }

    // save changes end

    // delete phone no entry start
    public void dellpn(View view) {
        pn.setText("");
    }
    // delete phone no entry end

    // delete email entry start
    public void dellem(View view) {
        ei.setText("");
    }
    // delete email entry end
    //
    public void voiceCheck(View view) {

    }
    //
}
