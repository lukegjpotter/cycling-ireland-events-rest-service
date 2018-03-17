package com.lukegjpotter.spring.application.controller;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.service.CyclingEventService;
import com.lukegjpotter.spring.application.testresources.TestResources;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CyclingEventControllerTest {

    @InjectMocks
    private CyclingEventController cyclingEventController;
    @Mock
    private CyclingEventService cyclingEventService;
    @Autowired
    private TestResources tr;

    private List<CyclingEventModel> roadRaces;

    @Before
    public void setUp() {
        roadRaces = tr.getRoadRaceList();
        MockitoAnnotations.initMocks(this);
        when(cyclingEventService.getAllRoadRaces()).thenReturn(roadRaces);
    }

    @Test
    public void testGetAllRoadRaces() {
        assertEquals(roadRaces, cyclingEventController.getAllRoadRaces());
    }
}
