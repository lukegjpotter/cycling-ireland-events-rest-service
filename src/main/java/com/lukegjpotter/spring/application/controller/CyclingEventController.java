package com.lukegjpotter.spring.application.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.repository.RoadRaceEventDatabaseRecordRepository;
import com.lukegjpotter.spring.application.service.CyclingEventService;
import com.lukegjpotter.spring.application.util.ControllerUtilsService;

@RestController
public class CyclingEventController {

	@Autowired private CyclingEventService cyclingEventService;
	@Autowired private RoadRaceEventDatabaseRecordRepository repository;
	@Autowired private ControllerUtilsService utils;

	@RequestMapping("/roadraces")
	public List<CyclingEventModel> getAllRoadRaces() {
		return cyclingEventService.getAllRoadRaces();
	}
	
	@RequestMapping("/roadraces/1")
    public RoadRaceEventDatabaseRecord getRoadRaceId1() {
        return repository.findOne(1L);
    }
	
	/**
	 * Get the road races between the two dates specified.
	 * 
	 * @param searchStartDate String in the form of yyyyMMdd e.g. 20160101 is Jan. 01 2016.
	 * @param searchEndDate String in the form of yyyyMMdd e.g. 20161231 is Dec. 31 2016.
	 * @return The List of {@code RoadRaceEventDatabaseRecord}s that are between the dates.
	 */
	@RequestMapping("/roadraces/between/{searchStartDate}/and/{searchEndDate}")
    public List<RoadRaceEventDatabaseRecord> getRoadRacesBetween(@PathVariable("searchStartDate") String searchStartDate, @PathVariable("searchEndDate") String searchEndDate) {
	    
	    Date startDate = utils.convertYYYYMMDDToDate(searchStartDate);
	    Date endDate = utils.convertYYYYMMDDToDate(searchEndDate);
        
	    return repository.findByStartDateBetween(startDate, endDate);
    }

	@Autowired
	public void setCyclingEventService(CyclingEventService cyclingEventService) {
		this.cyclingEventService = cyclingEventService;
	}
}
