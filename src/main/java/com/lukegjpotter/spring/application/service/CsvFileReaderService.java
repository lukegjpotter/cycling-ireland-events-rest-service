package com.lukegjpotter.spring.application.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.CyclingEventModel;
import com.lukegjpotter.spring.application.model.RoadRaceModel;
import com.lukegjpotter.spring.application.util.DateOrderedCyclingEventsListComparator;

@Service("csvFileReaderService")
public class CsvFileReaderService {

	private static final Logger log = Logger.getLogger(CsvFileReaderService.class.getName());

	private String csvFileLocation;
	private final String csvDelimiter = ",";

	public List<CyclingEventModel> readRoadRaces() {

		BufferedReader bufferedReader = null;
		List<CyclingEventModel> roadRaces = new ArrayList<>();

		try {
			bufferedReader = new BufferedReader(new FileReader(csvFileLocation));
			String line = "";

			while ((line = bufferedReader.readLine()) != null) {
				roadRaces.add(populateCyclingEventModelFromLine(line));
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
		Collections.sort(roadRaces, new DateOrderedCyclingEventsListComparator());
		return roadRaces;
	}

	private CyclingEventModel populateCyclingEventModelFromLine(String line) {

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
		String hQLocation = handleVariousHqLocationFormats(roadRace);
		String signOnTime = roadRace[roadRace.length - 1].trim();

		CyclingEventModel roadRaceModel = new RoadRaceModel(eventName, startDate, endDate, day, province,
				classification, eventType, isAPlus, isA1, isA2, isA3, isA4, isVets, isWoman, isJunior, isYouth,
				primaryContactPerson, primaryContactPersonsEmail, promotingClub, distance, hQLocation, signOnTime);

		return roadRaceModel;
	}

	private String handleVariousHqLocationFormats(String[] roadRace) {

		int startPosition = 20;
		int endPosition = roadRace.length - 2;

		if (startPosition == endPosition)
			return roadRace[startPosition].trim();

		String hqLocation = "";
		for (int i = startPosition; i <= endPosition; i++) {
			hqLocation += roadRace[i].trim() + ", ";
		}

		// Remove the leading " character
		if (hqLocation.charAt(0) == '\"')
			hqLocation = hqLocation.substring(1);

		// Remove the trailing ",<space> characters
		if (hqLocation.substring(hqLocation.length() - 3).equals("\", "))
			hqLocation = hqLocation.substring(0, hqLocation.length() - 3);

		return hqLocation;
	}

	@Value("${csvfile.location}")
	public void setCsvFileLocation(String csvFileLocation) {
		log.info("Setting CSV File Location to " + csvFileLocation);
		this.csvFileLocation = csvFileLocation;
	}

}