package models;

public class Login {
private int id;
private String username;
private String password;
private int docid;
private int patid;

    public Login(String username, String password, int docid, int patid) {
        this.username = username;
        this.password = password;
        this.docid = docid;
        this.patid = patid;
    }
}
