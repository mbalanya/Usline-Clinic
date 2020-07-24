package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoctorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //    @Test
//    public void getDocId() {
//        Doctor testDoctor = setupDoctor();
//        assertEquals(6, testDoctor.getDocid());
//    }
    @Test
    public void getEmail() {
        Doctor testDoctor = setupDoctor();
        assertEquals("amuga72@gmail.com", testDoctor.getEmail());
    }

//    @Test
//    public void getPassword() {
//        Doctor testDoctor = setupDoctor();
//        assertEquals("thebest", testDoctor.getEmail());
//    }

    @Test
    public void getFirstName() {
        Doctor testDoctor = setupDoctor();
        assertEquals("Ian", testDoctor.getFirtsname());
    }

    @Test
    public void getLastName() {
        Doctor testDoctor = setupDoctor();
        assertEquals("Mamen", testDoctor.getLastname());
    }

    @Test
    public void getGender() {
        Doctor testDoctor = setupDoctor();
        assertEquals("male", testDoctor.getGender());
    }

    //    @Test
//    public void getId() {
//        Doctor testDoctor = setupDoctor();
//        assertEquals("2", testDoctor.getId());
//    }
    public Doctor setupDoctor () { return new  Doctor ("amuga72@gmail.com", "thebest", "Ian", "Mamen","male" );

    }
}

