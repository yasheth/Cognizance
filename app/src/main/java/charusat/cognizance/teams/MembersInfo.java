package charusat.cognizance.teams;

import java.util.ArrayList;

import charusat.cognizance.R;

/**
 * Created by Umang on 30/8/17.
 *
 */

class MembersInfo {
    private int memberImageResourceId;
    private int memberLabelResourceId;

    private ArrayList<MembersInfo> mAppTeamMembersList = new ArrayList<>();
    private ArrayList<MembersInfo> mCouncilTeamMembersList = new ArrayList<>();
    private ArrayList<MembersInfo> mWebTeamMembersList = new ArrayList<>();
    private ArrayList<MembersInfo> mAdhyayTeamMembersList = new ArrayList<>();
    private ArrayList<MembersInfo> mCampZoneTeamMembersList = new ArrayList<>();

    MembersInfo(int position) {
        //Default Constructor required
        switch (position) {
            case 1:
                setCouncilMembersArrayList();
                break;
            case 2:
                setAppTeamMembers();
                break;
            case 3:
                setWebTeamMembers();
                break;
            case 4:
                setAdhyayTeamMembers();
                break;
            case 5:
                setCampZoneTeamMembers();
                break;
        }
    }

    private MembersInfo(int memberImageResourceId, int memberLabelResourceId) {
        this.memberLabelResourceId = memberLabelResourceId;
        this.memberImageResourceId = memberImageResourceId;
    }

    private void setCouncilMembersArrayList() {
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.it_harsh_shah, R.string.cc_harsh_shah_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.it_karan_paruchi, R.string.cc_karan_paruthi));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.ce_keval_vatoria, R.string.cc_keval_varoteriya_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.ce_niraj_gohil, R.string.cc_niraj_gohel_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.ec_ronak_kataria, R.string.cc_ronak_katariya_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.ec_shalini_mishra, R.string.cc_shalini_mishra_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.ee_sagar_joshi, R.string.cc_sagar_joshi_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.ee_ronit_sarkar, R.string.cc_ronit_sarkar_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.cl_rajan_joshi, R.string.cc_rajan_joshi_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.cl_neha_rajput, R.string.cc_neha_rajput_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.me_karunya_pramanik, R.string.cc_karunaya_parmanik_label));
        mCouncilTeamMembersList.add(new MembersInfo(R.raw.me_darshan_pandya, R.string.cc_darshan_pandey_label));
    }

    private void setAppTeamMembers() {
        mAppTeamMembersList.add(new MembersInfo(R.raw.app_yash_sheth, R.string.app_yash_sheth_label));
        mAppTeamMembersList.add(new MembersInfo(R.raw.app_harsh_shah, R.string.app_harsh_shah_label));
        mAppTeamMembersList.add(new MembersInfo(R.raw.app_umang_patel, R.string.app_umang_patel_label));
        mAppTeamMembersList.add(new MembersInfo(R.raw.app_yash_sodha, R.string.app_yash_sodha_label));
        mAppTeamMembersList.add(new MembersInfo(R.raw.app_mitkumar_patel, R.string.app_mit_patel_label));
    }


    private void setWebTeamMembers() {
        mWebTeamMembersList.add(new MembersInfo(R.drawable.captain, R.string.web_gaurav_joshi_label));
        mWebTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.web_dhruvil_bhat_label));
        mWebTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.web_shrey_dalwadi_label));
        mWebTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.web_punya_kotecha_label));
        mWebTeamMembersList.add(new MembersInfo(R.drawable.girl, R.string.web_vidhi_kokel_label));
        mWebTeamMembersList.add(new MembersInfo(R.drawable.girl, R.string.web_shweta_masrani_label));
        mWebTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.web_chintan_maniyar_label));

    }

    private void setAdhyayTeamMembers() {
        mAdhyayTeamMembersList.add(new MembersInfo(R.drawable.captain, R.string.adhyay_hiteksha_patel_label));
        mAdhyayTeamMembersList.add(new MembersInfo(R.drawable.girl, R.string.adhyay_sadhika_sajeev_label));
        mAdhyayTeamMembersList.add(new MembersInfo(R.drawable.girl, R.string.adhyay_parita_shukla_label));
        mAdhyayTeamMembersList.add(new MembersInfo(R.drawable.girl, R.string.adhyay_kennita_sabu_label));
        mAdhyayTeamMembersList.add(new MembersInfo(R.drawable.girl, R.string.adhyay_sweta_samaddar_label));
        mAdhyayTeamMembersList.add(new MembersInfo(R.drawable.girl, R.string.adhyay_agrima_goel_label));
        mAdhyayTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.adhyay_sujay_modi_label));
    }

    private void setCampZoneTeamMembers() {
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_lay_patel_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_chaitanya_mistry_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_jay_kotecha_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_satyajitsinh_jhala_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_him_patel_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_dasharath_sagar_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_diyvarajsinh_limbola_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_chirag_kalsariya_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_yash_tejani_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_digant_limbani_label));
        mCampZoneTeamMembersList.add(new MembersInfo(R.drawable.man, R.string.camp_zone_rahul_ravichandran_label));
    }

    ArrayList<MembersInfo> getmAppTeamMembersList() {
        return mAppTeamMembersList;
    }

    ArrayList<MembersInfo> getmCouncilTeamMembersList() {
        return mCouncilTeamMembersList;
    }

    ArrayList<MembersInfo> getmWebTeamMembersList() {
        return mWebTeamMembersList;
    }

    ArrayList<MembersInfo> getmAdhyayTeamMembersList() {
        return mAdhyayTeamMembersList;
    }

    ArrayList<MembersInfo> getmCampZoneTeamMembersList() {
        return mCampZoneTeamMembersList;
    }

    int getMemberLabelResourceId() {
        return memberLabelResourceId;
    }

    int getMemberImageResourceId() {
        return memberImageResourceId;
    }

}
