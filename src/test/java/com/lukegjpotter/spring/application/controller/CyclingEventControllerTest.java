package com.lukegjpotter.spring.application.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;
import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.service.CyclingEventService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class,
		CyclingEventController.class })
public class CyclingEventControllerTest {

	@Autowired
	private CyclingEventController cyclingEventController;
	@Autowired
	private CyclingEventService cyclingEventService;
	List<CyclingEventModel> roadRaces;

	@Before
	public void setUp() {

		roadRaces = new ArrayList<>();
		roadRaces.add(new RoadRaceModel("Luke GJ Cup", "14/02/2016", "", "Sunday", "Leinster", "Road", "Road", "Yes",
				"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", 0, "Luke GJ Potter", "lukegjpotter@mail.com",
				"Luke GJ CC", "100.00", "Lukestown Community Centre", "11.30"));

		cyclingEventService = mock(CyclingEventService.class);
		when(cyclingEventService.getAllRoadRaces()).thenReturn(roadRaces);

		cyclingEventController.setCyclingEventService(cyclingEventService);
	}

	@Test
	public void testGetAllRoadRaces() throws Exception {
		assertEquals(roadRaces, cyclingEventController.getAllRoadRaces());
	}

}
