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
 * Created by iharsh on 21/8/17.
 */

public class TeamRecyclerAdapter extends RecyclerView.Adapter<TeamRecyclerAdapter.AppTeamHolder> {

    private ArrayList<MemberInfo> mTeamMembersList;

    static class AppTeamHolder extends RecyclerView.ViewHolder {

        TextView mMemberLabelTextView;
        ImageView mMemberImageView;

        AppTeamHolder(View itemView) {
            super(itemView);
            mMemberImageView = (ImageView) itemView.findViewById(R.id.member_image);
            mMemberLabelTextView = (TextView) itemView.findViewById(R.id.member_label);
        }
    }

    public TeamRecyclerAdapter(ArrayList<MemberInfo> mAppTeamMembersList) {
        this.mTeamMembersList = mAppTeamMembersList;
    }

    @Override
    public TeamRecyclerAdapter.AppTeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflateView = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_item_row, parent, false);
        return new AppTeamHolder(inflateView);
    }

    @Override
    public void onBindViewHolder(TeamRecyclerAdapter.AppTeamHolder holder, int position) {
        MemberInfo currentMemberInfo = mTeamMembersList.get(position);
        holder.mMemberImageView.setImageResource(currentMemberInfo.getmMemberImageResourceId());
        holder.mMemberLabelTextView.setText(currentMemberInfo.getmMemberLabelResourceId());

    }

    @Override
    public int getItemCount() {
        return mTeamMembersList.size();
    }


}
