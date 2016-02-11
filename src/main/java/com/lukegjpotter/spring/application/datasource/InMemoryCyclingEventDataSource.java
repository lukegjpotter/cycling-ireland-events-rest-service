package com.lukegjpotter.spring.application.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.service.CsvFileReaderService;

@Repository
@Scope("singleton")
public class InMemoryCyclingEventDataSource implements CyclingEventDataSource {

	private static final Logger log = Logger.getLogger(InMemoryCyclingEventDataSource.class.getName());

	private CsvFileReaderService csvFileReaderService;

	// Lists of Event Types
	private static List<CyclingEventModel> roadRaces;

	@PostConstruct
	public void populateRoadRacesMap() {

		roadRaces = new ArrayList<>();
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