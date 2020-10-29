package model;

public class User {
    private int Id;
    private String userName;
    private String passWord;
    private int Ident;
    private String Telephone;
    private String Address;

    public User() {
        super();
    }

    public User(int id, String userName, String passWord, int ident, String telephone, String address) {
        super();
        Id = id;
        this.userName = userName;
        this.passWord = passWord;
        Ident = ident;
        Telephone = telephone;
        Address = address;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getIdent() {
        return Ident;
    }

    public void setIdent(int ident) {
        Ident = ident;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
