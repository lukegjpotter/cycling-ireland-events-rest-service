package com.lukegjpotter.spring.application.model;

import static com.lukegjpotter.spring.application.util.ModelUtilities.convertStringToBoolean;
import static com.lukegjpotter.spring.application.util.ModelUtilities.convertStringtoDate;

public class RoadRaceModel extends CyclingEventModel {

	private final String classification;
	private final boolean isAPlus, isA1, isA2, isA3, isA4, isVets, isWoman, isJunior, isYouth;

	public RoadRaceModel(String eventName, String startDate, String endDate, String day, String province,
			String classification, String eventType, String isAPlus, String isA1, String isA2, String isA3, String isA4,
			String isVets, String isWoman, String isJunior, Integer isYouth, String primaryContactPerson,
			String primaryContactPersonsEmail, String promotingClub, String distance, String hQLocation,
			String signOnTime) {

		super(eventName, convertStringtoDate(startDate), convertStringtoDate(endDate), day, province, eventType,
				primaryContactPerson, primaryContactPersonsEmail, promotingClub, Double.parseDouble(distance),
				hQLocation, signOnTime);

		this.classification = classification;
		this.isAPlus = convertStringToBoolean(isAPlus);
		this.isA1 = convertStringToBoolean(isA1);
		this.isA2 = convertStringToBoolean(isA2);
		this.isA3 = convertStringToBoolean(isA3);
		this.isA4 = convertStringToBoolean(isA4);
		this.isVets = convertStringToBoolean(isVets);
		this.isWoman = convertStringToBoolean(isWoman);
		this.isJunior = convertStringToBoolean(isJunior);
		this.isYouth = convertStringToBoolean(isYouth.toString());
	}

	public String getClassification() {
		return classification;
	}

	public boolean isAPlus() {
		return isAPlus;
	}

	public boolean isA1() {
		return isA1;
	}

	public boolean isA2() {
		return isA2;
	}

	public boolean isA3() {
		return isA3;
	}

	public boolean isA4() {
		return isA4;
	}

	public boolean isVets() {
		return isVets;
	}

	public boolean isWoman() {
		return isWoman;
	}

	public boolean isJunior() {
		return isJunior;
	}

	public boolean isYouth() {
		return isYouth;
	}
}