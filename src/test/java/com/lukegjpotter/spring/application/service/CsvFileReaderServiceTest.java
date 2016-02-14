package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;
import com.lukegjpotter.spring.application.model.RoadRaceModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class,
		CsvFileReaderService.class })
public class CsvFileReaderServiceTest {

	@Autowired
	CsvFileReaderService csvFileReaderService;
	RoadRaceModel expectedRoadRace;

	@Test
	public void testReadCsvFile() {
		expectedRoadRace = new RoadRaceModel("Luke GJ GP", "07/05/2016", "", "Saturday", "Leinster", "Road", "Road", "",
				"", "", "Yes", "Yes", "", "Yes", "Yes", 0, "Luke Campbell", "lukecampbell1@hotmail.com",
				"Luke GJ Wheelers", "68.00", "Luke GJ GAA", "9.00");
		String testCsvFileWithoutCommaInHqLocationLocation = "src/test/resources/RoadRacesTest.csv";
		csvFileReaderService.setCsvFileLocation(testCsvFileWithoutCommaInHqLocationLocation);
		assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
	}

	@Test
	public void testReadCsvFileWithCommaInHqLocation() {
		expectedRoadRace = new RoadRaceModel("Luke GJ GP", "07/05/2016", "", "Saturday", "Leinster", "Road", "Road", "",
				"", "", "Yes", "Yes", "", "Yes", "Yes", 0, "Luke Campbell", "lukecampbell1@hotmail.com",
				"Luke GJ Wheelers", "68.00", "Luke GJ, GAA", "9.00");
		String testCsvFileWithCommaInHqLocationLocation = "src/test/resources/RoadRacesTestCommaInHqLocation.csv";
		csvFileReaderService.setCsvFileLocation(testCsvFileWithCommaInHqLocationLocation);
		assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
	}

	@Test
	public void testReadCsvFileWithCommaAndCountyInHqLocation() {
		expectedRoadRace = new RoadRaceModel("Luke GJ GP", "07/05/2016", "", "Saturday", "Leinster", "Road", "Road", "",
				"", "", "Yes", "Yes", "", "Yes", "Yes", 0, "Luke Campbell", "lukecampbell1@hotmail.com",
				"Luke GJ Wheelers", "68.00", "Luke GJ, GAA, Co. Lukin", "9.00");
		String testCsvFileWithCommaAndCountyInHqLocation = "src/test/resources/RoadRacesTestCommaAndCountyInHqLocation.csv";
		csvFileReaderService.setCsvFileLocation(testCsvFileWithCommaAndCountyInHqLocation);
		assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
	}

	@Test
	public void testReadCsvFileWithNorthernIrelandHqLocation() {
		expectedRoadRace = new RoadRaceModel("Luke GJ GP", "07/05/2016", "", "Saturday", "Leinster", "Road", "Road", "",
				"", "", "Yes", "Yes", "", "Yes", "Yes", 0, "Luke Campbell", "lukecampbell1@hotmail.com",
				"Luke GJ Wheelers", "68.00", "Luke GJ, GAA Pitch, Luke Rd., Co. Lukin, BT12 4DB", "9.00");
		String testCsvFileWithNorthernIrelandHqLocation = "src/test/resources/RoadRacesTestNorthernIrelandHqLocation.csv";
		csvFileReaderService.setCsvFileLocation(testCsvFileWithNorthernIrelandHqLocation);
		assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
	}
}
