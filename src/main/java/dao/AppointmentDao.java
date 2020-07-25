package dao;

import models.Appointment;
import models.Doctor;

import java.util.List;

public interface AppointmentDao {
    void add(Appointment appointment);

    List<Appointment> getAll();
    Appointment findById(int id);

    void deleteById(int id);
    void clearAll();
}
