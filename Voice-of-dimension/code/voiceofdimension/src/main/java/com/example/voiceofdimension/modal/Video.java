package com.example.voiceofdimension.modal;

public class Video {
    private String videoName;
    private String cover;
    public Video(){
        super();
    }
    public Video(String videoName, String cover){
        super();
        this.videoName=videoName;
        this.cover=cover;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }


    public String toString(){
        return "Video [videoName=" + videoName + ", cover=" + cover + "]";
    }
}
