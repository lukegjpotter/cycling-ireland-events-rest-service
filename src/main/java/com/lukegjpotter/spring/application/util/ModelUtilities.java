package com.lukegjpotter.spring.application.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ModelUtilities {

	public static Date convertStringtoDate(String string) {

		try {
			return new SimpleDateFormat(Constants.DATE_FORMAT).parse(string);
		} catch (ParseException e) {
			return null;
		}
	}

	public static boolean convertStringToBoolean(String string) {

		Set<String> trueSet = new HashSet<String>(Arrays.asList("yes", "1"));

		if (string != null && !string.isEmpty() && trueSet.contains(string.toLowerCase()))
			return true;

		return false;
	}

}
