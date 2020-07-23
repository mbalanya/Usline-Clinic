package dao;
import dao.*;
import com.google.gson.Gson;
import models.Login;
import org.sql2o.Sql2o;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        Sql2o sql2o = DB.sql2o;
        Connection con;
        Gson gson=new Gson();
        staticFileLocation("public");
        Sql2oLoginDao loginDao;
        loginDao = new Sql2oLoginDao(sql2o);

        get("/login", "application/json", (req, res) -> {
            Login login = gson.fromJson(req.body(), Login.class);
            res.status(201);
            return gson.toJson(login);
        });
        post("/login-details", "application/json", (req, res) -> {
            Login login = gson.fromJson(req.body(), Login.class);
            loginDao.add(login);
            res.status(201);
            return gson.toJson(login);
        });
    }
}
