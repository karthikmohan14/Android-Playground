package com.example.karthik.uivalidate;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1;
    String states[] = {"kerala","tamil nadu","andhra","delhi"};
    Spinner sp ;
    Button accept,clr;
    EditText editName,editEmail,editReg,editPh;
    CheckBox art,mus,dan;
    RadioButton m , f;
    TextView temp;
    ImageView proPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //element ids starts
        accept = (Button) findViewById(R.id.BTacc);
        clr = (Button) findViewById(R.id.BTclear);
        editName = (EditText) findViewById(R.id.ETname);
        editReg = (EditText) findViewById(R.id.ETreg);
        editEmail = (EditText) findViewById(R.id.ETemail);
        editPh = (EditText) findViewById(R.id.ETph);
        art = (CheckBox) findViewById(R.id.CBart);
        mus = (CheckBox) findViewById(R.id.CBmu);
        dan = (CheckBox) findViewById(R.id.CBda);
        m = (RadioButton) findViewById(R.id.RBmale);
        f = (RadioButton) findViewById(R.id.RBfem);
        proPic = (ImageView) findViewById(R.id.imageView);
        //element ids ends


        // spinner start
        sp =findViewById(R.id.spinner);
        ArrayAdapter<String> spaa = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_dropdown_item,states
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

    // save changes start
    public void acceptData(View view) {
        String a = editName.getText().toString();
        String b = editReg.getText().toString();
        String c = editPh.getText().toString();
        String d = editEmail.getText().toString();
        if(a.isEmpty()){
            Toast.makeText(getApplicationContext(),"you haven't entered name ",Toast.LENGTH_SHORT).show();
        }else if(b.isEmpty()){
            Toast.makeText(getApplicationContext(),"you haven't entered register no ",Toast.LENGTH_SHORT).show();
        }else if(c.isEmpty()){
            Toast.makeText(getApplicationContext(),"you haven't entered phone no ",Toast.LENGTH_SHORT).show();
        }else if(d.isEmpty()){
            Toast.makeText(getApplicationContext(),"you haven't entered email id ",Toast.LENGTH_SHORT).show();
        }else if(m.isChecked() || f.isChecked()) {
            String str="";
            if (m.isChecked()){
                str +="Male student";
            }
            if (f.isChecked()){
                str=" Female student";
            }
            str += "name : "+a+" register no : "+b+"Phone no : "+c+" email :"+d;
            if(art.isChecked()){
                str += " has art as hobby ";
            }
            if(mus.isChecked()){
                str += " has music as hobby ";
            }
            if(dan.isChecked()){
                str += " has dance as hobby ";
            }
            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "please mention gender", Toast.LENGTH_SHORT).show();
        }
    }
// save changes end

    public void onClear(View view) {
        editEmail.setText("");
        editPh.setText("");
        editReg.setText("");
        editName.setText("");
        art.setChecked(false);
        mus.setChecked(false);
        dan.setChecked(false);
        f.setChecked(false);
        m.setChecked(false);
    }


    public void selmale(View view) {
        f.setChecked(false);
    }


    public void selfemale(View view) {
        m.setChecked(false);
    }


    public void changePic(View view) {
//        startActivityForResult(
//                new Intent(
//                        Intent.ACTION_PICK,
//                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI
//                ),
//                0
//        );
        Intent galleryIntent = new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data!=null) {
            Uri selectedImage = data.getData();
            proPic.setImageURI(selectedImage);
        }
    }
}
