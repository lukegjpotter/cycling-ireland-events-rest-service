package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;
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
import com.lukegjpotter.spring.application.datasource.CyclingEventDataSource;
import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class, CyclingEventService.class })
public class CyclingEventServiceTest {

	@InjectMocks private CyclingEventService cyclingEventService;
	@Mock private CyclingEventDataSource cyclingEventDataSource;
	private List<CyclingEventModel> roadRaces;
	
	@Autowired TestResources tr;

	@Before public void setUp() {
	    
	    roadRaces = tr.getRoadRaceList();
	    MockitoAnnotations.initMocks(this);
	    when(cyclingEventDataSource.getAllRoadRaces()).thenReturn(roadRaces);
	}

	@Test public void testGetAllRoadRaces() {
		assertTrue(cyclingEventService.getAllRoadRaces().equals(roadRaces));
	}

}