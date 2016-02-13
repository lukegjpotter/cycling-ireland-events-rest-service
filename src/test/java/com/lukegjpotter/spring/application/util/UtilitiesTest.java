package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class, Utilities.class })
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