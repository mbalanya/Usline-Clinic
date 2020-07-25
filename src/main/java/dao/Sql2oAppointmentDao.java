package dao;

import models.Appointment;
import models.Doctor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAppointmentDao implements AppointmentDao {
    private final Sql2o sql2o;
    public Sql2oAppointmentDao(Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(Appointment appointment) {
        String sql = "INSERT INTO appointments (day, starttime,endtime, pacid, docid) VALUES (:day, :startTime, :endTime, :pacid, :docid, )";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(appointment)
                    .executeUpdate()
                    .getKey();
            appointment.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
        @Override
        public List<Appointment> getAll() {
            try(Connection con = sql2o.open()){
                return con.createQuery("SELECT * FROM appointment")
                        .executeAndFetch(Appointment.class);
            }
        }

    @Override
    public Appointment findById(int pacid) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM doctor WHERE pacid = :pacid")
                    .addParameter("pacid", pacid)
                    .executeAndFetchFirst(Appointment.class);
        }
    }


    @Override
    public void deleteById(int pacid) {
        String sql = "DELETE from appointment WHERE pacid = :pacid";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("pacid", pacid)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from appointment";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    }
