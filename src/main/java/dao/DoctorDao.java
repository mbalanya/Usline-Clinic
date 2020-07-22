package dao;

import models.Doctor;

import java.util.List;

public interface DoctorDao {

    //CREATE
    void add(Doctor doctor);

    //READ
    List<Doctor> getAll();
    Doctor findById(int id);

    //UODATE

    //DELETE
    void deleteById(int id);
    void clearAll();
}
