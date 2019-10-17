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

public class AdapterCommnunityItem extends RecyclerView.Adapter<AdapterCommnunityItem.MyViewHolderCommunityItem>{
    List<CommunityItems> communityItems;

    @NonNull
    @Override
    public MyViewHolderCommunityItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.communityitem, viewGroup, false);
        return new MyViewHolderCommunityItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCommunityItem myViewHolderCommunityItem, int i) {
        CommunityItems ca = communityItems.get(i);
        myViewHolderCommunityItem.name.setText(ca.getName());
        myViewHolderCommunityItem.iconName.setImageResource(R.drawable.group);
    }

    @Override
    public int getItemCount() {
        return communityItems.size();
    }

    class MyViewHolderCommunityItem extends RecyclerView.ViewHolder{

        public TextView name;
        public ImageView iconName;

        public MyViewHolderCommunityItem(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.communi);
            iconName = itemView.findViewById(R.id.communiicon);
        }
    }
    public AdapterCommnunityItem(List<CommunityItems> communityItems){
        this.communityItems = communityItems;
    }
}
