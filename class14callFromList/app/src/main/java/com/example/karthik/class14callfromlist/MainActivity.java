package com.example.karthik.class14callfromlist;


import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    int phonenumber = 123;
    ListView lv;
    String contacts[]={"person 1 number : 123","person 2 number : 456","person 3 number : 567","person 4 number : 678","person 5 number : 789","person 6 number : 890","person 7 number : 901","person 8 number : 012"};
    char a [] = contacts[0].toCharArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.listv);
        ArrayAdapter<String> ada=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        lv.setAdapter(ada);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView txt = (TextView) view;
//        Toast.makeText(getApplicationContext(), "You have selected : " + txt.getText(), Toast.LENGTH_SHORT).show();
//        phonenumber = Integer.parseInt(txt.getText().toString());
        char b[] = txt.getText().toString().toCharArray();
        char num[] = new char[3];
        num[0] = b[18];
        num[1] = b[19];
        num[2] = b[20];
        phonenumber = Integer.parseInt(String.valueOf(num));
//        Toast.makeText(this, "-->"+number, Toast.LENGTH_SHORT).show();
        registerForContextMenu(txt);
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
            case R.id.call:
                Toast.makeText(this, "calling", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_CALL);

                intent.setData(Uri.parse("tel:" + phonenumber));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this,"Require Call permission to make calls",Toast.LENGTH_SHORT).show();
                    // add the following line for runtime permission request
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            123);
                }
                startActivity(intent);
                return true;
            case R.id.sms:
                String message = "hello";
                String no = Integer.toString(phonenumber);
                Intent SMSintent=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, SMSintent,0);
                Toast.makeText(this, "message sent", Toast.LENGTH_SHORT).show();
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(no, null, message, pi,null);
                Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                        Toast.LENGTH_LONG).show();
                return true;
        }return true;
    }
}
