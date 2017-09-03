package charusat.cognizance.teams;

/**
 * Created by Umang on 30/8/17.
 *
 */

public class TeamInfo {
    private String teamLabel;
    private boolean teamDetailVisible;

    public TeamInfo(String teamLabel, boolean teamDetailVisible) {
        this.teamLabel = teamLabel;
        this.teamDetailVisible = teamDetailVisible;
    }

    String getTeamLabel() {
        return teamLabel;
    }

    boolean isTeamDetailVisible() {
        return teamDetailVisible;
    }

    void setTeamDetailVisible(boolean teamDetailVisible) {
        this.teamDetailVisible = teamDetailVisible;
    }
}
