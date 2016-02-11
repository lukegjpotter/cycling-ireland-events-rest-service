package com.lukegjpotter.spring.application.controller;

import static org.junit.Assert.assertEquals;

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
import com.lukegjpotter.spring.application.service.CyclingEventService;

public class CyclingEventControllerTest {

	private CyclingEventController cyclingEventController;
	private List<CyclingEventModel> roadRaces;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		roadRaces = new ArrayList<>();
		roadRaces.add(new RoadRaceModel("Luke GJ Cup", "14/02/2016", "", "Sunday", "Leinster", "Road", "Road", "Yes",
				"Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", 0, "Luke GJ Potter", "lukegjpotter@mail.com",
				"Luke GJ CC", "100.00", "Lukestown Community Centre", "11.30"));

		CyclingEventService cyclingEventService = Mockito.mock(CyclingEventService.class);
		Mockito.when(cyclingEventService.getAllRoadRaces()).thenReturn(roadRaces);

		cyclingEventController = new CyclingEventController(cyclingEventService);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllRoadRaces() {
		assertEquals(roadRaces, cyclingEventController.getAllRoadRaces());
	}

}
