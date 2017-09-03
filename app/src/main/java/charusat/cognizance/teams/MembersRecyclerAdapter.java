package charusat.cognizance.teams;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import charusat.cognizance.R;

/**
 * Created by Umang on 30/8/17.
 *
 */

class MembersRecyclerAdapter extends RecyclerView.Adapter<MembersRecyclerAdapter.MembersHolder> {

    private ArrayList<MembersInfo> membersInfoArrayList;

    MembersRecyclerAdapter(ArrayList<MembersInfo> membersInfoArrayList) {
        this.membersInfoArrayList = membersInfoArrayList;
    }

    @Override
    public MembersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member_item_row, parent, false);
        return new MembersHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(MembersHolder holder, int position) {
        MembersInfo currentMember = membersInfoArrayList.get(position);
        holder.memberLabel.setText(currentMember.getMemberLabelResourceId());
        holder.memberImage.setImageResource(currentMember.getMemberImageResourceId());
    }

    @Override
    public int getItemCount() {
        return membersInfoArrayList.size();
    }

    static class MembersHolder extends RecyclerView.ViewHolder {

        ImageView memberImage;
        TextView memberLabel;

        MembersHolder(View itemView) {
            super(itemView);
            memberImage = (ImageView) itemView.findViewById(R.id.member_image);
            memberLabel = (TextView) itemView.findViewById(R.id.member_label);
        }
    }
}