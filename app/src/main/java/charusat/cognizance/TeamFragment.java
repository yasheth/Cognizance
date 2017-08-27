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
 * Redesigned with considerable amount of XML and revised Java code containing RecyclerView
 */
public class TeamFragment extends Fragment {

    private boolean isAppDetailExpanded = false;
    private boolean isCouncilDetailExpanded = false;
    private boolean isWebDetailExpanded = false;
    private boolean isAdhyayDetailExpanded = false;
    private boolean isCampZoneDetailExpanded = false;

    private ArrayList<MemberInfo> mAppTeamMembersList = new ArrayList<>();
    private ArrayList<MemberInfo> mCouncilTeamMembersList = new ArrayList<>();
    private ArrayList<MemberInfo> mWebTeamMembersList = new ArrayList<>();
    private ArrayList<MemberInfo> mAdhyayTeamMembersList = new ArrayList<>();
    private ArrayList<MemberInfo> mCampZoneTeamMembersList = new ArrayList<>();

    private ImageView mAppTeamArrowImageView;
    private ImageView mCouncilTeamArrowImageView;
    private ImageView mWebTeamArrowImageView;
    private ImageView mAdhyayTeamArrowImageView;
    private ImageView mCampZoneTeamArrowImageView;

    private RecyclerView mAppTeamRecyclerView;
    private RecyclerView mCouncilTeamRecyclerView;
    private RecyclerView mWebTeamRecyclerView;
    private RecyclerView mAdhyayTeamRecyclerView;
    private RecyclerView mCampZoneTeamRecyclerView;

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
        addAdhyayTeamMembers();
        addCampZoneTeamMembers();

        mAppTeamArrowImageView = (ImageView) view.findViewById(R.id.app_team_down_arrow);
        mAppTeamRecyclerView = (RecyclerView) view.findViewById(R.id.app_team_recycler_view);
        mCouncilTeamArrowImageView = (ImageView) view.findViewById(R.id.council_team_down_arrow);
        mCouncilTeamRecyclerView = (RecyclerView) view.findViewById(R.id.council_team_recycler_view);
        mWebTeamArrowImageView = (ImageView) view.findViewById(R.id.web_team_down_arrow);
        mWebTeamRecyclerView = (RecyclerView) view.findViewById(R.id.web_team_recycler_view);
        mAdhyayTeamArrowImageView = (ImageView) view.findViewById(R.id.adhyay_team_down_arrow);
        mAdhyayTeamRecyclerView = (RecyclerView) view.findViewById(R.id.adhyay_team_recycler_view);
        mCampZoneTeamArrowImageView = (ImageView) view.findViewById(R.id.camp_zone_team_down_arrow);
        mCampZoneTeamRecyclerView = (RecyclerView) view.findViewById(R.id.camp_zone_team_recycler_view);


        mAppTeamArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isCouncilDetailExpanded && !isWebDetailExpanded && !isAdhyayDetailExpanded && !isCampZoneDetailExpanded) {
                    displayAppTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mAppTeamRecyclerView, mAppTeamRecyclerView);
                } else {

                    if (isCouncilDetailExpanded) {
                        hideCouncilTeamMembers();
                    }
                    if (isWebDetailExpanded) {
                        hideWebTeamMembers();
                    }
                    if (isAdhyayDetailExpanded) {
                        hideAdhyayTeamMembers();
                    }
                    if (isCampZoneDetailExpanded) {
                        hideCampZoneTeamMembers();
                    }
                    displayAppTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mAppTeamRecyclerView, mAppTeamRecyclerView);
                }

            }
        });
        mCouncilTeamArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAppDetailExpanded && !isWebDetailExpanded && !isAdhyayDetailExpanded && !isCampZoneDetailExpanded) {
                    displayCouncilTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mCouncilTeamRecyclerView, mCouncilTeamRecyclerView);
                } else {
                    if (isAppDetailExpanded) {
                        hideAppTeamMembers();
                    }
                    if (isWebDetailExpanded) {
                        hideWebTeamMembers();
                    }
                    if (isAdhyayDetailExpanded) {
                        hideAdhyayTeamMembers();
                    }
                    if (isCampZoneDetailExpanded) {
                        hideCampZoneTeamMembers();
                    }
                    displayCouncilTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mCouncilTeamRecyclerView, mCouncilTeamRecyclerView);
                }
            }
        });
        mWebTeamArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAppDetailExpanded && !isCouncilDetailExpanded && !isAdhyayDetailExpanded && !isCampZoneDetailExpanded) {
                    displayWebTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mWebTeamRecyclerView, mWebTeamRecyclerView);
                } else {
                    if (isAppDetailExpanded) {
                        hideAppTeamMembers();
                    }
                    if (isCouncilDetailExpanded) {
                        hideCouncilTeamMembers();
                    }
                    if (isAdhyayDetailExpanded) {
                        hideAdhyayTeamMembers();
                    }
                    if (isCampZoneDetailExpanded) {
                        hideCampZoneTeamMembers();
                    }
                    displayWebTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mWebTeamRecyclerView, mWebTeamRecyclerView);
                }
            }
        });
        mAdhyayTeamArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAppDetailExpanded && !isCouncilDetailExpanded && !isWebDetailExpanded && !isCampZoneDetailExpanded) {
                    displayAdhyayTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mAdhyayTeamRecyclerView, mAdhyayTeamRecyclerView);
                } else {
                    if (isAppDetailExpanded) {
                        hideAppTeamMembers();
                    }
                    if (isCouncilDetailExpanded) {
                        hideCouncilTeamMembers();
                    }
                    if (isWebDetailExpanded) {
                        hideWebTeamMembers();
                    }
                    if (isCampZoneDetailExpanded) {
                        hideCampZoneTeamMembers();
                    }
                    displayAdhyayTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mAdhyayTeamRecyclerView, mAdhyayTeamRecyclerView);
                }
            }
        });

        mCampZoneTeamArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAppDetailExpanded && !isCouncilDetailExpanded && !isWebDetailExpanded && !isAdhyayDetailExpanded) {
                    displayCampZoneTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mCampZoneTeamRecyclerView, mCampZoneTeamRecyclerView);

                } else {
                    if (isAppDetailExpanded) {
                        hideAppTeamMembers();
                    }
                    if (isCouncilDetailExpanded) {
                        hideCouncilTeamMembers();
                    }
                    if (isWebDetailExpanded) {
                        hideWebTeamMembers();
                    }
                    if (isAdhyayDetailExpanded) {
                        hideAdhyayTeamMembers();
                    }
                    displayCampZoneTeamMembers(view);
                    v.getParent().getParent().requestChildFocus(mCampZoneTeamRecyclerView, mCampZoneTeamRecyclerView);
                }
            }
        });


        return view;

    }


    private void hideCampZoneTeamMembers() {
        mCampZoneTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        mCampZoneTeamRecyclerView.setVisibility(View.GONE);
        isCampZoneDetailExpanded = false;
    }

    private void displayCampZoneTeamMembers(View view) {
        mCampZoneTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        if (!isCampZoneDetailExpanded) {
            GridLayoutManager mCampZoneLayoutManager = new GridLayoutManager(view.getContext(), 2);
            mCampZoneTeamRecyclerView.setLayoutManager(mCampZoneLayoutManager);
            TeamRecyclerAdapter mCampZoneTeamAdapter = new TeamRecyclerAdapter(mCampZoneTeamMembersList);
            mCampZoneTeamRecyclerView.setAdapter(mCampZoneTeamAdapter);
            mCampZoneTeamRecyclerView.setVisibility(View.VISIBLE);
            isCampZoneDetailExpanded = true;
        } else {
            hideCampZoneTeamMembers();
        }
    }


    private void hideAdhyayTeamMembers() {
        mAdhyayTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        mAdhyayTeamRecyclerView.setVisibility(View.GONE);
        isAdhyayDetailExpanded = false;
    }

    private void displayAdhyayTeamMembers(View view) {
        mAdhyayTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        final GridLayoutManager mAdhyayTeamLayoutManager = new GridLayoutManager(view.getContext(), 2);
        if (!isAdhyayDetailExpanded) {
            mAdhyayTeamLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position == 0) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            });
            mAdhyayTeamRecyclerView.setLayoutManager(mAdhyayTeamLayoutManager);
            TeamRecyclerAdapter mAdhyayTeamAdapter = new TeamRecyclerAdapter(mAdhyayTeamMembersList);
            mAdhyayTeamRecyclerView.setAdapter(mAdhyayTeamAdapter);
            mAdhyayTeamRecyclerView.setVisibility(View.VISIBLE);
            isAdhyayDetailExpanded = true;
        } else {
            hideAdhyayTeamMembers();
        }
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

    private void hideAppTeamMembers() {
        mAppTeamArrowImageView.animate().rotationBy(180).setDuration(100).start();
        mAppTeamRecyclerView.setVisibility(View.GONE);
        isAppDetailExpanded = false;
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


    private void addAppTeamMembers() {
        mAppTeamMembersList.add(new MemberInfo(R.raw.app_yash_sheth, R.string.app_yash_sheth_label));
        mAppTeamMembersList.add(new MemberInfo(R.raw.app_harsh_shah, R.string.app_harsh_shah_label));
        mAppTeamMembersList.add(new MemberInfo(R.raw.app_umang_patel, R.string.app_umang_patel_label));
        mAppTeamMembersList.add(new MemberInfo(R.raw.app_yash_sodha, R.string.app_yash_sodha_label));
        mAppTeamMembersList.add(new MemberInfo(R.raw.app_mitkumar_patel, R.string.app_mit_patel_label));
    }

    private void addCouncilTeamMembers() {
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.it_harsh_shah, R.string.cc_harsh_shah_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.it_karan_paruchi, R.string.cc_karan_paruthi));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.ce_keval_vatoria, R.string.cc_keval_varoteriya_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.ce_niraj_gohil, R.string.cc_niraj_gohel_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.ec_ronak_kataria, R.string.cc_ronak_katariya_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.ec_shalini_mishra, R.string.cc_shalini_mishra_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.ee_sagar_joshi, R.string.cc_sagar_joshi_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.ee_ronit_sarkar, R.string.cc_ronit_sarkar_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.cl_rajan_joshi, R.string.cc_rajan_joshi_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.cl_neha_rajput, R.string.cc_neha_rajput_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.me_karunya_pramanik, R.string.cc_karunaya_parmanik_label));
        mCouncilTeamMembersList.add(new MemberInfo(R.raw.me_darshan_pandya, R.string.cc_darshan_pandey_label));
    }

    private void addWebTeamMembers() {
        mWebTeamMembersList.add(new MemberInfo(R.drawable.captain, R.string.web_gaurav_joshi_label));
        mWebTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.web_dhruvil_bhat_label));
        mWebTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.web_shrey_dalwadi_label));
        mWebTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.web_punya_kotecha_label));
        mWebTeamMembersList.add(new MemberInfo(R.drawable.girl, R.string.web_vidhi_kokel_label));
        mWebTeamMembersList.add(new MemberInfo(R.drawable.girl, R.string.web_shweta_masrani_label));
        mWebTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.web_chintan_maniyar_label));

    }

    private void addAdhyayTeamMembers() {
        mAdhyayTeamMembersList.add(new MemberInfo(R.drawable.captain, R.string.adhyay_hiteksha_patel_label));
        mAdhyayTeamMembersList.add(new MemberInfo(R.drawable.girl, R.string.adhyay_sadhika_sajeev_label));
        mAdhyayTeamMembersList.add(new MemberInfo(R.drawable.girl, R.string.adhyay_parita_shukla_label));
        mAdhyayTeamMembersList.add(new MemberInfo(R.drawable.girl, R.string.adhyay_kennita_sabu_label));
        mAdhyayTeamMembersList.add(new MemberInfo(R.drawable.girl, R.string.adhyay_sweta_samaddar_label));
        mAdhyayTeamMembersList.add(new MemberInfo(R.drawable.girl, R.string.adhyay_agrima_goel_label));
        mAdhyayTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.adhyay_sujay_modi_label));
    }

    private void addCampZoneTeamMembers() {
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_lay_patel_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_chaitanya_mistry_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_jay_kotecha_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_satyajitsinh_jhala_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_him_patel_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_dasharath_sagar_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_diyvarajsinh_limbola_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_chirag_kalsariya_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_yash_tejani_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_digant_limbani_label));
        mCampZoneTeamMembersList.add(new MemberInfo(R.drawable.man, R.string.camp_zone_rahul_ravichandran_label));

    }


}
