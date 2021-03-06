package com.lukegjpotter.spring.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RoadRaceEventDatabaseRecord {

    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;
    @JsonFormat(pattern="yyyyMMdd")
    private Date startDate, bookingsOpenDate, bookingsCloseDate;
    private String eventName, promotingClub, organiser, registrationLink, organiserPhoneNumber, organiserEmail,
            location, province;
    private int monthNumber;
    @OneToMany(cascade=CascadeType.ALL) @JoinColumn(name="eventId")
    private List<StageDetail> stageDetails;
    private boolean isAPlus, isA1, isA2, isA3, isA4, isVets, isWoman, isJunior, isYouth, isParacycling;

    /** Empty Constructor for easy Event Building. */
    public RoadRaceEventDatabaseRecord() {
        setStartDate(new Date(0L));
        setBookingsOpenDate(new Date(0L));
        setBookingsCloseDate(new Date(0L));
        setEventName("");
        setPromotingClub("");
        setOrganiser("");
        setRegistrationLink("");
        setOrganiserPhoneNumber("");
        setOrganiserEmail("");
        setLocation("");
        setProvince("");
        setMonthNumber(-1);
        setAPlus(false);
        setA1(false);
        setA2(false);
        setA3(false);
        setA4(false);
        setVets(false);
        setWoman(false);
        setJunior(false);
        setYouth(false);
        setParacycling(false);
        stageDetails = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getBookingsOpenDate() {
        return bookingsOpenDate;
    }

    public void setBookingsOpenDate(Date bookingsOpenDate) {
        this.bookingsOpenDate = bookingsOpenDate;
    }

    public Date getBookingsCloseDate() {
        return bookingsCloseDate;
    }

    public void setBookingsCloseDate(Date bookingsCloseDate) {
        this.bookingsCloseDate = bookingsCloseDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPromotingClub() {
        return promotingClub;
    }

    public void setPromotingClub(String promotingClub) {
        this.promotingClub = promotingClub;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(String registrationLink) {
        this.registrationLink = registrationLink;
    }

    public String getOrganiserPhoneNumber() {
        return organiserPhoneNumber;
    }

    public void setOrganiserPhoneNumber(String organiserPhoneNumber) {
        this.organiserPhoneNumber = organiserPhoneNumber;
    }

    public String getOrganiserEmail() {
        return organiserEmail;
    }

    public void setOrganiserEmail(String organiserEmail) {
        this.organiserEmail = organiserEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    
    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public List<StageDetail> getStageDetails() {
        return stageDetails;
    }

    public void setStageDetails(List<StageDetail> stageDetails) {
        this.stageDetails = stageDetails;
    }

    public boolean isAPlus() {
        return isAPlus;
    }

    public void setAPlus(boolean isAPlus) {
        this.isAPlus = isAPlus;
    }

    public boolean isA1() {
        return isA1;
    }

    public void setA1(boolean isA1) {
        this.isA1 = isA1;
    }

    public boolean isA2() {
        return isA2;
    }

    public void setA2(boolean isA2) {
        this.isA2 = isA2;
    }

    public boolean isA3() {
        return isA3;
    }

    public void setA3(boolean isA3) {
        this.isA3 = isA3;
    }

    public boolean isA4() {
        return isA4;
    }

    public void setA4(boolean isA4) {
        this.isA4 = isA4;
    }

    public boolean isVets() {
        return isVets;
    }

    public void setVets(boolean isVets) {
        this.isVets = isVets;
    }

    public boolean isWoman() {
        return isWoman;
    }

    public void setWoman(boolean isWoman) {
        this.isWoman = isWoman;
    }

    public boolean isJunior() {
        return isJunior;
    }

    public void setJunior(boolean isJunior) {
        this.isJunior = isJunior;
    }

    public boolean isYouth() {
        return isYouth;
    }

    public void setYouth(boolean isYouth) {
        this.isYouth = isYouth;
    }
    
    public boolean isParacycling() {
        return isParacycling;
    }

    public void setParacycling(boolean isParacycling) {
        this.isParacycling = isParacycling;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof RoadRaceEventDatabaseRecord) {
            RoadRaceEventDatabaseRecord other = (RoadRaceEventDatabaseRecord) obj;

            return this.getStartDate().equals(other.getStartDate())
                    && this.getEventName().equals(other.getEventName())
                    && this.getPromotingClub().equals(other.getPromotingClub())
                    && this.getOrganiser().equals(other.getOrganiser())
                    && this.getRegistrationLink().equals(other.getRegistrationLink())
                    && this.getBookingsOpenDate().equals(other.getBookingsOpenDate())
                    && this.getBookingsCloseDate().equals(other.getBookingsCloseDate())
                    && this.getOrganiserPhoneNumber().equals(other.getOrganiserPhoneNumber())
                    && this.getOrganiserEmail().equals(other.getOrganiserEmail())
                    && this.getLocation().equals(other.getLocation())
                    && this.getProvince().equals(other.getProvince())
                    && this.isAPlus() == other.isAPlus()
                    && this.isA1() == other.isA1()
                    && this.isA2() == other.isA2()
                    && this.isA3() == other.isA3()
                    && this.isA4() == other.isA4()
                    && this.isWoman() == other.isWoman()
                    && this.isVets() == other.isVets()
                    && this.isJunior() == other.isJunior()
                    && this.isYouth() == other.isYouth()
                    && this.isParacycling() == other.isParacycling();
        }

        return false;
    }
    
    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getEventName()).append(" by ").append(this.getPromotingClub());
        sb.append(" in ").append(this.getLocation());
        sb.append(". Stages: ").append(this.getStageDetails().size()).append(".");
        this.getStageDetails().forEach(stagedetail -> sb.append(stagedetail.toString()));
        return sb.toString();
    }

    public void addStageDetail(StageDetail stageDetail) {
        this.stageDetails.add(stageDetail);
    }
    
}
