package models;

import java.util.Objects;

public class Login {
    private int id;
    private String userName;
    private String password;
    private int docId;
    private int patId;

    public Login(String userName, String password, int docId, int patId) {
        this.userName = userName;
        this.password = password;
        this.docId = docId;
        this.patId = patId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getPatId() {
        return patId;
    }

    public void setPatId(int patId) {
        this.patId = patId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return id == login.id &&
                docId == login.docId &&
                patId == login.patId &&
                userName.equals(login.userName) &&
                password.equals(login.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, docId, patId);
    }
}
