package models;

import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public int getDocid() {
//        return docid;
//    }
//
//    public void setDocid(int docid) {
//        this.docid = docid;
//    }
//
//    public int getPatid() {
//        return patid;
//    }
//
//    public void setPatid(int patid) {
//        this.patid = patid;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return id == login.id &&
                username.equals(login.username) &&
                password.equals(login.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
