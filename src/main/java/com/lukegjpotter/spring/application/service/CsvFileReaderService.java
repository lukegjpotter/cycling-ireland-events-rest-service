package com.lukegjpotter.spring.application.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceModel;

@Service("csvFileReaderService")
public class CsvFileReaderService {

	public List<CyclingEventModel> readRoadRaces() {

		final String csvFileLocation = "src/main/resources/RoadRaces.csv";
		BufferedReader bufferedReader = null;
		List<CyclingEventModel> roadRaces = new ArrayList<>();

		try {
			bufferedReader = new BufferedReader(new FileReader(csvFileLocation));
			String line = "";
			final String csvDelimiter = ",";

			while ((line = bufferedReader.readLine()) != null) {

				String[] roadRace = line.split(csvDelimiter);

				String eventName = roadRace[0].trim();
				String startDate = roadRace[1].trim();
				String endDate = roadRace[2].trim();
				String day = roadRace[3].trim();
				String province = roadRace[4].trim();
				String classification = roadRace[5].trim();
				String eventType = roadRace[6].trim();
				String isAPlus = roadRace[7].trim();
				String isA1 = roadRace[8].trim();
				String isA2 = roadRace[9].trim();
				String isA3 = roadRace[10].trim();
				String isA4 = roadRace[11].trim();
				String isVets = roadRace[12].trim();
				String isWoman = roadRace[13].trim();
				String isJunior = roadRace[14].trim();
				Integer isYouth = new Integer(roadRace[15].trim());
				String primaryContactPerson = roadRace[16].trim();
				String primaryContactPersonsEmail = roadRace[17].trim();
				String promotingClub = roadRace[18].trim();
				String distance = roadRace[19].trim();
				String hQLocation = roadRace[20].trim();
				String signOnTime = roadRace[21].trim();

				CyclingEventModel roadRaceModel = new RoadRaceModel(eventName, startDate, endDate, day, province,
						classification, eventType, isAPlus, isA1, isA2, isA3, isA4, isVets, isWoman, isJunior, isYouth,
						primaryContactPerson, primaryContactPersonsEmail, promotingClub, distance, hQLocation,
						signOnTime);

				roadRaces.add(roadRaceModel);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return roadRaces;
	}

}
