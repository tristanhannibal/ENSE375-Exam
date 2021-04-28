package com.uregina.app;
import static org.junit.Assert.*;

import com.uregina.exceptions.MoreThanOneDayException;

import org.junit.Test;

public class DateTimeTest {
    


    @Test
    public void d1DaybeforeD2()
    {
        DateTime d1 = null;
        DateTime d2 = null;

        try{
            Date date1 = new Date(4,26,2021);
            Date date2 = new Date(4,27,2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(4, 0, AmPm.pm);

            d1 = new DateTime(date1, time1);
            d2 = new DateTime(date2,time2);

        }
        catch (Exception e){
            fail();
        }

        int difference = 0;
        try{

             difference = DateTime.subtract(d1, d2);
        } catch (Exception e){

        }
       
        assertEquals(difference,-1440);


    }



    
    @Test
    public void d2DaybeforeD1()
    {
        DateTime d1 = null;
        DateTime d2 = null;

        try{
            Date date1 = new Date(4,27,2021);
            Date date2 = new Date(4,26,2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(4, 0, AmPm.pm);

            d1 = new DateTime(date1, time1);
            d2 = new DateTime(date2,time2);

        }
        catch (Exception e){
            fail();
        }

        int difference = 0;
        try{

             difference = DateTime.subtract(d1, d2);
        } catch (Exception e){

        }
       
        assertEquals(difference,1440);


    }


    @Test
    public void d2EqualsD1()
    {
        DateTime d1 = null;
        DateTime d2 = null;

        try{
            Date date1 = new Date(4,27,2021);
            Date date2 = new Date(4,27,2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(4, 0, AmPm.pm);

            d1 = new DateTime(date1, time1);
            d2 = new DateTime(date2,time2);

        }
        catch (Exception e){
            fail();
        }

        int difference = 0;
        try{

             difference = DateTime.subtract(d1, d2);
        } catch (Exception e){

        }
       
        assertEquals(difference,0);


    }


    @Test
    public void GreaterThan2DaysExceptionThrown()
    {
        DateTime d1 = null;
        DateTime d2 = null;
        String msg = "";

        try{
            Date date1 = new Date(4,27,2021);
            Date date2 = new Date(4,23,2021);

            Time12 time1 = new Time12(4, 0, AmPm.pm);
            Time12 time2 = new Time12(4, 0, AmPm.pm);

            d1 = new DateTime(date1, time1);
            d2 = new DateTime(date2,time2);

        }
        catch (Exception e){
            fail();
        }

        int difference = 0;
        try{

             difference = DateTime.subtract(d1, d2);
        } catch (MoreThanOneDayException e){
           msg = e.getMessage();
        }
       
        assertEquals("Date difference is more than 1",msg);

    }
}
