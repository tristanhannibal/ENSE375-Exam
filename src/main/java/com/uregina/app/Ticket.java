package com.uregina.app;

import com.uregina.exceptions.*;
import java.util.*;
import java.util.Arrays;
/**
 * Class Ticket, a List of Flights in ordered sequences
 *
 */
public class Ticket
{
	
	private static final String [] SchengenAirportsCode = new String[] { "VIE","BRU","PRG","CPH","TLL","HEL","CDG","FRA","MUC","ATH","BUD","KEF","CIA","RIX","VNO","LUX","MLA","AMS","OSL","WAW","LIS","LJU","KSC","MAD","ARN","BRN"};
	/**
	 * The function checks the validaity of a ticket
	 * It checks
	 *		1. airports code are in IATA format (any three uppercases letters)
	 *		2. maximum flights Count <= number of flights in the ticket
	 *		3. maximum flight time <= Total flight times ( sum of flight time of each flight)
	 *		4. maximum layover time <= Total layover times ( sum of layover time between each consequative flight)
	 *		5. no flight between two airports in the Schengen area unless the passenger has a valid SchengenVisa
	 *		6. no cyclic trip
	 *		7. The sequence of flights in correct ( the arrival airport of a flight is the departure airport of the next flight)
	 * 		8. any other logical constraints 
	 * @param	ticket				List of ordered sequences of flights
	 * @param	maxFlightsCount		Maximum number of flights in the ticket
	 * @param	maxFlightTime		Maximum allowable total flight times in minutes
	 * @param	maxLayoverTime		Maximum allowable total layover times in minutes
	 * @param	hasSchengenVisa		to indicate if the passenger has a valid Schengen Visa or not
	 * @return	true if the ticket is valid, false otherwise
	 * usefeul functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	 * 		(class: Flight , method: calculateFlightTime)
	 * 		(class: Flight , method: calculateLayoverTime)
	 * 		(class: ticket , method: hasCyclicTrip)
	*/
	public static boolean checkTicket( ArrayList<Flight> ticket, int maxFlightsCount, int maxFlightTime, int maxLayoverTime, boolean hasSchengenVisa)
	{


		List<String> schegen = Arrays.asList(SchengenAirportsCode);

		if(ticket.size() > maxFlightsCount) return false;

		int currFlightTime = 0;
		int currLayOverTime = 0;


		for(int i = 0; i < ticket.size(); i++){
			try{
				if(!(ticket.get(i).getDepatureAirport().matches("^[A-Z]{3}$")) || !(ticket.get(i).getDepatureAirport().matches("^[A-Z]{3}$"))) return false;

				currFlightTime += ticket.get(i).calculateFlightTime();
				if (currFlightTime > maxFlightTime) return false;
				
				if(i+1 < ticket.size()){
					Flight currTicket = ticket.get(i);
					Flight nextTicket = ticket.get(i+1);
					if(!(currTicket.getArrivalAirport().equals(nextTicket.getDepatureAirport()))) return false;
					currLayOverTime += Flight.calculateLayoverTime(currTicket, nextTicket);
					if(schegen.contains(currTicket.getDepatureAirport()) 
					&& schegen.contains(nextTicket.getArrivalAirport()) 
					&& hasSchengenVisa == false){
						return false;
					}
				}
			} catch(Exception e){
				return false;
			}
		}
		//end of your code
		return true;
	}
		/**
	 * The function checks if the ticket has a cyclic trip
	 * (that is, no passenger can arrive at the same airport more than once within the same ticket)
	 * @param	ticket				List of ordered sequences of flights
	 * @return	true if the ticket has a cyclic trip, false otherwise
	 * usefeul functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	*/
	public static boolean hasCyclicTrip(ArrayList<Flight> ticket)
	{
		if(ticket.size() <= 1) return false;

		String firstAirport = ticket.get(0).getDepatureAirport();

		Set<String> arrivalSet = new HashSet<String>();
		for(int i =0; i < ticket.size(); i++){
			Flight flight = ticket.get(i);
			if(arrivalSet.contains(flight.getArrivalAirport())){
				return true;
			} else{
				arrivalSet.add(flight.getArrivalAirport());
			}

		}

		return false;
	}
}