package android.huts.usama.freefromstammering.MainMenue.Connection.Fab;

public class FacebookGroups {

    private String fbGroupName;
    private String fbGroupIconName;

    public FacebookGroups(String fbGroupName, String fbGroupIconName){
        this.fbGroupName = fbGroupName;
        this.fbGroupIconName = fbGroupIconName;
    }

    public void setFbGroupName(String fbGroupName) {
        this.fbGroupName = fbGroupName;
    }

    public String getFbGroupName() {
        return fbGroupName;
    }

    public void setFbGroupIconName(String fbGroupIconName) {
        this.fbGroupIconName = fbGroupIconName;
    }

    public String getFbGroupIconName() {
        return fbGroupIconName;
    }
}
