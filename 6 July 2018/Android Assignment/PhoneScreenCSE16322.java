package ericjoseph.com.assignment6july;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PhoneScreenCSE16322 extends AppCompatActivity {

    AlertDialog.Builder info;
    TextView t1,t2;
    EditText textbox1,textbox2;
    Button more_info, discard, save;
    Spinner s;
    CheckBox ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_screen_cse16322);
        String song_names[] = new String[]{"Default","ABC","XYZ","PQR"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,song_names);
        s = (Spinner)findViewById(R.id.spinner);
        s.setAdapter(adapter);

        ch = (CheckBox)findViewById(R.id.checkBox);

        t1 = (TextView)findViewById(R.id.delete1);
        t2 = (TextView)findViewById(R.id.delete2);

        textbox1 = (EditText) findViewById(R.id.editText);
        textbox2 = (EditText) findViewById(R.id.editText2);

        discard = (Button)findViewById(R.id.discard);
        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        save = (Button)findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textbox1.length() == 0)
                    Toast.makeText(getApplicationContext(),"Enter Phone Number",Toast.LENGTH_SHORT).show();

                if(textbox2.length() == 0)
                    Toast.makeText(getApplicationContext(),"Enter eMail ID",Toast.LENGTH_SHORT).show();

                if(textbox1.length() > 0 && textbox2.length() > 0)
                {  String t = "";

                if(ch.isChecked())
                    t = "\nVoicemail activated";

                Toast.makeText(getApplicationContext(),"Mobile : "+ textbox1.getText().toString() + "\nHome : " + textbox2.getText().toString() +
                        "\nRingtone : " + s.getSelectedItem().toString() + t,Toast.LENGTH_SHORT).show();

                }
            }
        });



        info = new AlertDialog.Builder(this);

        more_info = (Button) findViewById(R.id.more_info);
        more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b;
                info.setTitle("Confirm Information");

                if(ch.isChecked())
                    b = "Enabled";
                else
                    b = "Not Enabled";

                info.setMessage("Mobile : "+ textbox1.getText().toString() + "\nHome : " + textbox2.getText().toString() + "\nRingtone : " + s.getSelectedItem().toString()
                        + "\nVoicemail : " + b);
                info.setIcon(R.drawable.ic_launcher_background);
                info.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Information Saved",Toast.LENGTH_SHORT).show();
                    }
                });

                info.setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textbox1.setText("");
                        textbox2.setText("");
                        ch.setChecked(false);
                        s.setSelection(0);
                        Toast.makeText(getApplicationContext(),"Entries Cleared",Toast.LENGTH_SHORT).show();
                    }
                });

                info.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                try {
                    info.show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Error in Alert Dialog",Toast.LENGTH_SHORT).show();
                }
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textbox1.setText("");
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textbox2.setText("");
            }
        });

    }
}
