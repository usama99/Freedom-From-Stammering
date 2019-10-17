package android.huts.usama.freefromstammering.Classes;

public class ItemReading {

    private String story, time, reading;

    public ItemReading(String story, String time, String reading){
        this.story = story;
        this.time = time;
        this.reading = reading;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getStory() {
        return story;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }
    public String getReading() {
        return reading;
    }
}
