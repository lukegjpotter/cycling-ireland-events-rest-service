package com.lukegjpotter.spring.application.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ControllerUtilsService {

    public Date convertYYYYMMDDToDate(String yyyymmddString) {
        
        try {
            return new SimpleDateFormat(Constants.DATE_FORMAT_YYYYMMDD).parse(yyyymmddString);
        } catch (ParseException e) {
            return null;
        }
    }

}
