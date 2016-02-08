package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class UtilitiesTest {

	@Test
	public void testConvertProperDateStringtoDate() {

		String expectedDateString = "01/01/2001";
		Date expected = null;

		try {
			expected = new SimpleDateFormat(Constants.DATE_FORMAT).parse(expectedDateString);
		} catch (ParseException e) {
		}

		Date actual = Utilities.convertStringtoDate(expectedDateString);

		assertEquals(expected, actual);
	}

	@Test
	public void testConvertEmptyStringtoDate() {

		String expectedDateString = "";
		Date expected = null;

		try {
			expected = new SimpleDateFormat(Constants.DATE_FORMAT).parse(expectedDateString);
		} catch (ParseException e) {
		}

		Date actual = Utilities.convertStringtoDate(expectedDateString);

		assertEquals(expected, actual);
	}

	@Test
	public void testConvertYesStringToBoolean() {
		assertTrue(Utilities.convertStringToBoolean("Yes"));
	}

	@Test
	public void testConvertEmptyStringToBoolean() {
		assertFalse(Utilities.convertStringToBoolean(""));
	}

	@Test
	public void testConvertOneIntegerToBoolean() {
		assertTrue(Utilities.convertStringToBoolean(new Integer(1).toString()));
	}

	@Test
	public void testConvertZeroIntegerToBoolean() {
		assertFalse(Utilities.convertStringToBoolean(new Integer(0).toString()));
	}
}