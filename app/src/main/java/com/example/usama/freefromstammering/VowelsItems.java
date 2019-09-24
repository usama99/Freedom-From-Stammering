package com.example.usama.freefromstammering;

public class VowelsItems {

    private String titles, descriptions;
    private int wordId, volumeId;

    public VowelsItems(int wordId, String titles, String descriptions, int volumeId){
        this.wordId = wordId;
        this.titles = titles;
        this.descriptions = descriptions;
        this.volumeId = volumeId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public int getWordId() {
        return wordId;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getTitles() {
        return titles;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setVolumeId(int volumeId) {
        this.volumeId = volumeId;
    }

    public int getVolumeId() {
        return volumeId;
    }
}
