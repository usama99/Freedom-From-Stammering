package calm.huts.usama.freefromstammering.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import calm.huts.usama.freefromstammering.Classes.VowelsItems;
import calm.huts.usama.freefromstammering.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpeechFlowAdapter extends RecyclerView.Adapter<SpeechFlowAdapter.MySpeechFlowViewHolder> {
    private List<VowelsItems> vowelsItems;

    @NonNull
    @Override
    public MySpeechFlowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View views = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flowlayout, viewGroup, false);
        return new MySpeechFlowViewHolder(views);
    }

    @Override
    public void onBindViewHolder(@NonNull MySpeechFlowViewHolder mySpeechFlowViewHolder, int i) {
        VowelsItems vowelsItem = vowelsItems.get(i);
        mySpeechFlowViewHolder.word.setImageResource(vowelsItem.getWordId());
        mySpeechFlowViewHolder.ti.setText(vowelsItem.getTitles());
        mySpeechFlowViewHolder.dsp.setText(vowelsItem.getDescriptions());
    }

    @Override
    public int getItemCount() {
        return vowelsItems.size();
    }

    class MySpeechFlowViewHolder extends RecyclerView.ViewHolder{

        CircleImageView word, speak;
        TextView ti, dsp;

        public MySpeechFlowViewHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.vc);
            ti = itemView.findViewById(R.id.tits);
            dsp = itemView.findViewById(R.id.des);
            speak = itemView.findViewById(R.id.speakout);
        }
    }

    public SpeechFlowAdapter(List<VowelsItems> vowelsItems){
        this.vowelsItems = vowelsItems;
    }
}
