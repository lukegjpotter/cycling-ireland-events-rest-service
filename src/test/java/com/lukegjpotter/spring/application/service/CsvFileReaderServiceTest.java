package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;
import com.lukegjpotter.spring.application.model.RoadRaceModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class, CsvFileReaderService.class})
public class CsvFileReaderServiceTest {

	@Autowired
	CsvFileReaderService csvFileReaderService;
	RoadRaceModel roadRace;
	String testCsvFileLocation = "src/test/resources/RoadRacesTest.csv";

	@Before
	public void setUp() throws Exception {
		roadRace = new RoadRaceModel("Luke GJ GP", "07/05/2016", "", "Saturday", "Leinster", "Road", "Road", "", "", "",
				"Yes", "Yes", "", "Yes", "Yes", 0, "Luke Campbell", "lukecampbell1@hotmail.com", "Luke GJ Wheelers",
				"68.00", "Luke GJ GAA", "9.00");
		csvFileReaderService.setCsvFileLocation(testCsvFileLocation);
	}

	@Test
	public void testReadCsvFile() {
		assertTrue(csvFileReaderService.readRoadRaces().contains(roadRace));
	}

}
