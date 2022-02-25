package com.tests.utilities;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RandomUtils {

	private static final SecureRandom random = new SecureRandom();

	public static String generateRandomString(int length) {

		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {

			sb.append(text.charAt(random.nextInt(text.length())));

		}

		return sb.toString();

	}

	public static int generateRandomNumber(int length) {

		String number = "0123456789";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {

			sb.append(number.charAt(random.nextInt(number.length())));

		}

		int random = Integer.valueOf(sb.toString());

		return random;

	}

	public static String createRandomDateTimeValue() {

		LocalDate localdate = LocalDate.now();
		int day = localdate.getDayOfMonth();
		String month = localdate.getMonth().toString().substring(0, 3);
		int year = localdate.getYear();
		String date = String.valueOf(day) + month + String.valueOf(year);

		LocalTime timevalue = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
		String time = timevalue.format(formatter);

		String datetimevalue = date + "_" + time;

		return datetimevalue;

	}

	public static String generateDate(int x) {

		LocalDate datevalue = LocalDate.now();
		String date = String.valueOf(datevalue.plusDays(x));
		return date;

	}

}