package com.lukegjpotter.spring.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.datasource.CyclingEventDataSource;
import com.lukegjpotter.spring.application.datasource.InMemoryCyclingEventDataSource;
import com.lukegjpotter.spring.application.model.CyclingEventModel;

@Service("cyclingEventsService")
public class CyclingEventService {

	private CyclingEventDataSource cyclingEventDataSource;

	public CyclingEventService() {
		cyclingEventDataSource = InMemoryCyclingEventDataSource.getInstance();
	}

	public List<CyclingEventModel> getAllRoadRaces() {

		return cyclingEventDataSource.getAllRoadRaces();
	}
}