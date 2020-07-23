package dao;

import models.Login;

import java.util.List;

public interface LoginDao {

    //CREATE
    void logIn(String username, String paswword);

    //READ
    /*List<Login> getAll();*/
//    Login findById(int id);

    //UPDATE

    //DELETE
//    void deleteById(int id);
    /*void clearAll();*/
}
