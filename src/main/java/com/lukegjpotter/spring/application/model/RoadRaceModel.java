package com.lukegjpotter.spring.application.model;

import java.util.Date;

public class RoadRaceModel extends CyclingEventModel {

	private final String classification;
	private final boolean isAPlus, isA1, isA2, isA3, isA4, isVets, isWoman, isJunior, isYouth;

	public RoadRaceModel(String eventName, Date startDate, Date endDate, String day, String province,
			String classification, String eventType, boolean isAPlus, boolean isA1, boolean isA2, boolean isA3, boolean isA4,
			boolean isVets, boolean isWoman, boolean isJunior, boolean isYouth, String primaryContactPerson,
			String primaryContactPersonsEmail, String promotingClub, String distance, String hQLocation,
			String signOnTime) {

		super(eventName, startDate, endDate, day, province, eventType,
				primaryContactPerson, primaryContactPersonsEmail, promotingClub, Double.parseDouble(distance),
				hQLocation, signOnTime);

		this.classification = classification;
		this.isAPlus = isAPlus;
		this.isA1 = isA1;
		this.isA2 = isA2;
		this.isA3 = isA3;
		this.isA4 = isA4;
		this.isVets = isVets;
		this.isWoman = isWoman;
		this.isJunior = isJunior;
		this.isYouth = isYouth;
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