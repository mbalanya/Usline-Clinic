package dao;

import models.Patient;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPatientDao implements PatientDao{
    private final Sql2o sql2o;
    public Sql2oPatientDao(Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(Patient patient) {
        String sql = "INSERT INTO patient (firstname, lastname, email, password, gender, phone, role) VALUES (:firstname, :lastname, :email, :password, :gender, :phone, :role)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(patient)
                    .executeUpdate()
                    .getKey();
            patient.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Patient> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM patient")
                    .executeAndFetch(Patient.class);
        }
    }

    @Override
    public Patient findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM patient WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Patient.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from patient WHERE id = :id";
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
        String sql = "DELETE from patient";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
