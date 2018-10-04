package com.example.karthik.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AnnouncementAdapterItems>    listnewsData = new ArrayList<AnnouncementAdapterItems>();
    MyCustomAdapter myadapter;
    RecyclerView rv_an;
    ListView lv_an;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listnewsData.add(new AnnouncementAdapterItems("whoa"));
        listnewsData.add(new AnnouncementAdapterItems("wohoo"));



        lv_an = (ListView) findViewById(R.id.my_list_view);
//        rv_an = (RecyclerView) findViewById(R.id.my_recycler_view);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        rv_an.setLayoutManager(layoutManager);
//
        myadapter = new MyCustomAdapter(listnewsData);
////        rv_an.setAdapter(myadapter);
        lv_an.setAdapter(myadapter);
    }

    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AnnouncementAdapterItems> listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AnnouncementAdapterItems>  listnewsDataAdpater) {
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
            View myView = mInflater.inflate(R.layout.layout_announcement, null);

            final   AnnouncementAdapterItems s = listnewsDataAdpater.get(position);

            TextView txtJobTitle=( TextView)myView.findViewById(R.id.tv_an);
            txtJobTitle.setText(s.title);

            return myView;
        }

    }

}
