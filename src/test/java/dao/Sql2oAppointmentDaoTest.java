package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class Sql2oAppointmentDaoTest {
    private static Connection conn;
    private static Sql2oAppointmentDao appointmentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/usline_clinic_test";
        Sql2o sql2o = new Sql2o(connectionString, "chalookoba", "Mbalanya7");
        appointmentDao = new Sql2oAppointmentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing database");
        appointmentDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection closed");
    }
}
