package com.example.karthik.class22sqllite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    EditText eName,eRoll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eName = (EditText) findViewById(R.id.editName);
        eRoll = (EditText) findViewById(R.id.editRoll);
        db = openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);


    }

    public void addVal(View view) {
        db.execSQL("Create table if not exists student1( name varchar, rollno varchar)");
        db.execSQL("insert into student1 values ('"+eName.getText()+"','"+eRoll.getText()+"');");
    }

    public void displayVal(View view) {
        Cursor c =db.rawQuery("Select * from student1",null);
        StringBuffer message = new StringBuffer();
        while(c.moveToNext()){
            message.append("name : "+c.getString(0)+" roll no : "+c.getString(1)+" \n");
        }
        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show();
    }

    public void modVal(View view) {
    }

    public void remVal(View view) {
        Cursor c =db.rawQuery("Select * from student1 where name = '"+eName.getText()+"';",null);
        if(c.moveToFirst()){
            db.execSQL("delete from student1 where name = '"+eName.getText()+"';");
        }

    }
}
