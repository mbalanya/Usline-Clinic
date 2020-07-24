package dao;

import models.Doctor;
import dao.Sql2oDoctorDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.print.Doc;
import java.util.Arrays;

public class Sql2oDoctorDaoTest {
    private Connection conn;
    private Sql2oDoctorDao doctorDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        doctorDao = new Sql2oDoctorDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //helpers

    public Doctor setupDoctor(){
        return new Doctor("Tom", "Jerry", "test@tomjerry.com", "Password", "male", "098765543");
        /*patientDao.add(patient);
        return patient;*/
    }

    @Test
    public void addingDoctorSetsId() throws Exception {
        Doctor testDoctor = setupDoctor();
        int originalDoctorId = testDoctor.getId();
        doctorDao.add(testDoctor);
        assertNotEquals(originalDoctorId, testDoctor.getId());
    }

    @Test
    public void addedDoctorAreReturnedFromGetAll() throws Exception {
        Doctor testDoctor = setupDoctor();
        assertEquals(1, doctorDao.getAll().size());
    }

    @Test
    public void noDoctorReturnsEmptyList() throws Exception {
        assertEquals(0, doctorDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectDoctor() throws Exception {
        Doctor testDoctor= setupDoctor();
        Doctor otherDoctor = setupDoctor();
        assertEquals(testDoctor, doctorDao.findById(testDoctor.getId()));
    }

    /*@Test
    public void updateCorrectlyUpdatesAllFields() throws Exception {
        Patient testPatient = setupPatient();
        patientDao.update(testPatient.getId(), "Networking", "Bring internet", 12);
        Patient foundPatient = patientDao.findById(testPatient.getId());
        assertEquals("Networking", foundPatient.getName());
        assertEquals("Bring internet", foundPatient.getDescription());
        assertEquals(12, foundPatient.getNumberOfEmployees());
    }*/

    @Test
    public void deleteByIdDeletesCorrectDoctor() throws Exception {
        Doctor testDoctor = setupDoctor();
        doctorDao.add(testDoctor);
        Doctor otherDoctor = setupDoctor();
        doctorDao.add(otherDoctor);
        doctorDao.deleteById(testDoctor.getId());
        assertEquals(1, doctorDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Doctor testDoctor = setupDoctor();
        Doctor otherDoctor= setupDoctor();
        doctorDao.clearAll();
        assertEquals(0, doctorDao.getAll().size());
    }

}