package model;

import java.util.List;

public class Video {
    private int Id;
    private String videoName;
    private String Url;
    private String Address;
    private String Iframe;
    private String Type;
    private int Reco;

    public Video() {
        super();
    }

    public Video(int id, String videoName, String url, String address, String iframe, String type, int reco) {
        super();
        Id = id;
        this.videoName = videoName;
        Url = url;
        Address = address;
        Iframe = iframe;
        Type = type;
        Reco = reco;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getIframe() {
        return Iframe;
    }

    public void setIframe(String iframe) {
        Iframe = iframe;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getReco() {
        return Reco;
    }

    public void setReco(int reco) {
        Reco = reco;
    }
}
