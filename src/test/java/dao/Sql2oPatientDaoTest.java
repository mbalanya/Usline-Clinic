package dao;

import models.Patient;
import dao.Sql2oPatientDao;
import org.junit.*;

import static org.junit.Assert.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

public class Sql2oPatientDaoTest {
    private static Connection conn;
    private static Sql2oPatientDao patientDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/usline_clinic_test";
        Sql2o sql2o = new Sql2o(connectionString, "chalookoba", "Mbalanya7");
        patientDao = new Sql2oPatientDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing database");
        patientDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
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
        patientDao.add(testPatient);
        assertEquals(1, patientDao.getAll().size());
    }

    @Test
    public void noPatientReturnsEmptyList() throws Exception {
        assertEquals(0, patientDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectPatient() throws Exception {
        Patient testPatient = setupPatient();
        patientDao.add(testPatient);
        Patient otherPatient = setupPatient();
        patientDao.add(otherPatient);
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
        patientDao.add(testPatient);
        Patient otherPatient= setupPatient();
        patientDao.add(otherPatient);
        patientDao.clearAll();
        assertEquals(0, patientDao.getAll().size());
    }

}