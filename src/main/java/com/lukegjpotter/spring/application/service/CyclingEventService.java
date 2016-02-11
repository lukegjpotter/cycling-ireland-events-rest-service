package com.lukegjpotter.spring.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.datasource.CyclingEventDataSource;
import com.lukegjpotter.spring.application.model.CyclingEventModel;

@Service("cyclingEventsService")
public class CyclingEventService {

	private CyclingEventDataSource cyclingEventDataSource;

	public List<CyclingEventModel> getAllRoadRaces() {
		return cyclingEventDataSource.getAllRoadRaces();
	}

	@Autowired
	public void setCyclingEventDataSource(CyclingEventDataSource cyclingEventDataSource) {
		this.cyclingEventDataSource = cyclingEventDataSource;
	}
}