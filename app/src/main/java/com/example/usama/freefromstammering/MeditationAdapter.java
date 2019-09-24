package com.example.usama.freefromstammering;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MeditationAdapter extends RecyclerView.Adapter< MeditationAdapter.MyViewHolderMeditationItem>{
    List<CommunityItems> meditationItems;

    @NonNull
    @Override
    public MyViewHolderMeditationItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meditationitem, viewGroup, false);
        return new MyViewHolderMeditationItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderMeditationItem myViewHolderCommunityItem, int i) {
        CommunityItems ca = meditationItems.get(i);
        myViewHolderCommunityItem.nameMed.setText(ca.getName());
        myViewHolderCommunityItem.iconMed.setImageResource(R.drawable.article);
    }

    @Override
    public int getItemCount() {
        return meditationItems.size();
    }

    class MyViewHolderMeditationItem extends RecyclerView.ViewHolder{

        public TextView nameMed;
        public ImageView iconMed;

        public MyViewHolderMeditationItem(@NonNull View itemView) {
            super(itemView);
            nameMed = itemView.findViewById(R.id.meditextitem);
            iconMed = itemView.findViewById(R.id.mediiconitem);
        }
    }
    public MeditationAdapter(List<CommunityItems> meditationItems){
        this.meditationItems = meditationItems;
    }
}
