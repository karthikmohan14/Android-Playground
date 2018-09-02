package com.example.karthik.uicallmessfromcontact;

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
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<AdapterItems> contactList = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;

    int phonenumber = 123;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.listv);
        contactList.add(new AdapterItems(1234,"karthik"));
        contactList.add(new AdapterItems(3432,"mohan"));
        contactList.add(new AdapterItems(5634,"harshil"));
        contactList.add(new AdapterItems(5854,"pavithran"));
        contactList.add(new AdapterItems(3421,"gautham"));
        contactList.add(new AdapterItems(2354,"karthick"));
        contactList.add(new AdapterItems(5685,"eric"));
        contactList.add(new AdapterItems(2351,"saksham"));
        contactList.add(new AdapterItems(5754,"sneha"));
        contactList.add(new AdapterItems(2452,"Vatsav"));
        contactList.add(new AdapterItems(1214,"Ram"));
        contactList.add(new AdapterItems(5623,"cratos"));

        myadapter=new MyCustomAdapter(contactList);
        lv.setAdapter(myadapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final AdapterItems s = contactList.get(position);
        phonenumber = s.number;
        registerForContextMenu(view);
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
    private class MyCustomAdapter extends BaseAdapter {
        public  ArrayList<AdapterItems>  contactListAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems>  contactListAdpater) {
            this.contactListAdpater=contactListAdpater;
        }


        @Override
        public int getCount() {
            return contactListAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.contact, null);

            final   AdapterItems citems = contactListAdpater.get(position);

            TextView txtnum =(TextView)myView.findViewById(R.id.TVnumber);
            txtnum.setText(""+citems.number);

            TextView txtname =(TextView)myView.findViewById(R.id.TVname);
            txtname.setText(""+citems.name);
            return myView;
        }

    }
}
