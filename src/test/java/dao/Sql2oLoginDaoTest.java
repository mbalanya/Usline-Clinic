package dao;

import models.Login;
import dao.Sql2oLoginDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

public class Sql2oLoginDaoTest {
    private Connection conn;
    private Sql2oLoginDao loginDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        loginDao = new Sql2oLoginDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //helpers

    public Login setupLogin(){
        return new Login("Tom", "Password", 2, 3);
        /*loginDao.add(login);
        return login;*/
    }

    @Test
    public void addingLoginSetsId() throws Exception {
        Login testLogin = setupLogin();
        int originalLoginId = testLogin.getId();
        loginDao.add(testLogin);
        assertNotEquals(originalLoginId, testLogin.getId());
    }

    @Test
    public void addedLoginAreReturnedFromGetAll() throws Exception {
        Login testLogin = setupLogin();
        assertEquals(1, loginDao.getAll().size());
    }

    @Test
    public void noLoginReturnsEmptyList() throws Exception {
        assertEquals(0, loginDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectLogin() throws Exception {
        Login testLogin = setupLogin();
        Login otherLogin = setupLogin();
        assertEquals(testLogin, loginDao.findById(testLogin.getId()));
    }

    /*@Test
    public void updateCorrectlyUpdatesAllFields() throws Exception {
        Login testLogin = setupLogin();
        loginDao.update(testLogin.getId(), "Networking", "Bring internet", 12);
        Login foundLogin = loginDao.findById(testLogin.getId());
        assertEquals("Networking", foundLogin.getName());
        assertEquals("Bring internet", foundLogin.getDescription());
        assertEquals(12, foundLogin.getNumberOfEmployees());
    }*/

    @Test
    public void deleteByIdDeletesCorrectLogin() throws Exception {
        Login testLogin = setupLogin();
        loginDao.add(testLogin);
        Login otherLogin = setupLogin();
        loginDao.add(otherLogin);
        loginDao.deleteById(testLogin.getId());
        assertEquals(1, loginDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Login testLogin = setupLogin();
        Login otherLogin= setupLogin();
        loginDao.clearAll();
        assertEquals(0, loginDao.getAll().size());
    }

}