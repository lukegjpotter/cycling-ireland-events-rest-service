package com.lukegjpotter.spring.application.datasource;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceModel;

@Component
public class InMemoryCyclingEventDataSource implements CyclingEventDataSource {

	// The Instance
	private static CyclingEventDataSource instance;

	// Lists of Event Types
	private static List<CyclingEventModel> roadRaces;

	public static CyclingEventDataSource getInstance() {

		if (instance == null)
			instance = new InMemoryCyclingEventDataSource();

		return instance;
	}
	
	private InMemoryCyclingEventDataSource() {
	}

	@PostConstruct
	public static void populateRoadRacesMap() {

		roadRaces = new ArrayList<CyclingEventModel>();

		roadRaces.add(new RoadRaceModel("Luke GJ Cup", "14/02/2016", "", "Sunday", "Leinster", "Road", "Road", "Yes",
				"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", 0, "Luke GJ Potter", "lukegjpotter@mail.com",
				"Luke GJ CC", "100.00", "Lukestown Community Centre", "11.30"));
	}

	public List<CyclingEventModel> getAllRoadRaces() {

		return roadRaces;
	}
}