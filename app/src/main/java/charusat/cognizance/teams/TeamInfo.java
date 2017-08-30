package charusat.cognizance.teams;

/**
 * Created by iharsh on 30/8/17.
 */

public class TeamInfo {
    private String teamLabel;
    private boolean teamDetailVisible;

    public TeamInfo(String teamLabel, boolean teamDetailVisible) {
        this.teamLabel = teamLabel;
        this.teamDetailVisible = teamDetailVisible;
    }

    public String getTeamLabel() {
        return teamLabel;
    }

    public boolean isTeamDetailVisible() {
        return teamDetailVisible;
    }

    public void setTeamDetailVisible(boolean teamDetailVisible) {
        this.teamDetailVisible = teamDetailVisible;
    }
}
