package com.lukegjpotter.spring.application.controller;

import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.repository.RoadRaceEventDatabaseRecordRepository;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CyclingEventController {

	@Autowired private RoadRaceEventDatabaseRecordRepository repository;
	@Autowired private UtilsService utils;

	@GetMapping("/roadraces/1")
    public Optional<RoadRaceEventDatabaseRecord> getRoadRaceId1() {
        return repository.findById(1L);
    }
	
	/**
	 * Get the road races between the two dates specified.
	 * 
	 * @param searchStartDate String in the form of yyyyMMdd e.g. 20160101 is Jan. 01 2016.
	 * @param searchEndDate String in the form of yyyyMMdd e.g. 20161231 is Dec. 31 2016.
	 * @return The List of {@code RoadRaceEventDatabaseRecord}s that are between the dates.
	 */
	@GetMapping("/roadraces/between/{searchStartDate}/and/{searchEndDate}")
    public List<RoadRaceEventDatabaseRecord> getRoadRacesBetween(@PathVariable("searchStartDate") String searchStartDate, @PathVariable("searchEndDate") String searchEndDate) {
	    
	    Date startDate = utils.convertYYYYMMDDToDate(searchStartDate);
	    Date endDate = utils.convertYYYYMMDDToDate(searchEndDate);
        
	    return repository.findByStartDateBetween(startDate, endDate);
    }

	@GetMapping("/roadraces/month/{monthNumber}")
	public List<RoadRaceEventDatabaseRecord> getRoadRacesInMonthNumber(@PathVariable("monthNumber") int monthNumber) {
	    
	    return repository.findByMonthNumber(monthNumber);
	}
}
