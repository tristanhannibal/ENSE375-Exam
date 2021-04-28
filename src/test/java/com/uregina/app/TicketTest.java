package com.uregina.app;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.uregina.exceptions.MoreThanOneDayException;

import org.junit.Test;

public class TicketTest {

    @Test
    public void maxFlightCountExceeded_false() {
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

            assertFalse(Ticket.checkTicket(ticket, 0, 0, 0, true));

        } catch (Exception e) {
        }

    }

    @Test
    public void exceptionThrownDateFarApart_false() {
        try {

            Date date1 = new Date(4, 23, 2021);
            Date date2 = new Date(4, 27, 2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(4, 0, AmPm.pm);

            DateTime d1 = new DateTime(date1, time1);
            DateTime d2 = new DateTime(date2, time2);

            Flight flight = new Flight("AAA", "BBB", d1, d2);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);

            assertFalse(Ticket.checkTicket(ticket, 2, 0, 0, true));

        } catch (Exception e) {

        }

    }

    @Test
    public void nonValidAirportCode_false() {
        try {

            Date date1 = new Date(4, 27, 2021);
            Date date2 = new Date(4, 27, 2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(4, 0, AmPm.pm);

            DateTime d1 = new DateTime(date1, time1);
            DateTime d2 = new DateTime(date2, time2);

            Flight flight = new Flight("AAAA", "BBB", d1, d2);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);

            assertFalse(Ticket.checkTicket(ticket, 2, 0, 0, true));

        } catch (Exception e) {

        }

    }

    @Test
    public void flightTimeExceeded_false() {
        try {

            Date date1 = new Date(4, 27, 2021);
            Date date2 = new Date(4, 27, 2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(5, 0, AmPm.pm);

            DateTime d1 = new DateTime(date1, time1);
            DateTime d2 = new DateTime(date2, time2);

            Flight flight = new Flight("AAA", "BBB", d1, d2);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);

            assertFalse(Ticket.checkTicket(ticket, 2, 50, 0, true));

        } catch (Exception e) {
        }

    }

    @Test
    public void arrivalDepartureMismatch_false() {
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

            Flight flight = new Flight("AAA", "BBB", d1, d2);
            Flight flight2 = new Flight("DDD", "CCC", d3, d4);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);
            ticket.add(flight2);

            assertFalse(Ticket.checkTicket(ticket, 3, 10000, 1000, true));

        } catch (Exception e) {

        }
    }

    @Test
    public void schedgenTravelWithoutVisa_False() {
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

            Flight flight = new Flight("HEL", "VIE", d1, d2);
            Flight flight2 = new Flight("VIE", "BRU", d3, d4);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);
            ticket.add(flight2);

            assertFalse(Ticket.checkTicket(ticket, 3, 10000, 1000, false));

        } catch (Exception e) {

        }

    }


    @Test
    public void validFlightTwoFlight_True() {
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

            Flight flight = new Flight("HEL", "VIE", d1, d2);
            Flight flight2 = new Flight("VIE", "BRU", d3, d4);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);
            ticket.add(flight2);

            assertTrue(Ticket.checkTicket(ticket, 3, 10000, 1000, true));

        } catch (Exception e) {

        }

    }


    @Test
    public void validFlightOneTicket() {
        try {

            Date date1 = new Date(4, 27, 2021);
            Date date2 = new Date(4, 27, 2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(5, 0, AmPm.pm);

            DateTime d1 = new DateTime(date1, time1);
            DateTime d2 = new DateTime(date2, time2);

            Flight flight = new Flight("AAA", "BBB", d1, d2);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);

            assertTrue(Ticket.checkTicket(ticket, 2, 100, 0, true));

        } catch (Exception e) {
        }

    }

}
