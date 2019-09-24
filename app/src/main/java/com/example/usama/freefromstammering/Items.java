package com.example.usama.freefromstammering;

public class Items {

    private String source, title, description, timer;

    public Items(String source, String title, String description, String timer){
        this.source = source;
        this.title = title;
        this.description = description;
        this.timer = timer;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimer() {
        return timer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public String getTitle() {
        return title;
    }
}
