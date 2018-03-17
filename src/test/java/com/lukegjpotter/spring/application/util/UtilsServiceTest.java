package com.lukegjpotter.spring.application.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UtilsServiceTest {

    @Autowired
    private UtilsService utils;

    @Test public void testConvertProperDateYYYYMMDDStringtoDate() {

        Date expected = new Date(1451606400000L);

        String expectedDateString = "20160101";
        Date actual = utils.convertYYYYMMDDToDate(expectedDateString);

        assertEquals(expected, actual);
    }

    @Test public void testConvertEmptyYYYYMMDDStringtoDate() {

        String expectedDateString = "";
        Date actual = utils.convertYYYYMMDDToDate(expectedDateString);

        assertEquals(actual, null);
    }

    @Test
    public void testConvertProperDateStringToDate() {

        Date expected = new Date(1451606400000L);

        String expectedDateString = "01/01/2016";
        Date actual = utils.convertStringToDate(expectedDateString);

        assertEquals(expected, actual);
    }

    @Test
    public void testConvertEmptyStringToDate() {

        String expectedDateString = "";
        Date actual = utils.convertStringToDate(expectedDateString);

        assertEquals(actual, null);
    }

    @Test
    public void testConvertYesStringToBoolean() {
        assertTrue(utils.convertStringToBoolean("Yes"));
    }

    @Test
    public void testConvertEmptyStringToBoolean() {
        assertFalse(utils.convertStringToBoolean(""));
    }

    @Test
    public void testConvertOneIntegerToBoolean() {
        assertTrue(utils.convertStringToBoolean(Integer.toString(1)));
    }

    @Test
    public void testConvertZeroIntegerToBoolean() {
        assertFalse(utils.convertStringToBoolean(Integer.toString(0)));
    }
}