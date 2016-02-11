package com.lukegjpotter.spring.application.model;

import java.util.Date;

public class CyclingEventModel {

	private final String eventName, day, province, eventType, primaryContactPerson, primaryContactPersonsEmail,
			promotingClub, hQLocation, signOnTime;
	private final double distance;
	private final Date startDate, endDate;

	public CyclingEventModel(String eventName, Date startDate, Date endDate, String day, String province,
			String eventType, String primaryContactPerson, String primaryContactPersonsEmail, String promotingClub,
			double distance, String hQLocation, String signOnTime) {

		this.eventName = eventName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.day = day;
		this.province = province;
		this.eventType = eventType;
		this.primaryContactPerson = primaryContactPerson;
		this.primaryContactPersonsEmail = primaryContactPersonsEmail;
		this.promotingClub = promotingClub;
		this.distance = distance;
		this.hQLocation = hQLocation;
		this.signOnTime = signOnTime;
	}

	public String getEventName() {
		return eventName;
	}

	public String getDay() {
		return day;
	}

	public String getProvince() {
		return province;
	}

	public String getEventType() {
		return eventType;
	}

	public String getPrimaryContactPerson() {
		return primaryContactPerson;
	}

	public String getPrimaryContactPersonsEmail() {
		return primaryContactPersonsEmail;
	}

	public String getPromotingClub() {
		return promotingClub;
	}

	public String gethQLocation() {
		return hQLocation;
	}

	public String getSignOnTime() {
		return signOnTime;
	}

	public double getDistance() {
		return distance;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof CyclingEventModel) {
			CyclingEventModel otherCyclingEventModel = (CyclingEventModel) obj;

			return getEventName().equalsIgnoreCase(otherCyclingEventModel.getEventName())
					&& getProvince().equalsIgnoreCase(otherCyclingEventModel.getProvince())
					&& getEventType().equalsIgnoreCase(otherCyclingEventModel.getEventType())
					&& getPromotingClub().equalsIgnoreCase(otherCyclingEventModel.getPromotingClub())
					&& gethQLocation().equalsIgnoreCase(otherCyclingEventModel.gethQLocation())
					&& getStartDate().equals(otherCyclingEventModel.getStartDate());
		}

		return false;
	}
}