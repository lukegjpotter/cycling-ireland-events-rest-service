package com.lukegjpotter.spring.application.testresources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.util.ModelUtilities;

@Component
public class TestResources {
    
    @Autowired ModelUtilities utils;

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
}
