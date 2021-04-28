package com.uregina.app;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CyclicTest {
    
    
    @Test
    public void oneFlighSameFinalArrivalNoRepeats_false() {
     
        try {

            Date date1 = new Date(4, 26, 2021);
            Date date2 = new Date(4, 27, 2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(4, 0, AmPm.pm);

            DateTime d1 = new DateTime(date1, time1);
            DateTime d2 = new DateTime(date2, time2);

            Flight flight = new Flight("AAA", "AAA", d1, d2);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);

            assertFalse(Ticket.hasCyclicTrip(ticket));

        } catch (Exception e) {
        }

    }


    @Test
    public void oneFlightNoDuplicatesDifferentDepartureAndFinalArrival() {
     
        try {

            Date date1 = new Date(4, 26, 2021);
            Date date2 = new Date(4, 27, 2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(4, 0, AmPm.pm);

            DateTime d1 = new DateTime(date1, time1);
            DateTime d2 = new DateTime(date2, time2);

            Flight flight = new Flight("AAA", "BBB", d1, d2);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);

            assertFalse(Ticket.hasCyclicTrip(ticket));

        } catch (Exception e) {
        }

    }



    
    @Test
    public void twoFlightDuplicates() {
     
        try {

            Date date1 = new Date(4, 27, 2021);
            Date date2 = new Date(4, 27, 2021);
            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(5, 0, AmPm.pm);
            DateTime d1 = new DateTime(date1, time1);
            DateTime d2 = new DateTime(date2, time2);
            Date date3 = new Date(4, 27, 2021);
            Date date4 = new Date(4, 27, 2021);
            Time12 time3 = new Time12(7, 0, AmPm.pm);
            Time12 time4 = new Time12(9, 0, AmPm.pm);
            DateTime d3 = new DateTime(date3, time3);
            DateTime d4 = new DateTime(date4, time4);

            Date date5 = new Date(4, 27, 2021);
            Date date6 = new Date(4, 27, 2021);
            Time12 time5 = new Time12(4, 0, AmPm.pm);
            Time12 time6 = new Time12(5, 0, AmPm.pm);
            DateTime d5 = new DateTime(date5, time5);
            DateTime d6 = new DateTime(date6, time6);
            Date date7 = new Date(4, 27, 2021);
            Date date8 = new Date(4, 27, 2021);
            Time12 time7 = new Time12(7, 0, AmPm.pm);
            Time12 time8 = new Time12(9, 0, AmPm.pm);
            DateTime d7 = new DateTime(date7, time7);
            DateTime d8 = new DateTime(date8, time8);

            Flight flight = new Flight("BBB", "AAA", d1, d2);
            Flight flight2 = new Flight("CCC", "BBB", d3, d4);
            Flight flight3 = new Flight("BBB", "CCC", d5, d6);
            Flight flight4 = new Flight("AAA", "BBB", d7, d8);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);
            ticket.add(flight2);
            ticket.add(flight3);
            ticket.add(flight4);
            assertTrue(Ticket.hasCyclicTrip(ticket));

        } catch (Exception e) {
            System.out.println("here");
        }

    }


}
