package com.lukegjpotter.spring.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.repository.RoadRaceEventDatabaseRecordRepository;
import com.lukegjpotter.spring.application.service.CyclingEventService;

@RestController
public class CyclingEventController {

	@Autowired private CyclingEventService cyclingEventService;
	@Autowired private RoadRaceEventDatabaseRecordRepository repository;

	@RequestMapping("/roadraces")
	public List<CyclingEventModel> getAllRoadRaces() {
		return cyclingEventService.getAllRoadRaces();
	}
	
	@RequestMapping("/roadraces/1")
    public RoadRaceEventDatabaseRecord getRoadRaceId1() {
        return repository.findOne(1L);
    }

	@Autowired
	public void setCyclingEventService(CyclingEventService cyclingEventService) {
		this.cyclingEventService = cyclingEventService;
	}
}
