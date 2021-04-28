package com.uregina.app;
import static org.junit.Assert.*;

import java.util.ArrayList;

import com.uregina.exceptions.MoreThanOneDayException;

import org.junit.Test;

public class TicketTest {
       
    @Test
    public void maxFlightCountExceeded()
    {
        try{

            Date date1 = new Date(4,26,2021);
            Date date2 = new Date(4,27,2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(4, 0, AmPm.pm);

            DateTime d1 = new DateTime(date1, time1);
            DateTime d2 = new DateTime(date2,time2);

            Flight flight = new Flight("AAA", "BBB", d1, d2);

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(flight);

            assertFalse(Ticket.checkTicket(ticket, 0, 0, 0, true));


        } catch (Exception e){}

    }

}
