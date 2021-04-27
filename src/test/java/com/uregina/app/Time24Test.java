package com.uregina.app;
import static org.junit.Assert.*;
import org.junit.Test;
public class Time24Test {
    

    @Test
    public void invalidHours_am_null()
    {
    
       assertNull(Time24.toTime24(-1, 0, AmPm.am));


    }

    @Test
    public void invalidHours_pm_null()
    {
    
       assertNull(Time24.toTime24(-1, 0, AmPm.pm));


    }

    @Test
    public void invalidMinutes12_pm_null()
    {
    
       assertNull(Time24.toTime24(12, 70, AmPm.pm));


    }

    @Test
    public void invalidMinutes12_am_null()
    {
    
       assertNull(Time24.toTime24(12, 70, AmPm.am));


    }

    @Test
    public void valid_not12_am_returnsCorrectTime()
    {
    

       Time24 time = Time24.toTime24(1, 30, AmPm.am);

       assertEquals(time.getHours(),1);
       assertEquals(time.getMinutes(),30);


    }


    @Test
    public void valid_not12_pm_returnsCorrectTime()
    {
    

       Time24 time = Time24.toTime24(2, 30, AmPm.pm);

       assertEquals(time.getHours(),14);
       assertEquals(time.getMinutes(),30);


    }


    @Test
    public void valid_12_pm_returnsCorrectTime()
    {
    

       Time24 time = Time24.toTime24(12, 0, AmPm.pm);

       assertEquals(time.getHours(),12);
       assertEquals(time.getMinutes(),0);


    }

    @Test
    public void valid_12_am_returnsCorrectTime()
    {
    

       Time24 time = Time24.toTime24(12, 0, AmPm.am);

       assertEquals(time.getHours(),0);
       assertEquals(time.getMinutes(),0);


    }
}
