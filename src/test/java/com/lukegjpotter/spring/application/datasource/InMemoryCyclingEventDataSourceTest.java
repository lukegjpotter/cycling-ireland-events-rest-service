package com.lukegjpotter.spring.application.datasource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;
import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.service.CsvFileReaderService;
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class, InMemoryCyclingEventDataSource.class })
public class InMemoryCyclingEventDataSourceTest {

	@InjectMocks private InMemoryCyclingEventDataSource cyclingEventDataSource;
	@Mock CsvFileReaderService csvFileReaderService;
	RoadRaceModel lukeGjCupRoadRace;
	
	@Autowired TestResources tr;

	@Before public void setUp() throws Exception {

	    lukeGjCupRoadRace = tr.getRoadRace();
	    MockitoAnnotations.initMocks(this);
	    when(csvFileReaderService.readRoadRaces()).thenReturn(tr.getRoadRaceList());
	}

	@Test public void testGetAllRoadRacesWithOneRace() {
		assertEquals(1, cyclingEventDataSource.getAllRoadRaces().size());
	}

	@Test public void testGetAllRoadRacesWithHardCodedLukeGJCupRace() {
		assertTrue(cyclingEventDataSource.getAllRoadRaces().contains(lukeGjCupRoadRace));
	}

}
