package charusat.cognizance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import charusat.cognizance.teams.MemberInfo;
import charusat.cognizance.teams.TeamRecyclerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */

/**
 * Time : 11 : 27 a.m MEMORY RESOURCE USAGE = 4.51 mb
 * Layout had placeholder images ic_user.img in the drawable folder
 */
public class TeamFragment extends Fragment {

    private boolean isAppDetailExpanded = false;
    private boolean isCouncilDetailExpanded = false;
    private boolean isWebDetailExpanded = false;
    private ArrayList<MemberInfo> mAppTeamMembersList = new ArrayList<>();
    private ArrayList<MemberInfo> mCouncilTeamMembersList = new ArrayList<>();
    private ArrayList<MemberInfo> mWebTeamMembersList = new ArrayList<>();
    private ImageView mAppTeamArrowImageView;
    private ImageView mCouncilTeamArrowImageView;
    private ImageView mWebTeamArrowImageView;
    private RecyclerView mAppTeamRecyclerView;
    private RecyclerView mCouncilTeamRecyclerView;
    private RecyclerView mWebTeamRecyclerView;

    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_team, container, false);

        addAppTeamMembers();
        addCouncilTeamMembers();
        addWebTeamMembers();
        mAppTeamArrowImageView = (ImageView) view.findViewById(R.id.app_team_down_arrow);
        mAppTeamRecyclerView = (RecyclerView) view.findViewById(R.id.app_team_recycler_view);
        mCouncilTeamArrowImageView = (ImageView) view.findViewById(R.id.council_team_down_arrow);
        mCouncilTeamRecyclerView = (RecyclerView) view.findViewById(R.id.council_team_recycler_view);
        mWebTeamArrowImageView = (ImageView) view.findViewById(R.id.web_team_down_arrow);
        mWebTeamRecyclerView = (RecyclerView) view.findViewById(R.id.web_team_recycler_view);
        mAppTeamArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isCouncilDetailExpanded && !isWebDetailExpanded) {
                    displayAppTeamMembers(view);
                } else {
                    hideCouncilTeamMembers();
                    hideWebTeamMembers();
                    displayAppTeamMembers(view);
                }

            }
        });
        mCouncilTeamArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAppDetailExpanded && !isWebDetailExpanded) {
                    displayCouncilTeamMembers(view);
                } else {
                    hideAppTeamMembers();
                    hideWebTeamMembers();
                    displayCouncilTeamMembers(view);
                }
            }
        });
        mWebTeamArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAppDetailExpanded && !isCouncilDetailExpanded) {
                    displayWebTeamMembers(view);
                } else {
                    hideAppTeamMembers();
                    hideCouncilTeamMembers();
                    displayWebTeamMembers(view);
                }
            }
        });


        return view;

    }

    private void displayWebTeamMembers(View view) {
        mWebTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        final GridLayoutManager mWebTeamLayoutManager = new GridLayoutManager(view.getContext(), 2);
        if (!isWebDetailExpanded) {
            mWebTeamLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position == 0) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            });
            mWebTeamRecyclerView.setLayoutManager(mWebTeamLayoutManager);
            TeamRecyclerAdapter mWebTeamAdapter = new TeamRecyclerAdapter(mWebTeamMembersList);
            mWebTeamRecyclerView.setAdapter(mWebTeamAdapter);
            mWebTeamRecyclerView.setVisibility(View.VISIBLE);
            isWebDetailExpanded = true;
        } else {
            hideWebTeamMembers();
        }
    }

    private void hideWebTeamMembers() {
        mWebTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        mWebTeamRecyclerView.setVisibility(View.GONE);
        isWebDetailExpanded = false;
    }


    private void displayCouncilTeamMembers(View view) {
        mCouncilTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        if (!isCouncilDetailExpanded) {
            GridLayoutManager mCouncilTeamLayoutManager = new GridLayoutManager(view.getContext(), 2);
            mCouncilTeamRecyclerView.setLayoutManager(mCouncilTeamLayoutManager);
            TeamRecyclerAdapter mCouncilTeamAdapter = new TeamRecyclerAdapter(mCouncilTeamMembersList);
            mCouncilTeamRecyclerView.setAdapter(mCouncilTeamAdapter);
            mCouncilTeamRecyclerView.setVisibility(View.VISIBLE);
            isCouncilDetailExpanded = true;
        } else {
            hideCouncilTeamMembers();
        }
    }

    private void hideCouncilTeamMembers() {
        mCouncilTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        mCouncilTeamRecyclerView.setVisibility(View.GONE);
        isCouncilDetailExpanded = false;
    }


    private void displayAppTeamMembers(View view) {
        mAppTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        final GridLayoutManager mAppTeamLayoutManager = new GridLayoutManager(view.getContext(), 2);
        if (!isAppDetailExpanded) {
            mAppTeamLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position == 0) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            });
            mAppTeamRecyclerView.setLayoutManager(mAppTeamLayoutManager);
            TeamRecyclerAdapter mAppTeamAdapter = new TeamRecyclerAdapter(mAppTeamMembersList);
            mAppTeamRecyclerView.setAdapter(mAppTeamAdapter);
            mAppTeamRecyclerView.setVisibility(View.VISIBLE);
            isAppDetailExpanded = true;
        } else {
            hideAppTeamMembers();
        }


    }

    private void hideAppTeamMembers() {
        mAppTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        mAppTeamRecyclerView.setVisibility(View.GONE);
        isAppDetailExpanded = false;
    }

    private void addAppTeamMembers() {
        mAppTeamMembersList.add(new MemberInfo());
        mAppTeamMembersList.add(new MemberInfo());
        mAppTeamMembersList.add(new MemberInfo());
        mAppTeamMembersList.add(new MemberInfo());
        mAppTeamMembersList.add(new MemberInfo());
    }

    private void addCouncilTeamMembers() {
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());
        mCouncilTeamMembersList.add(new MemberInfo());

    }

    private void addWebTeamMembers() {
        mWebTeamMembersList.add(new MemberInfo());
        mWebTeamMembersList.add(new MemberInfo());
        mWebTeamMembersList.add(new MemberInfo());
        mWebTeamMembersList.add(new MemberInfo());
        mWebTeamMembersList.add(new MemberInfo());
    }


}
