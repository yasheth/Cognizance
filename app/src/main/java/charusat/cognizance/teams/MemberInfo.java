package charusat.cognizance.teams;

/**
 * Created by iharsh on 21/8/17.
 */

public class MemberInfo {
    private Integer mMemberImageResourceId;
    private Integer mMemberLabelResourceId;

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
