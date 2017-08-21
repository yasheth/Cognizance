package charusat.cognizance.teams;

import charusat.cognizance.R;

/**
 * Created by iharsh on 21/8/17.
 */

public class MemberInfo {
    private Integer mMemberImageResourceId = R.drawable.ic_user;
    private Integer mMemberLabelResourceId = R.string.sample_member_label;

    public MemberInfo(Integer mMemberImageResourceId, Integer mMemberLabelResourceId) {
        this.mMemberImageResourceId = mMemberImageResourceId;
        this.mMemberLabelResourceId = mMemberLabelResourceId;
    }

    public MemberInfo() {
    }

    public Integer getmMemberImageResourceId() {
        return mMemberImageResourceId;
    }

    public Integer getmMemberLabelResourceId() {
        return mMemberLabelResourceId;
    }
}
