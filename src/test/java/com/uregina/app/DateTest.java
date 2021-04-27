package com.uregina.app;
import static org.junit.Assert.*;
import org.junit.Test;
public class DateTest {
    
    @Test
    public void D1LessThanD2_AllField_true()
    {

        Date d1 = null;
        Date d2 = null;
        try{
             d1 = new Date(5,5,2000);
             d2 = new Date(8,20,2005);

        } catch(Exception e){
            fail();
        }

        assertTrue(Date.lessThan(d1, d2));
       

    }

    @Test
    public void D1LessThanD2_SameMonthSameDay_true()
    {

        Date d1 = null;
        Date d2 = null;
        try{
             d1 = new Date(5,5,2000);
             d2 = new Date(5,5,2005);

        } catch(Exception e){
            fail();
        }

        assertTrue(Date.lessThan(d1, d2));
       

    }


    @Test
    public void D1LessThanD2_MonthGreaterDayGreater_true()
    {

        Date d1 = null;
        Date d2 = null;
        try{
             d1 = new Date(5,5,2000);
             d2 = new Date(5,5,2005);

        } catch(Exception e){
            fail();
        }

        assertTrue(Date.lessThan(d1, d2));
       

    }


    @Test
    public void D1LessThanD2_SameYearSameMonthLessDay_false()
    {

        Date d1 = null;
        Date d2 = null;
        try{
             d1 = new Date(5,5,2000);
             d2 = new Date(5,3,2000);

        } catch(Exception e){
            fail();
        }

        assertFalse(Date.lessThan(d1, d2));
       

    }


    @Test
    public void D1LessThanD2_SameYearGreaterMonthGreaterDay_false()
    {

        Date d1 = null;
        Date d2 = null;
        try{
             d1 = new Date(5,5,2000);
             d2 = new Date(3,8,2000);

        } catch(Exception e){
            fail();
        }

        assertFalse(Date.lessThan(d1, d2));
       

    }


    @Test
    public void D1LessThanD2_SameYearSmallerMonthSameDay_false()
    {

        Date d1 = null;
        Date d2 = null;
        try{
             d1 = new Date(5,8,2000);
             d2 = new Date(8,8,2000);

        } catch(Exception e){
            fail();
        }

        assertTrue(Date.lessThan(d1, d2));
       

    }


    
    @Test
    public void D1LessThanD2_GreaterYearGreaterMonthSameDay_false()
    {

        Date d1 = null;
        Date d2 = null;
        try{
             d1 = new Date(3,8,2020);
             d2 = new Date(1,8,2000);

        } catch(Exception e){
            fail();
        }

        assertFalse(Date.lessThan(d1, d2));
       

    }


    @Test
    public void D1LessThanD2_GreaterYearSmallerMonthSameDay_false()
    {

        Date d1 = null;
        Date d2 = null;
        try{
             d1 = new Date(1,8,2020);
             d2 = new Date(3,8,2000);

        } catch(Exception e){
            fail();
        }

        assertFalse(Date.lessThan(d1, d2));
       

    }


    @Test
    public void D1LessThanD2_GreaterYearSameMonthSmallerDay_false()
    {

        Date d1 = null;
        Date d2 = null;
        try{
             d1 = new Date(1,8,2020);
             d2 = new Date(3,8,2000);

        } catch(Exception e){
            fail();
        }

        assertFalse(Date.lessThan(d1, d2));
       

    }
}
