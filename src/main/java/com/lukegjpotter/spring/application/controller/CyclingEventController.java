package com.lukegjpotter.spring.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.service.CyclingEventService;

@RestController
public class CyclingEventController {

	private CyclingEventService cyclingEventService;

	@RequestMapping("/roadraces")
	public List<CyclingEventModel> getAllRoadRaces() {
		return cyclingEventService.getAllRoadRaces();
	}

	@Autowired
	public void setCyclingEventService(CyclingEventService cyclingEventService) {
		this.cyclingEventService = cyclingEventService;
	}
}
