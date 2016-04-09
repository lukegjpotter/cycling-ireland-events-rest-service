package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;
import com.lukegjpotter.spring.application.datasource.CyclingEventDataSource;
import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class,
		CyclingEventService.class })
public class CyclingEventServiceTest {

	@InjectMocks
	private CyclingEventService cyclingEventService;
	@Mock
	private CyclingEventDataSource cyclingEventDataSource;
	private List<CyclingEventModel> roadRaces;

	@Before
	public void setUp() {
	    
	    MockitoAnnotations.initMocks(this);
		roadRaces = new ArrayList<>();
		roadRaces.add(new RoadRaceModel("Luke GJ Cup", "14/02/2016", "", "Sunday", "Leinster", "Road", "Road", "Yes",
				"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", 0, "Luke GJ Potter", "lukegjpotter@mail.com",
				"Luke GJ CC", "100.00", "Lukestown Community Centre", "11.30"));

		when(cyclingEventDataSource.getAllRoadRaces()).thenReturn(roadRaces);

		cyclingEventService.setCyclingEventDataSource(cyclingEventDataSource);
	}

	@Test
	public void test() {
		assertTrue(cyclingEventService.getAllRoadRaces().equals(roadRaces));
	}

}