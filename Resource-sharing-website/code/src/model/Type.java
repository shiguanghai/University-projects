package model;

import java.util.List;

public class Type {
    private int Id;
    private String typeName;
    private String picture;
    private List<Video> videoList;

    public Type() {
        super();
    }

    public Type(int id, String typeName, String picture) {
        super();
        Id = id;
        this.typeName = typeName;
        this.picture = picture;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }
}
