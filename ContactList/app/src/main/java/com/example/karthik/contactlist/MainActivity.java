package com.example.karthik.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AdapterItems> contactList = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);

        contactList.add(new AdapterItems(1234,"karthik"));
        myadapter=new MyCustomAdapter(contactList);
        list.setAdapter(myadapter);


//update  data in listview
//        listnewsData.add(new AdapterItems(2,"tester"," test apps"));
        myadapter.notifyDataSetChanged();




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
