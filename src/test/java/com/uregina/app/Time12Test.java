package com.uregina.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class Time12Test {

    @Test
    public void test_case1()
    {
        Time12 t1 = null;
        Time12 t2 = null;
        try{
         t1 = new Time12(1,20,AmPm.am);
         t2 = new Time12(1,30,AmPm.pm);
        }
        catch (Exception e){
            fail();
        }

        
    
        int minutes = Time12.subtract(t1, t2);
        assertEquals(-730,minutes);


    }


    @Test
    public void t1LessT2Am()
    {
        Time12 t1 = null;
        Time12 t2 = null;
        try{
         t1 = new Time12(1,30,AmPm.am);
         t2 = new Time12(3,0,AmPm.am);
        }
        catch (Exception e){
            fail();
        }

        
    
        int minutes = Time12.subtract(t1, t2);
        assertEquals(-90,minutes);


    }

    @Test
    public void t1EqualT2_30Mins()
    {
        Time12 t1 = null;
        Time12 t2 = null;
        try{
         t1 = new Time12(3,30,AmPm.pm);
         t2 = new Time12(3,0,AmPm.pm);
        }
        catch (Exception e){
            fail();
        }

        
    
        int minutes = Time12.subtract(t1, t2);
        assertEquals(30,minutes);


    }

    @Test
    public void t1EqualT2_15Mins()
    {
        Time12 t1 = null;
        Time12 t2 = null;
        try{
         t1 = new Time12(3,30,AmPm.pm);
         t2 = new Time12(3,45,AmPm.pm);
        }
        catch (Exception e){
            fail();
        }

        
    
        int minutes = Time12.subtract(t1, t2);
        assertEquals(-15,minutes);


    }

    @Test
    public void t1GreaterT2_705()
    {
        Time12 t1 = null;
        Time12 t2 = null;
        try{
         t1 = new Time12(12,30,AmPm.pm);
         t2 = new Time12(12,45,AmPm.am);
        }
        catch (Exception e){
            fail();
        }

        
    
        int minutes = Time12.subtract(t1, t2);
        assertEquals(705,minutes);


    }


    @Test
    public void t1GreaterT2_750()
    {
        Time12 t1 = null;
        Time12 t2 = null;
        try{
         t1 = new Time12(12,30,AmPm.pm);
         t2 = new Time12(12,0,AmPm.am);
        }
        catch (Exception e){
            fail();
        }

        
    
        int minutes = Time12.subtract(t1, t2);
        assertEquals(750,minutes);


    }

}
