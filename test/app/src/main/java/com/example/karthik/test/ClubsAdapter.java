package com.example.karthik.test;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClubsAdapter extends RecyclerView.Adapter<ClubsAdapter.MyViewHolder> {

    private List<Club> clubsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title, desc;

        public MyViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.imageView);
            title = (TextView) view.findViewById(R.id.title);
            desc = (TextView) view.findViewById(R.id.desc);
        }
    }


    public ClubsAdapter(List<Club> clubsList) {
        this.clubsList = clubsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.club_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Club club = clubsList.get(position);
        holder.title.setText(club.getTitle());
        holder.desc.setText(club.getDesc());
        holder.image.setImageResource(club.getImage());
    }

    @Override
    public int getItemCount() {
        return clubsList.size();
    }
}
