package com.lukegjpotter.spring.application.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

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
import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.service.CyclingEventService;
import com.lukegjpotter.spring.application.testresources.TestResources;
import com.lukegjpotter.spring.application.util.UtilsService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class, CyclingEventController.class })
public class CyclingEventControllerTest {

	@InjectMocks private CyclingEventController cyclingEventController;
	@Mock private CyclingEventService cyclingEventService;
	List<CyclingEventModel> roadRaces;
	
	@Autowired UtilsService utils;
	@Autowired TestResources tr;

	@Before
	public void setUp() {
	    roadRaces = tr.getRoadRaceList();
	    MockitoAnnotations.initMocks(this);
		when(cyclingEventService.getAllRoadRaces()).thenReturn(roadRaces);
	}

	@Test public void testGetAllRoadRaces() throws Exception {
		assertEquals(roadRaces, cyclingEventController.getAllRoadRaces());
	}

}
