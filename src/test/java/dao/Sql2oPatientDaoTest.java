package dao;

import models.Patient;
import dao.Sql2oPatientDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

public class Sql2oPatientDaoTest {
    private Connection conn;
    private Sql2oPatientDao patientDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        patientDao = new Sql2oPatientDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //helpers

    public Patient setupPatient(){
        return new Patient("Tom", "Jerry", "test@tomjerry.com", "Password", "male", "098765543");
        /*patientDao.add(patient);
        return patient;*/
    }

    @Test
    public void addingPatientSetsId() throws Exception {
        Patient testPatient = setupPatient();
        int originalPatientId = testPatient.getId();
        patientDao.add(testPatient);
        assertNotEquals(originalPatientId, testPatient.getId());
    }

    @Test
    public void addedPatientAreReturnedFromGetAll() throws Exception {
        Patient testPatient = setupPatient();
        assertEquals(1, patientDao.getAll().size());
    }

    @Test
    public void noPatientReturnsEmptyList() throws Exception {
        assertEquals(0, patientDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectPatient() throws Exception {
        Patient testPatient = setupPatient();
        Patient otherPatient = setupPatient();
        assertEquals(testPatient, patientDao.findById(testPatient.getId()));
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
    public void deleteByIdDeletesCorrectPatient() throws Exception {
        Patient testPatient = setupPatient();
        patientDao.add(testPatient);
        Patient otherPatient = setupPatient();
        patientDao.add(otherPatient);
        patientDao.deleteById(testPatient.getId());
        assertEquals(1, patientDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Patient testPatient = setupPatient();
        Patient otherPatient= setupPatient();
        patientDao.clearAll();
        assertEquals(0, patientDao.getAll().size());
    }

}