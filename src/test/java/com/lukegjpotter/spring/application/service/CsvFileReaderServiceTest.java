package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;
import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class, CsvFileReaderService.class })
public class CsvFileReaderServiceTest {

	@Autowired CsvFileReaderService csvFileReaderService;
	RoadRaceModel expectedRoadRace;
	
	@Autowired TestResources tr;

	@Test public void testReadCsvFile() {
		expectedRoadRace = tr.getRoadRaceLukeGjGp();
		String testCsvFileWithoutCommaInHqLocationLocation = "src/test/resources/RoadRacesTest.csv";
		csvFileReaderService.setCsvFileLocation(testCsvFileWithoutCommaInHqLocationLocation);
		assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
	}

	@Test public void testReadCsvFileWithCommaInHqLocation() {
		expectedRoadRace = tr.getRoadRaceLukeGjGp();
		expectedRoadRace.sethQLocation("Luke GJ, GAA");
		String testCsvFileWithCommaInHqLocationLocation = "src/test/resources/RoadRacesTestCommaInHqLocation.csv";
		csvFileReaderService.setCsvFileLocation(testCsvFileWithCommaInHqLocationLocation);
		assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
	}

	@Test public void testReadCsvFileWithCommaAndCountyInHqLocation() {
	    expectedRoadRace = tr.getRoadRaceLukeGjGp();
		expectedRoadRace.sethQLocation("Luke GJ, GAA, Co. Lukin");
		String testCsvFileWithCommaAndCountyInHqLocation = "src/test/resources/RoadRacesTestCommaAndCountyInHqLocation.csv";
		csvFileReaderService.setCsvFileLocation(testCsvFileWithCommaAndCountyInHqLocation);
		assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
	}

	@Test public void testReadCsvFileWithNorthernIrelandHqLocation() {
	    expectedRoadRace = tr.getRoadRaceLukeGjGp();
		expectedRoadRace.sethQLocation("Luke GJ, GAA Pitch, Luke Rd., Co. Lukin, BT12 4DB");
		String testCsvFileWithNorthernIrelandHqLocation = "src/test/resources/RoadRacesTestNorthernIrelandHqLocation.csv";
		csvFileReaderService.setCsvFileLocation(testCsvFileWithNorthernIrelandHqLocation);
		assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
	}
}
