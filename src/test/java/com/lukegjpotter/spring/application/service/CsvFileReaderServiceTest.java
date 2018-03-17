package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.testresources.TestResources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CsvFileReaderServiceTest {

    @Autowired
    private CsvFileReaderService csvFileReaderService;
    private RoadRaceModel expectedRoadRace;

    @Autowired
    private TestResources tr;

    @Test
    public void testReadCsvFile() {
        expectedRoadRace = tr.getRoadRaceLukeGjGp();
        String testCsvFileWithoutCommaInHqLocationLocation = "src/test/resources/RoadRacesTest.csv";
        csvFileReaderService.setCsvFileLocation(testCsvFileWithoutCommaInHqLocationLocation);
        assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
    }

    @Test
    public void testReadCsvFileWithCommaInHqLocation() {
        expectedRoadRace = tr.getRoadRaceLukeGjGp();
        expectedRoadRace.sethQLocation("Luke GJ, GAA");
        String testCsvFileWithCommaInHqLocationLocation = "src/test/resources/RoadRacesTestCommaInHqLocation.csv";
        csvFileReaderService.setCsvFileLocation(testCsvFileWithCommaInHqLocationLocation);
        assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
    }

    @Test
    public void testReadCsvFileWithCommaAndCountyInHqLocation() {
        expectedRoadRace = tr.getRoadRaceLukeGjGp();
        expectedRoadRace.sethQLocation("Luke GJ, GAA, Co. Lukin");
        String testCsvFileWithCommaAndCountyInHqLocation = "src/test/resources/RoadRacesTestCommaAndCountyInHqLocation.csv";
        csvFileReaderService.setCsvFileLocation(testCsvFileWithCommaAndCountyInHqLocation);
        assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
    }

    @Test
    public void testReadCsvFileWithNorthernIrelandHqLocation() {
        expectedRoadRace = tr.getRoadRaceLukeGjGp();
        expectedRoadRace.sethQLocation("Luke GJ, GAA Pitch, Luke Rd., Co. Lukin, BT12 4DB");
        String testCsvFileWithNorthernIrelandHqLocation = "src/test/resources/RoadRacesTestNorthernIrelandHqLocation.csv";
        csvFileReaderService.setCsvFileLocation(testCsvFileWithNorthernIrelandHqLocation);
        assertEquals(expectedRoadRace, csvFileReaderService.readRoadRaces().get(0));
    }
}
