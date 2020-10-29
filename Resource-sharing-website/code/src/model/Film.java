package model;

public class Film {
    private int Id;
    private String filmAuthor;
    private String Url;
    private String Address;
    private String Flag;

    public Film() {
        super();
    }

    public Film(int id, String filmAuthor, String url, String address, String flag) {
        super();
        Id = id;
        this.filmAuthor = filmAuthor;
        Url = url;
        Address = address;
        Flag = flag;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFilmAuthor() {
        return filmAuthor;
    }

    public void setFilmAuthor(String filmAuthor) {
        this.filmAuthor = filmAuthor;
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

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }
}
