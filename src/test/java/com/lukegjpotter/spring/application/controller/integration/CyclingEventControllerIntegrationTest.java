package com.lukegjpotter.spring.application.controller.integration;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsRestServiceApplication;
import com.lukegjpotter.spring.application.controller.CyclingEventController;
import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsRestServiceApplication.class, CyclingEventController.class })
public class CyclingEventControllerIntegrationTest {

    @Autowired CyclingEventController controller;
    @Autowired TestResources tr;
    
    @Before public void setUp() throws Exception {}

    @Test public void testGetAllRoadRaces() {
        List<CyclingEventModel> actual = controller.getAllRoadRaces();
        CyclingEventModel expected = tr.getCsvRoadRace();
        
        assertTrue(actual.contains(expected));
    }

    @Test public void testGetRoadRaceId1() {
        String actual = controller.getRoadRaceId1().getEventName();
        String expected = "Invacare Paracycling TT round 2";
        
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testGetRoadRacesBetween() {
        List<RoadRaceEventDatabaseRecord> actual = controller.getRoadRacesBetween("20160606", "20160610");
        RoadRaceEventDatabaseRecord expected = tr.getRoadRaceEventDatabaseRecord();
        
        assertTrue(actual.contains(expected));
    }

}
