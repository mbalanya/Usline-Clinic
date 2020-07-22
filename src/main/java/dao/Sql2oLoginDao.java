package dao;

import models.Login;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oLoginDao implements LoginDao{
    private final Sql2o sql2o;
    public Sql2oLoginDao(Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(Login login) {
        String sql = "INSERT INTO doctor (username, password, docid, patid) VALUES (:username, :password, :docid, :patid)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(login)
                    .executeUpdate()
                    .getKey();
            login.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    /*@Override
    public List<Login> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM login")
                    .executeAndFetch(Login.class);
        }
    }*/

    @Override
    public Login findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM login WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Login.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from login WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    /*@Override
    public void clearAll() {
        String sql = "DELETE from login";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }*/
}
