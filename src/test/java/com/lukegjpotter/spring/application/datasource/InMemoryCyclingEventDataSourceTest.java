package com.lukegjpotter.spring.application.datasource;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lukegjpotter.spring.application.model.RoadRaceModel;

public class InMemoryCyclingEventDataSourceTest {

	private CyclingEventDataSource cyclingEventDataSource;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cyclingEventDataSource = InMemoryCyclingEventDataSource.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllRoadRacesWithOneRace() {
		assertEquals(1, cyclingEventDataSource.getAllRoadRaces().size());
	}

	@Test
	public void testGetAllRoadRacesWithHardCodedLukeGJCupRace() {

		RoadRaceModel lukeGjCupRoadRace = new RoadRaceModel("Luke GJ Cup", "14/02/2016", "", "Sunday", "Leinster",
				"Road", "Road", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", 0, "Luke GJ Potter",
				"lukegjpotter@mail.com", "Luke GJ CC", "100.00", "Lukestown Community Centre", "11.30");

		assertTrue(cyclingEventDataSource.getAllRoadRaces().contains(lukeGjCupRoadRace));
	}

}
