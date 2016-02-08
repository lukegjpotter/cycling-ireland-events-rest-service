package com.lukegjpotter.spring.application.model;

import com.lukegjpotter.spring.application.util.Utilities;

public class RoadRaceModel extends CyclingEventModel {

	private final String classification;
	private final boolean isAPlus, isA1, isA2, isA3, isA4, isVets, isWoman, isJunior, isYouth;

	public RoadRaceModel(String eventName, String startDate, String endDate, String day, String province,
			String classification, String eventType, String isAPlus, String isA1, String isA2, String isA3, String isA4,
			String isVets, String isWoman, String isJunior, Integer isYouth, String primaryContactPerson,
			String primaryContactPersonsEmail, String promotingClub, String distance, String hQLocation,
			String signOnTime) {

		super(eventName, Utilities.convertStringtoDate(startDate), Utilities.convertStringtoDate(endDate), day,
				province, eventType, primaryContactPerson, primaryContactPersonsEmail, promotingClub,
				Double.parseDouble(distance), hQLocation, signOnTime);

		this.classification = classification;
		this.isAPlus = Utilities.convertStringToBoolean(isAPlus);
		this.isA1 = Utilities.convertStringToBoolean(isA1);
		this.isA2 = Utilities.convertStringToBoolean(isA2);
		this.isA3 = Utilities.convertStringToBoolean(isA3);
		this.isA4 = Utilities.convertStringToBoolean(isA4);
		this.isVets = Utilities.convertStringToBoolean(isVets);
		this.isWoman = Utilities.convertStringToBoolean(isWoman);
		this.isJunior = Utilities.convertStringToBoolean(isJunior);
		this.isYouth = Utilities.convertStringToBoolean(isYouth.toString());
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