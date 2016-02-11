package com.lukegjpotter.spring.application.datasource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.service.CsvFileReaderService;

public class InMemoryCyclingEventDataSourceTest {

	private InMemoryCyclingEventDataSource cyclingEventDataSource;
	RoadRaceModel lukeGjCupRoadRace;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		lukeGjCupRoadRace = new RoadRaceModel("Luke GJ Cup", "14/02/2016", "", "Sunday", "Leinster", "Road", "Road",
				"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", 0, "Luke GJ Potter", "lukegjpotter@mail.com",
				"Luke GJ CC", "100.00", "Lukestown Community Centre", "11.30");
		List<CyclingEventModel> roadRaces = new ArrayList<>();
		roadRaces.add(lukeGjCupRoadRace);

		CsvFileReaderService csvFileReaderService = Mockito.mock(CsvFileReaderService.class);
		Mockito.when(csvFileReaderService.readRoadRaces()).thenReturn(roadRaces);

		cyclingEventDataSource = new InMemoryCyclingEventDataSource();
		cyclingEventDataSource.setCsvFileReaderService(csvFileReaderService);
		cyclingEventDataSource.populateRoadRacesMap();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllRoadRacesWithOneRace() {
		assertEquals(1, cyclingEventDataSource.getAllRoadRaces().size());
	}

	@Test
	public void testGetAllRoadRacesWithHardCodedLukeGJCupRace() {
		assertTrue(cyclingEventDataSource.getAllRoadRaces().contains(lukeGjCupRoadRace));
	}

}
