package com.lukegjpotter.spring.application.testresources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.UtilsService;

@Component
public class TestResources {
    
    @Autowired UtilsService utils;

    public List<CyclingEventModel> getRoadRaceList() {
        
        List<CyclingEventModel> roadRaces = new ArrayList<>();
        roadRaces.add(getRoadRace());
        
        return roadRaces;
    }

    public RoadRaceModel getRoadRace() {
        return new RoadRaceModel("Luke GJ Cup", utils.convertStringtoDate("14/02/2016"),
                utils.convertStringtoDate(""), "Sunday", "Leinster", "Road", "Road", true, true, true, true, true,
                true, true, true, false, "Luke GJ Potter", "lukegjpotter@mail.com", "Luke GJ CC", "100.00",
                "Lukestown Community Centre", "11.30");
    }
    
    public RoadRaceModel getRoadRaceLukeGjGp() {
        return new RoadRaceModel("Luke GJ GP", utils.convertStringtoDate("07/05/2016"), utils.convertStringtoDate(""), "Saturday", "Leinster", "Road", "Road", false,
                false, false, true, true, false, true, true, false, "Luke Campbell", "lukecampbell1@hotmail.com",
                "Luke GJ Wheelers", "68.00", "Luke GJ GAA", "9.00");
    }

    public CyclingEventModel getCsvRoadRace() {
        return new RoadRaceModel("Ned Flanagan Memorial", utils.convertStringtoDate("20160214"), utils.convertStringtoDate(""),
                "Sunday", "Leinster", "Road", "Road", true,
                true, true, true, true, false, true, true, false, "John Malone", "johnmalone817@yahoo.co.uk",
                "Newbridge CC", "60", "The Bell Yard", "9.30");
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
