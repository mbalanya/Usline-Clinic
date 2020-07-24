package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.*;

import static org.junit.Assert.assertEquals;

public class AppointmentTest {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void getId() {
//        Appointment testAppointment = setupAppointment();
//        assertEquals(1, testAppointment.getId());
//    }



//    @Test
//    public void getDay() {
//        Appointment testAppointment = setupAppointment();
//        assertEquals("2020-6-22", testAppointment.getDay());
//    }




    @Test
    public void getPatId() {
        Appointment testAppointment = setupAppointment();
        assertEquals(3, testAppointment.getPatid());
    }




    @Test
    public void getDocId() {
        Appointment testAppointment = setupAppointment();
        assertEquals(6, testAppointment.getDocid());
    }

//    @Test
//    public void getStartTime() {
//        Appointment testAppointment = setupAppointment();
//        assertEquals("16:00", testAppointment.getStartTime());
//    }
//
//    @Test
//    public void getEndTime() {
//        Appointment testAppointment = setupAppointment();
//        assertEquals("5:00", testAppointment.getEndTime());
//
//    }


    public Appointment setupAppointment () {  return new Appointment(33/2020, "13:30:30","16:40:45",1,5);

    }
}


