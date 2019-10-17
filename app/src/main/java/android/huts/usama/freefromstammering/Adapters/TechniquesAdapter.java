package android.huts.usama.freefromstammering.Adapters;

import android.huts.usama.freefromstammering.Classes.CommunityItems;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.huts.usama.freefromstammering.R;

import java.util.List;

public class TechniquesAdapter extends RecyclerView.Adapter<TechniquesAdapter.MyViewHolderTechItem> {
    List<CommunityItems> techItems;

    @NonNull
    @Override
    public MyViewHolderTechItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View views = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.techniques, viewGroup, false);
        return new MyViewHolderTechItem(views);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderTechItem myViewHolderCommunityItem, int i) {
        CommunityItems ca = techItems.get(i);
        myViewHolderCommunityItem.nametech.setText(ca.getName());
        myViewHolderCommunityItem.iconNametech.setImageResource(R.drawable.logo);
    }

    @Override
    public int getItemCount() {
        return techItems.size();
    }

    class MyViewHolderTechItem extends RecyclerView.ViewHolder {

        public TextView nametech;
        public ImageView iconNametech;

        public MyViewHolderTechItem(@NonNull View itemView) {
            super(itemView);
            nametech = itemView.findViewById(R.id.techtext);
            iconNametech = itemView.findViewById(R.id.techicon);
        }
    }

    public TechniquesAdapter(List<CommunityItems> techItems) {
        this.techItems = techItems;
    }
}