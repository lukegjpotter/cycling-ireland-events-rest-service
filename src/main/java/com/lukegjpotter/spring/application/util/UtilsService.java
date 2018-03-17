package com.lukegjpotter.spring.application.util;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UtilsService {

    public Date convertYYYYMMDDToDate(String yyyymmddString) {
        
        try {
            return new SimpleDateFormat(Constants.DATE_FORMAT_YYYYMMDD).parse(yyyymmddString);
        } catch (ParseException e) {
            return null;
        }
    }

    public Date convertStringToDate(String string) {

        try {
            return new SimpleDateFormat(Constants.DATE_FORMAT).parse(string);
        } catch (ParseException e) {
            return null;
        }
    }

    public boolean convertStringToBoolean(String string) {

        Set<String> trueSet = new HashSet<>(Arrays.asList("yes", "1"));

        return string != null && !string.isEmpty() && trueSet.contains(string.toLowerCase());

    }

}
