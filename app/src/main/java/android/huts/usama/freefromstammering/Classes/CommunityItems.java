package android.huts.usama.freefromstammering.Classes;

public class CommunityItems {
    private String name;
    private String icon;

    public CommunityItems(String name, String icon){
        this.name = name;
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
