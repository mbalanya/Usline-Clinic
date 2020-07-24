import dao.*;
import com.google.gson.Gson;
import models.Login;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        Sql2o sql2o = DB.sql2o;
        Connection con;
        Gson gson = new Gson();
        staticFileLocation("public");
        Sql2oLoginDao loginDao;
        loginDao = new Sql2oLoginDao(sql2o);
    }

//        get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            List<EndangeredAnimal> animals = EndangeredAnimal.all();
//            model.put("animals",animals);
//            model.put("sightings",Sighting.all());
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
// get("/login", "application/json", (req, res) -> {
//            Login login = gson.fromJson(req.body(), Login.class);
//            res.status(201);
//            return gson.toJson(login);
//        });
//        post("/login-details", "application/json", (req, res) -> {
//            Login login = gson.fromJson(req.body(), Login.class);
//            loginDao.add(login);
//            res.status(201);
//            return gson.toJson(login);
//        });
//    }
}
