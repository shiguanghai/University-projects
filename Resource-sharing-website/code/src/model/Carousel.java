package model;

public class Carousel {
    private int Id;
    private String Carousel;
    private String Url;
    private String address;
    private String Iframe;

    public Carousel() {
        super();
    }

    public Carousel(int id, String carousel, String url, String address, String iframe) {
        super();
        Id = id;
        Carousel = carousel;
        Url = url;
        this.address = address;
        Iframe = iframe;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCarousel() {
        return Carousel;
    }

    public void setCarousel(String carousel) {
        Carousel = carousel;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIframe() {
        return Iframe;
    }

    public void setIframe(String iframe) {
        Iframe = iframe;
    }
}
