package com.lukegjpotter.spring.application.datasource;

import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.service.CsvFileReaderService;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InMemoryCyclingEventDataSourceTest {

    @InjectMocks
    private InMemoryCyclingEventDataSource cyclingEventDataSource;
    @Mock
    private CsvFileReaderService csvFileReaderService;
    @Autowired
    private TestResources tr;

    private RoadRaceModel lukeGjCupRoadRace;

    @Before
    public void setUp() {

        lukeGjCupRoadRace = tr.getRoadRace();
        MockitoAnnotations.initMocks(this);
        when(csvFileReaderService.readRoadRaces()).thenReturn(tr.getRoadRaceList());
    }

    @Test
    public void testGetAllRoadRacesWithOneRace() {
        assertEquals(1, cyclingEventDataSource.getAllRoadRaces().size());
    }

    @Test
    public void testGetAllRoadRacesWithHardCodedLukeGJCupRace() {
        assertTrue(cyclingEventDataSource.getAllRoadRaces().contains(lukeGjCupRoadRace));
    }

}
