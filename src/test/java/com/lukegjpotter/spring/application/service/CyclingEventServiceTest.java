package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.datasource.CyclingEventDataSource;
import com.lukegjpotter.spring.application.model.CyclingEventModel;
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

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CyclingEventServiceTest {

    @Autowired
    private TestResources tr;
    @InjectMocks
    private CyclingEventService cyclingEventService;
    @Mock
    private CyclingEventDataSource cyclingEventDataSource;

    private List<CyclingEventModel> roadRaces;

    @Before
    public void setUp() {

        roadRaces = tr.getRoadRaceList();
        MockitoAnnotations.initMocks(this);
        when(cyclingEventDataSource.getAllRoadRaces()).thenReturn(roadRaces);
    }

    @Test
    public void testGetAllRoadRaces() {
        assertTrue(cyclingEventService.getAllRoadRaces().equals(roadRaces));
    }

}