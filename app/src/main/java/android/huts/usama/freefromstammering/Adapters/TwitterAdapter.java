package android.huts.usama.freefromstammering.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.huts.usama.freefromstammering.MainMenue.Connection.Fab.FacebookGroups;
import android.huts.usama.freefromstammering.R;

import java.util.List;

public class TwitterAdapter extends RecyclerView.Adapter<TwitterAdapter.MyViewHolerTwitterAdapter> {

    List<FacebookGroups> twitterGroups;

    @NonNull
    @Override
    public MyViewHolerTwitterAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewTGroup = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tgroup, viewGroup, false);
        return new TwitterAdapter.MyViewHolerTwitterAdapter(viewTGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolerTwitterAdapter myViewHolerTwitterAdapter, int i) {
        FacebookGroups groupT = twitterGroups.get(i);
        myViewHolerTwitterAdapter.nameOfGrouptw.setText(groupT.getFbGroupName());
        myViewHolerTwitterAdapter.nameOfGroupIcontw.setImageResource(R.drawable.tweeter);
    }

    @Override
    public int getItemCount() {
        return twitterGroups.size();
    }

    class MyViewHolerTwitterAdapter extends RecyclerView.ViewHolder{

        public TextView nameOfGrouptw;
        public ImageView nameOfGroupIcontw;

        public MyViewHolerTwitterAdapter(@NonNull View itemView) {
            super(itemView);
            nameOfGrouptw = itemView.findViewById(R.id.tgroup);
            nameOfGroupIcontw = itemView.findViewById(R.id.tgroupicon);
        }
    }

    public TwitterAdapter(List<FacebookGroups> twitterGroups){
        this.twitterGroups = twitterGroups;
    }

}
