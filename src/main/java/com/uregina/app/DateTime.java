package com.uregina.app;

import com.uregina.exceptions.*;

/**
 * DateTime class that consists of a Date object and a Time12 object
 *
 */
public class DateTime 
{
	Time12 time; // 12-hour time
	Date date; 	 // MM/DD/YYYY 
    /** 
	 * constructor to initial Time24 object
	 * @param time 		12-hour time object (hh:mm am/pm)
	 * @param date		date object (MM/DD/YYYY)
	*/
	public DateTime(Date date,Time12 time)
    {
		this.date=date;
		this.time=time;
    }
	/**
	* returns the 12-hour part (hh:mm am/pm) of the DateTime  
	*/
	public Time12 getTime()
	{
		return time;
	}
	/**
	* returns The date part (MM/DD/YYYY) of the DateTime  
	*/
	public Date getDate()
	{
		return date;
	}
	/**
	 * subtract two DateTimes
	 * @param  d1	a DateTime object (MM/DD/YYYY  hh:mm am/pm)
	 * @param  d2	a DateTime object (MM/DD/YYYY  hh:mm am/pm)
	 * @return 		the value of (d1-d2) in minutes
	 * 				it may be a negative value
	 *				Throws MoreThanOneDayException if d1,d2 are not at the same date or
	 * 						not a consequative days.
	 * usefeul functions that you may use
	 * 		(class: Date , method: equal)
	 * 		(class: Time12 , method: subtract)
	 * 		(class: Date , method: nextDate)
	 */
	public static int subtract(DateTime d1,DateTime d2) throws MoreThanOneDayException
	{
		int diff=0;
		
		Date date1 = d1.getDate();
		Date date2 = d2.getDate();

		Time12 time1 = d1.getTime();
		Time12 time2 = d2.getTime();


		if(Date.equal(date1, date2)){
			diff = Time12.subtract(time1, time2);
		}
		else if(Date.equal(date1.nextDate(), date2)){
			diff = Time12.subtract(time1, time2) - 1440;
		}
		else if(Date.equal(date2.nextDate(), date1)){
			diff = Time12.subtract(time1, time2) + 1440;
		}
		else{
			throw new MoreThanOneDayException();
		}
		

		return diff;
	}
	/**
	 * Convert a DateTime object to string
	 * @param  None
	 * @return a string in the fromat MM/DD/YYYY hh:mm am/pm
	*/
	public String toString()
	{
		return date.toString()+" "+time.toString();
	}
	/**
	 * checks if a DateTime is before another one
	 * @param 	d1 a DateTime object
	 * @param 	d2 a DateTime object
	 * @return	true if d1<d2, false otherwise
	*/
	public static boolean lessThan(DateTime d1, DateTime d2)
	{
		return Date.lessThan(d1.date,d2.date) || ( Date.equal(d1.date,d2.date) && Time12.lessThan(d1.time,d2.time)) ;
	}
}
