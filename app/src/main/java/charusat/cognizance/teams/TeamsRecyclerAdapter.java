package charusat.cognizance.teams;

import android.support.v7.widget.GridLayoutManager;
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

public class TeamsRecyclerAdapter extends RecyclerView.Adapter<TeamsRecyclerAdapter.TeamsHolder> {

    private ArrayList<TeamInfo> teamsArrayList;
    private GridLayoutManager gridLayoutManager;


    public TeamsRecyclerAdapter(ArrayList<TeamInfo> teamsArrayList) {
        this.teamsArrayList = teamsArrayList;
    }

    @Override
    public TeamsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflateView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_card_view, parent, false);
        return new TeamsHolder(inflateView);
    }

    @Override
    public void onBindViewHolder(final TeamsHolder holder, int position) {
        final TeamInfo currentTeam = teamsArrayList.get(position);
        holder.teamLabelTextView.setText(currentTeam.getTeamLabel());
        holder.teamDownArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!currentTeam.isTeamDetailVisible()) {
                    holder.teamDownArrowImageView.animate().rotationBy(180).setDuration(90).start();
                    gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
                    MembersRecyclerAdapter membersRecyclerAdapter;
                    switch (currentTeam.getTeamLabel()) {
                        case "Council Members":
                            membersRecyclerAdapter = new MembersRecyclerAdapter(new MembersInfo(1).getmCouncilTeamMembersList());
                            holder.teamMemberRecyclerView.setLayoutManager(gridLayoutManager);
                            holder.teamMemberRecyclerView.setAdapter(membersRecyclerAdapter);
                            break;
                        case "App Team":
                            centerMember();
                            membersRecyclerAdapter = new MembersRecyclerAdapter(new MembersInfo(2).getmAppTeamMembersList());
                            holder.teamMemberRecyclerView.setLayoutManager(gridLayoutManager);
                            holder.teamMemberRecyclerView.setAdapter(membersRecyclerAdapter);
                            break;
                        case "Web Team":
                            centerMember();
                            membersRecyclerAdapter = new MembersRecyclerAdapter(new MembersInfo(3).getmWebTeamMembersList());
                            holder.teamMemberRecyclerView.setLayoutManager(gridLayoutManager);
                            holder.teamMemberRecyclerView.setAdapter(membersRecyclerAdapter);
                            break;
                        case "Adhyay Team":
                            centerMember();
                            membersRecyclerAdapter = new MembersRecyclerAdapter(new MembersInfo(4).getmAdhyayTeamMembersList());
                            holder.teamMemberRecyclerView.setLayoutManager(gridLayoutManager);
                            holder.teamMemberRecyclerView.setAdapter(membersRecyclerAdapter);
                            break;
                        case "Campaigning Zones Leaders":
                            membersRecyclerAdapter = new MembersRecyclerAdapter(new MembersInfo(5).getmCampZoneTeamMembersList());
                            holder.teamMemberRecyclerView.setLayoutManager(gridLayoutManager);
                            holder.teamMemberRecyclerView.setAdapter(membersRecyclerAdapter);
                            break;
                    }
                    holder.teamMemberRecyclerView.setVisibility(View.VISIBLE);
                    currentTeam.setTeamDetailVisible(true);

                } else if (currentTeam.isTeamDetailVisible()) {
                    holder.teamDownArrowImageView.animate().rotationBy(180).setDuration(90).start();
                    holder.teamMemberRecyclerView.setVisibility(View.GONE);
                    currentTeam.setTeamDetailVisible(false);
                    onDetachedFromRecyclerView(holder.teamMemberRecyclerView);
                    System.gc();
                }

            }
        });

        if (currentTeam.isTeamDetailVisible()) {
            Thread clearDetailLayouts = new Thread(new Runnable() {
                @Override
                public void run() {
                    holder.teamMemberRecyclerView.setVisibility(View.GONE);
                    currentTeam.setTeamDetailVisible(false);
                    holder.teamMemberRecyclerView.destroyDrawingCache();
                    onDetachedFromRecyclerView(holder.teamMemberRecyclerView);
                    System.gc();
                }
            });

            clearDetailLayouts.start();

        }

    }


    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        System.gc();

    }

    @Override
    public int getItemCount() {
        return teamsArrayList.size();
    }

    private void centerMember() {
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
    }


    static class TeamsHolder extends RecyclerView.ViewHolder {
        TextView teamLabelTextView;
        ImageView teamDownArrowImageView;
        RecyclerView teamMemberRecyclerView;

        TeamsHolder(View itemView) {
            super(itemView);
            teamLabelTextView = (TextView) itemView.findViewById(R.id.team_label);
            teamDownArrowImageView = (ImageView) itemView.findViewById(R.id.team_down_arrow);
            teamMemberRecyclerView = (RecyclerView) itemView.findViewById(R.id.team_members_recycler_view);
        }
    }
}