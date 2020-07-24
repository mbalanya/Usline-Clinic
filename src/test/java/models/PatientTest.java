package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PatientTest {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



//    @Test
//    public void getId() {
//        Patient testPatient = setupPatient();
//        assertEquals( 8,testPatient.getId());
//    }

    @Test
    public void getEmail() {
        Patient testPatient = setupPatient();
        assertEquals ("ianamuga@gmail.com", testPatient.getEmail());
    }

//    @Test
//    public void getPassword(){
//        Patient testPatient = setupPatient();
//        assertEquals ("everset", testPatient.getPassword());
//    }

    @Test
    public void getFirstName(){
        Patient testPatient = setupPatient();
        assertEquals ("Bob", testPatient.getFirtsname());
    }

    @Test
    public void getLastName(){
        Patient testPatient = setupPatient();
        assertEquals ("Marley", testPatient.getLastname());
    }

    @Test
    public void getGender(){
        Patient testPatient = setupPatient();
        assertEquals ("male", testPatient.getGender());
    }

    public Patient setupPatient () { return new Patient("ianamuga@gmail.com", "Bob", "Marley", "male", "");

    }
}

