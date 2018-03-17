package com.lukegjpotter.spring.application.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StageDetailTest {

    private StageDetail stage;

    @Before
    public void setUp() {
        stage = new StageDetail();
        stage.setRaceNumber(1);
        stage.setStageNumber(1);
        stage.setCategory("A4");
        stage.setKilometers(50.0);
    }

    @Test public void testToString() {
        String expected = "\n\tRace 1: Stage 1: A4 - 50.0km";
        String actual = stage.toString();
        assertTrue(expected.equals(actual));
    }

    @Test public void testEqualsOtherObject() {
        assertFalse(stage.equals(new Date()));
    }

}
