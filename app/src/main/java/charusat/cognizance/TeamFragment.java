package charusat.cognizance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */

/**
 * Time : 11 : 27 a.m MEMORY RESOURCE USAGE = 4.51 mb
 * Layout had placeholder images ic_user.img in the drawable folder
 */
public class TeamFragment extends Fragment {

    private ImageView mAppTeamDownArrowImageView;
    private ImageView mCouncilTeamDownArrowImageView;
    private ImageView mWebTeamDownArrowImageView;
    private LinearLayout mWebTeamDetailLinearLayout;
    private LinearLayout mCouncilTeamDetailLinearLayout;
    private LinearLayout mAppTeamDetailLinearLayout;
    private boolean mIsAppDetailExpanded = false;
    private boolean mIsWebDetailExpanded = false;
    private boolean mIsCouncilDetailExpanded = false;


    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        mAppTeamDetailLinearLayout = (LinearLayout) view.findViewById(R.id.app_team_detail);
        mWebTeamDetailLinearLayout = (LinearLayout) view.findViewById(R.id.web_team_detail);
        mCouncilTeamDetailLinearLayout = (LinearLayout) view.findViewById(R.id.council_team_detail);
        mAppTeamDownArrowImageView = (ImageView) view.findViewById(R.id.app_team_down_arrow);
        mWebTeamDownArrowImageView = (ImageView) view.findViewById(R.id.web_team_down_arrow);
        mCouncilTeamDownArrowImageView = (ImageView) view.findViewById(R.id.council_team_down_arrow);
        mAppTeamDownArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mIsAppDetailExpanded) {
                    if (mIsWebDetailExpanded) {
                        mWebTeamDownArrowImageView.animate().rotationBy(180).setDuration(100).start();
                        hideWebTeamDetail();
                    }
                    if (mIsCouncilDetailExpanded) {
                        mCouncilTeamDownArrowImageView.animate().rotationBy(180).setDuration(100).start();
                        hideCouncilTeamDetail();
                    }
                    v.animate().rotationBy(180).setDuration(100).start();
                    showAppTeamDetail();
                } else {
                    v.animate().rotationBy(180).setDuration(100).start();
                    hideAppTeamDetail();
                }
            }
        });
        mWebTeamDownArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsWebDetailExpanded) {
                    if (mIsAppDetailExpanded) {
                        mAppTeamDownArrowImageView.animate().rotationBy(180).setDuration(100).start();
                        hideAppTeamDetail();
                    }
                    if (mIsCouncilDetailExpanded) {
                        mCouncilTeamDownArrowImageView.animate().rotationBy(180).setDuration(100).start();
                        hideCouncilTeamDetail();
                    }
                    v.animate().rotationBy(180).setDuration(100).start();
                    showWebTeamDetail();
                } else {
                    v.animate().rotationBy(180).setDuration(100).start();
                    hideWebTeamDetail();
                }
            }
        });
        mCouncilTeamDownArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsCouncilDetailExpanded) {
                    if (mIsAppDetailExpanded) {
                        mAppTeamDownArrowImageView.animate().rotationBy(180).setDuration(100).start();
                        hideAppTeamDetail();
                    }
                    if (mIsWebDetailExpanded) {
                        mWebTeamDownArrowImageView.animate().rotationBy(180).setDuration(100).start();
                        hideWebTeamDetail();
                    }
                    v.animate().rotationBy(180).setDuration(100).start();
                    showCouncilTeamDetail();
                } else {
                    v.animate().rotationBy(180).setDuration(100).start();
                    hideCouncilTeamDetail();
                }
            }
        });


        //Returns the inflated view for fragment implementation on the screen
        return view;

    }

    private void hideCouncilTeamDetail() {
        mCouncilTeamDetailLinearLayout.setVisibility(View.GONE);
        mIsCouncilDetailExpanded = false;
    }

    private void showCouncilTeamDetail() {
        mCouncilTeamDetailLinearLayout.setVisibility(View.VISIBLE);
        mIsCouncilDetailExpanded = true;
    }

    private void hideWebTeamDetail() {
        mWebTeamDetailLinearLayout.setVisibility(View.GONE);
        mIsWebDetailExpanded = false;
    }

    private void showWebTeamDetail() {
        mWebTeamDetailLinearLayout.setVisibility(View.VISIBLE);
        mIsWebDetailExpanded = true;
    }

    private void hideAppTeamDetail() {
        mAppTeamDetailLinearLayout.setVisibility(View.GONE);
        mIsAppDetailExpanded = false;
    }

    private void showAppTeamDetail() {
        mAppTeamDetailLinearLayout.setVisibility(View.VISIBLE);
        mIsAppDetailExpanded = true;
    }


}
