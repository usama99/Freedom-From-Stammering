package calm.huts.usama.freefromstammering.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import calm.huts.usama.freefromstammering.MainMenue.Connection.Fab.FacebookGroups;
import calm.huts.usama.freefromstammering.R;

import java.util.List;

public class FacebookGroupAdapter extends RecyclerView.Adapter<FacebookGroupAdapter.MyViewHolderFacebookGroups> {
    List<FacebookGroups> facebookGroups;

    @NonNull
    @Override
    public MyViewHolderFacebookGroups onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewFbGroup = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fbgroups, viewGroup, false);
        return new MyViewHolderFacebookGroups(viewFbGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderFacebookGroups myViewHolderFacebookGroups, int i) {
        FacebookGroups groupFb = facebookGroups.get(i);
        myViewHolderFacebookGroups.nameOfGroup.setText(groupFb.getFbGroupName());
        myViewHolderFacebookGroups.nameOfGroupIcon.setImageResource(R.drawable.face);
    }

    @Override
    public int getItemCount() {
        return facebookGroups.size();
    }

    class MyViewHolderFacebookGroups extends RecyclerView.ViewHolder{

        public TextView nameOfGroup;
        public ImageView nameOfGroupIcon;

        public MyViewHolderFacebookGroups(@NonNull View itemView) {
            super(itemView);
            nameOfGroup = itemView.findViewById(R.id.fbgroup);
            nameOfGroupIcon = itemView.findViewById(R.id.fbgroupicon);
        }
    }

    public FacebookGroupAdapter(List<FacebookGroups> facebookGroups ){
        this.facebookGroups = facebookGroups;
    }
}
