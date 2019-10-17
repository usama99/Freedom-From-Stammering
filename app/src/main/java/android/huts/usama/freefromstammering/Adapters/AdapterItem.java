package android.huts.usama.freefromstammering.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.huts.usama.freefromstammering.Classes.Items;
import android.huts.usama.freefromstammering.R;

import java.util.List;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.MyViewHolderItems> {

    private List<Items> itemsList;

    @NonNull
    @Override
    public MyViewHolderItems onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.article_items, viewGroup, false);
        return new MyViewHolderItems(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderItems myViewHolderItems, int i) {
        Items item = itemsList.get(i);
        myViewHolderItems.sources.setText(item.getSource());
        myViewHolderItems.titles.setText(item.getTitle());
        myViewHolderItems.timer.setText(item.getTimer());
//        myViewHolderItems.descriptions.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class MyViewHolderItems extends RecyclerView.ViewHolder{

        public TextView sources, titles, timer, descriptions;

        public MyViewHolderItems(@NonNull View itemView) {
            super(itemView);

            sources = itemView.findViewById(R.id.source);
            titles = itemView.findViewById(R.id.titleMain);
            timer = itemView.findViewById(R.id.time);
            descriptions = itemView.findViewById(R.id.description);
        }
    }

    public AdapterItem(List<Items> itemsList){
        this.itemsList = itemsList;
    }

}
