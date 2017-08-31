package charusat.cognizance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import charusat.cognizance.teams.TeamInfo;
import charusat.cognizance.teams.TeamsRecyclerAdapter;


/**
 * Redesigned with considerable amount of XML and revised Java code containing RecyclerView
 */
public class TeamFragment extends Fragment {

    private ArrayList<TeamInfo> teamsArrayList = new ArrayList<>();


    public TeamFragment() {
        // Required empty public constructor
        setTeamsArrayList();
    }



    private void setTeamsArrayList() {
        teamsArrayList.add(new TeamInfo("Council Members", false));
        teamsArrayList.add(new TeamInfo("App Team", false));
        teamsArrayList.add(new TeamInfo("Web Team", false));
        teamsArrayList.add(new TeamInfo("Adhyay Team", false));
        teamsArrayList.add(new TeamInfo("Campaigning Zones Leaders", false));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_team, container, false);

        RecyclerView teamsRecyclerView = (RecyclerView) view.findViewById(R.id.team_members_recycler_view);
        LinearLayoutManager teamsManager = new LinearLayoutManager(view.getContext());
        teamsRecyclerView.setLayoutManager(teamsManager);

        TeamsRecyclerAdapter teamsRecyclerAdapter = new TeamsRecyclerAdapter(teamsArrayList);
        teamsRecyclerView.setAdapter(teamsRecyclerAdapter);

        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
