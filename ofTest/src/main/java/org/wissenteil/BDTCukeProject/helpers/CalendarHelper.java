package org.wissenteil.BDTCukeProject.helpers;

import java.util.Calendar;

public class CalendarHelper {

	/**
	 * @return last Sunday
	 */
	public static int getLastSunday() {
		Calendar cal=Calendar.getInstance();
		cal.add( Calendar.DAY_OF_WEEK, -(cal.get(Calendar.DAY_OF_WEEK)-1)); 
		return cal.get(Calendar.DATE);
	}

}
