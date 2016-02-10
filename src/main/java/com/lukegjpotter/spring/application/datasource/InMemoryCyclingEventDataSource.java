package com.lukegjpotter.spring.application.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.service.CsvFileReaderService;

@Component
public class InMemoryCyclingEventDataSource implements CyclingEventDataSource {

	private static final Logger log = Logger.getLogger(InMemoryCyclingEventDataSource.class.getName());

	// The Instance
	private static CyclingEventDataSource instance;

	private CsvFileReaderService csvFileReaderService;

	// Lists of Event Types
	private static List<CyclingEventModel> roadRaces;

	public static CyclingEventDataSource getInstance() {

		if (instance == null)
			instance = new InMemoryCyclingEventDataSource();

		return instance;
	}

	private InMemoryCyclingEventDataSource() {
		roadRaces = new ArrayList<>();
	}

	@PostConstruct
	public void populateRoadRacesMap() {

		log.info("Populating the Road Races Map");
		roadRaces = csvFileReaderService.readRoadRaces();
		log.info("Populated the Road Races Map. Number of Enteries is " + roadRaces.size());
	}

	public List<CyclingEventModel> getAllRoadRaces() {

		return roadRaces;
	}

	@Autowired
	public void setCsvFileReaderService(CsvFileReaderService csvFileReaderService) {
		this.csvFileReaderService = csvFileReaderService;
	}
}