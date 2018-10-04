package com.example.karthik.test;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Club> clubList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ClubsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_announcements);
        mAdapter = new ClubsAdapter(clubList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        clubList.add(new Club(R.drawable.one,"Srishti","literature club"));
        clubList.add(new Club(R.drawable.two,"whoa","literature club"));
        clubList.add(new Club(R.drawable.three,"Srishti","literature club"));
        clubList.add(new Club(R.drawable.four,"whoa","literature club"));
        mAdapter.notifyDataSetChanged();
    }
}