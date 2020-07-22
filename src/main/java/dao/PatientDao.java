package dao;

import models.Patient;

import java.util.List;

public interface PatientDao {

    //CREATE
    void add(Patient patient);

    //READ
    List<Patient> getAll();
    Patient findById(int id);

    //UODATE

    //DELETE
    void deleteById(int id);
    void clearAll();
}
