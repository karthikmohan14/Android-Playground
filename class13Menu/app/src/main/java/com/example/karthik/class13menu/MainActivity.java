package com.example.karthik.class13menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // attaching
        tv = (TextView) findViewById(R.id.textView);
        registerForContextMenu(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.help:
                Toast.makeText(this, "i wont give up", Toast.LENGTH_SHORT).show();
            case R.id.help2:
                Toast.makeText(this, "i wont give up again", Toast.LENGTH_SHORT).show();
            case R.id.help3:
                Toast.makeText(this, "let me see", Toast.LENGTH_SHORT).show();
        }return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.help:
                Toast.makeText(this, "i wont give up", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help2:
                Toast.makeText(this, "i wont give up again", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help3:
                Toast.makeText(this, "let me see", Toast.LENGTH_SHORT).show();
                return true;
        }return true;
    }
}
