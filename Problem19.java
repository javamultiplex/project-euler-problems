package com.javamultiplex.projecteuler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 19 - Counting Sundays.
 *
 */
public class Problem19 {

	public static final String format = "dd/MM/yyyy";

	public static void main(String[] args) throws ParseException {

		String target = "31/12/2000";
		DateFormat dateFormat = new SimpleDateFormat(format);
		int dayofMonth = 1;
		int month = 1;
		int year = 1901;
		int day = 0;
		int count = 0;
		// Converting String to Date.
		Date targetDate = dateFormat.parse(target);
		// Creating Calendar class instance.
		Calendar calendar = Calendar.getInstance();
		// Setting Calendar Day_OF_MONTH =1, MONTH = 0, YEAR=1901
		calendar.set(Calendar.DAY_OF_MONTH, dayofMonth);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.YEAR, year);
		// Converting Calendar to Date.
		Date myDate = calendar.getTime();
		// Comparing two dates.
		while (myDate.compareTo(targetDate) < 0) {

			day = calendar.get(Calendar.DAY_OF_WEEK);
			// calendar.get(Calendar.DAY_OF_WEEK) = 1 (Sunday)
			if (day == 1) {
				count++;
			}
			month++;
			/*
			 * If month value is 13 then we have to increment value of Year and reset Month=1
			 * then set MONTH and YEAR in Calendar accordingly.
			 * Otherwise set the incremented value of month to Calendar. 
			 * 
			 */
			if (month == 13) {
				year++;
				month = 1;
				calendar.set(Calendar.MONTH, month - 1);
				calendar.set(Calendar.YEAR, year);
			} else {
				calendar.set(Calendar.MONTH, month - 1);
			}
			myDate = calendar.getTime();
		}
		System.out.println("Number of Sundays : "+count);

	}

}
