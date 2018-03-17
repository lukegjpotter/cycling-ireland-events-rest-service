package com.lukegjpotter.spring.application.testresources;

import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestResources {

    @Autowired
    private UtilsService utils;

    public List<RoadRaceEventDatabaseRecord> getRoadRaceList() {

        List<RoadRaceEventDatabaseRecord> roadRaces = new ArrayList<>();
        roadRaces.add(getRoadRaceEventDatabaseRecord());
        
        return roadRaces;
    }

    public RoadRaceEventDatabaseRecord getRoadRaceEventDatabaseRecord() {
        RoadRaceEventDatabaseRecord race = new RoadRaceEventDatabaseRecord();
        
        race.setStartDate(utils.convertYYYYMMDDToDate("20160606"));
        race.setBookingsOpenDate(utils.convertYYYYMMDDToDate("20160606"));
        race.setBookingsCloseDate(utils.convertYYYYMMDDToDate("20150608"));
        race.setEventName("Temple");
        race.setPromotingClub("Maryland Wheelers");
        race.setOrganiser("Phil Holland");
        race.setRegistrationLink("");
        race.setOrganiserPhoneNumber("+447766655644");
        race.setOrganiserEmail("phil.holland4@btopenworld.com");
        race.setLocation("Carr Road, Lisburn");
        race.setProvince("");
        race.setAPlus(false);
        race.setA1(true);
        race.setA2(true);
        race.setA3(true);
        race.setA4(true);
        race.setVets(true);
        race.setWoman(true);
        race.setJunior(true);
        race.setYouth(false);
        race.setParacycling(false);
        
        StageDetail stage = new StageDetail();
        stage.setDate(utils.convertYYYYMMDDToDate("20160606"));
        stage.setRaceNumber(1);
        stage.setStageNumber(1);
        stage.setLocation("Carr Road");
        stage.setRaceType("A1,A2,A3,A4,Women,Vets,Junior");
        stage.setCategory("Road");
        stage.setSignOnTime("18:00");
        stage.setStartTime("18:45");
        stage.setRouteLinkUrl("");
        stage.setKilometers(48.3);
        stage.setMiles(30.0);
        race.addStageDetail(stage);
        
        return race;
    }
}
