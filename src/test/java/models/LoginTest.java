package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUserName() {
        Login testLogin = setupLogin();
        assertEquals("jane", testLogin.getUsername());


    }


//    @Test
//    public void getDocId() {
//        Login testLogin = setupLogin();
//        assertEquals(7, testLogin.getDocid());
//    }

//    @Test
//    public void PatId() {
//        Login testLogin = setupLogin();
//        assertEquals(9, testLogin.getPatid());
//    }

    @Test
    public void getPassword() {
        Login testLogin = setupLogin();
        assertEquals("happy", testLogin.getPassword());

    }

    public Login setupLogin () {
        return new Login ("jane", "happy", 7  ,9 );
    }
}

