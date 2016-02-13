package com.lukegjpotter.spring.application.datasource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;
import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.service.CsvFileReaderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class,
		InMemoryCyclingEventDataSource.class })
public class InMemoryCyclingEventDataSourceTest {

	@Autowired
	private InMemoryCyclingEventDataSource cyclingEventDataSource;
	@Autowired
	CsvFileReaderService csvFileReaderService;
	RoadRaceModel lukeGjCupRoadRace;

	@Before
	public void setUp() throws Exception {

		lukeGjCupRoadRace = new RoadRaceModel("Luke GJ Cup", "14/02/2016", "", "Sunday", "Leinster", "Road", "Road",
				"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", 0, "Luke GJ Potter", "lukegjpotter@mail.com",
				"Luke GJ CC", "100.00", "Lukestown Community Centre", "11.30");
		List<CyclingEventModel> roadRaces = new ArrayList<>();
		roadRaces.add(lukeGjCupRoadRace);

		csvFileReaderService = Mockito.mock(CsvFileReaderService.class);
		Mockito.when(csvFileReaderService.readRoadRaces()).thenReturn(roadRaces);

		cyclingEventDataSource.setCsvFileReaderService(csvFileReaderService);
		cyclingEventDataSource.populateRoadRacesMap();
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
