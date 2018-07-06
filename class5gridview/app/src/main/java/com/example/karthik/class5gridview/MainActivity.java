package com.example.karthik.class5gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gv;
    private ArrayAdapter<String> adapter;
    private String products[] = {"Apple", "Banana", "Pinapple", "Orange", "Papaya", "Melon",
                "Grapes", "Water Melon", "Lychee", "Guava", "Mango", "Kivi"};
    private String alphabets[] = {"a", "b", "c", "c", "d", "d",
            "e", "Water Melon", "Lychee", "Guava", "Mango", "Kivi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,products
        );
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),"mehhhhh",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

