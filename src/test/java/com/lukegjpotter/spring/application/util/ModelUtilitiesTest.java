package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class, ModelUtilities.class })
public class ModelUtilitiesTest {
    
    @Autowired ModelUtilities utils;

	@Test public void testConvertProperDateStringtoDate() {

		Date expected = new Date(1451606400000L);

		String expectedDateString = "01/01/2016";
		Date actual = utils.convertStringtoDate(expectedDateString);

		assertEquals(expected, actual);
	}

	@Test public void testConvertEmptyStringtoDate() {

		Date expected = null;

		String expectedDateString = "";
		Date actual = utils.convertStringtoDate(expectedDateString);

		assertEquals(expected, actual);
	}

	@Test public void testConvertYesStringToBoolean() {
		assertTrue(utils.convertStringToBoolean("Yes"));
	}

	@Test public void testConvertEmptyStringToBoolean() {
		assertFalse(utils.convertStringToBoolean(""));
	}

	@Test public void testConvertOneIntegerToBoolean() {
		assertTrue(utils.convertStringToBoolean(new Integer(1).toString()));
	}

	@Test public void testConvertZeroIntegerToBoolean() {
		assertFalse(utils.convertStringToBoolean(new Integer(0).toString()));
	}
}