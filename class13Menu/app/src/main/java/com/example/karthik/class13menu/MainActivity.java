package com.example.karthik.class13menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
