package com.lukegjpotter.spring.application.controller.integration;

import com.lukegjpotter.spring.application.controller.CyclingEventController;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.testresources.TestResources;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class CyclingEventControllerIntegrationTest {

    @Autowired
    private CyclingEventController controller;
    @Autowired
    private TestResources tr;

    @Test public void testGetRoadRaceId1() {
        String actual = controller.getRoadRaceId1().get().getEventName();
        String expected = "Invacare Paracycling TT round 2";

        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testGetRoadRacesBetween() {
        List<RoadRaceEventDatabaseRecord> actual = controller.getRoadRacesBetween("20160606", "20160610");
        RoadRaceEventDatabaseRecord expected = tr.getRoadRaceEventDatabaseRecord();

        assertTrue(actual.contains(expected));
    }

}
