package com.example.usama.freefromstammering;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterReading extends RecyclerView.Adapter<AdapterReading.MyViewHolderItemsReading>{

    List<ItemReading> itemReadingsList;

    @NonNull
    @Override
    public MyViewHolderItemsReading onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemreading, viewGroup, false);
        return new MyViewHolderItemsReading(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderItemsReading myViewHolderItemsReading, int i) {
        ItemReading itemsRead = itemReadingsList.get(i);
        myViewHolderItemsReading.stories.setText(itemsRead.getStory());
        myViewHolderItemsReading.times.setText(itemsRead.getTime());
    }

    @Override
    public int getItemCount() {
        return itemReadingsList.size();
    }

    class MyViewHolderItemsReading extends RecyclerView.ViewHolder{

        public TextView stories, times, readings;

        public MyViewHolderItemsReading(@NonNull View itemView) {
            super(itemView);

            stories = itemView.findViewById(R.id.storyTeller);
            times = itemView.findViewById(R.id.timeTo);
            readings = itemView.findViewById(R.id.read);
        }
    }

    public AdapterReading(List<ItemReading> itemReadingsList){
        this.itemReadingsList = itemReadingsList;
    }

}
