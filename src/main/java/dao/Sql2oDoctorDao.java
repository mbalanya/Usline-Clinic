package dao;

import models.Doctor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDoctorDao implements DoctorDao{
    private final Sql2o sql2o;
    public Sql2oDoctorDao(Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(Doctor doctor) {
        String sql = "INSERT INTO doctor (firstname, lastname, email, password, gender, phone, role) VALUES (:firstname, :lastname, :email, :password, :gender, :phone, :role)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(doctor)
                    .executeUpdate()
                    .getKey();
            doctor.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Doctor> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM doctor")
                    .executeAndFetch(Doctor.class);
        }
    }

    @Override
    public Doctor findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM doctor WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Doctor.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from doctor WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from doctor";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
