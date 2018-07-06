package com.example.karthik.class3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;

import android.text.TextWatcher;

import android.view.View;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.CheckBox;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    EditText ed;
    CheckBox c1,c2;
    Button button;
    RadioButton subRadioButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make editText use TextWatcher interface to watch change made over EditText.
        // For doing this, EditText calls the addTextChangedListener() method.
        ed = (EditText) findViewById(R.id.editText);
        ed.addTextChangedListener(this);


        // checkbox uses setOnClickListener for notifying selection
        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);


    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(getApplicationContext(), "before Textchanged : " + s.toString() /*+ " start:" + start + " count:  " + count + " after: " + after*/, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(getApplicationContext(), "on Text changed :" + s.toString()/* + " start:" + start + " count:  " + count + " before: " + before*/, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(getApplicationContext(), "After TextChanged : " + s.toString(), Toast.LENGTH_SHORT).show();
        try {
            int no = Integer.parseInt(s.toString());
            if (no > 5) {
                s.replace(0, s.length(), "1");
            }
        } catch (NumberFormatException e) {
        }
    }



    @Override
    public void onClick(View v) {
        CheckBox t = (CheckBox) v;

        if (t.isChecked()) {
            Toast.makeText(getApplicationContext(), t.getText()+" is selected", Toast.LENGTH_SHORT).show();
            if(t.getId()==c1.getId()){
                c2.setChecked(false);
            }
            else
                c1.setChecked(false);
        }
    }

    public void onclickbuttonMethod(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        subRadioButton = (RadioButton) findViewById(selectedId);
        if(selectedId == -1){
            Toast.makeText(MainActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this,subRadioButton.getText()+" is selected", Toast.LENGTH_SHORT).show();
        }
    }
}
