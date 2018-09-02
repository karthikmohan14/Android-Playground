package com.example.karthik.listviewspecial;

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

    ArrayList<AdapterItems>    listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);

        //add data and view it
        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        myadapter=new MyCustomAdapter(listnewsData);
        ListView  lsNews=(ListView)findViewById(R.id.list);
        lsNews.setAdapter(myadapter);//intisal with data

//update  data in listview
        listnewsData.add(new AdapterItems(2,"tester"," test apps"));
        myadapter.notifyDataSetChanged();



    }
    private class MyCustomAdapter extends BaseAdapter {
        public  ArrayList<AdapterItems>  listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
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
            View myView = mInflater.inflate(R.layout.items, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            TextView txtID=( TextView)myView.findViewById(R.id.ID);
            txtID.setText(s.JobTitle);


            TextView txtJobTitle=( TextView)myView.findViewById(R.id.title);
            txtJobTitle.setText(s.JobTitle);


//            TextView txtdesc=( TextView)myView.findViewById(R.id.desc);
//            txtdesc.setText(s.Description);

            return myView;
        }

    }
}
