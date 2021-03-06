package com.lukegjpotter.spring.application.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class StageDetail {

    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;
    @JsonFormat(pattern="yyyyMMdd")
    private Date date;
    private Integer raceNumber, stageNumber;
    private String location, raceType, category, signOnTime, startTime, routeLinkUrl;
    private Double kilometers, miles;

    public StageDetail() {
        setDate(new Date(0L));
        setLocation("");
        setRaceNumber(0);
        setStageNumber(0);
        setRaceType("");
        setKilometers(0.0);
        setMiles(0.0);
        setCategory("");
        setSignOnTime("");
        setStartTime("");
        setRouteLinkUrl("");
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
    }

    public Integer getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(Integer stageNumber) {
        this.stageNumber = stageNumber;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSignOnTime() {
        return signOnTime;
    }

    public void setSignOnTime(String signOnTime) {
        this.signOnTime = signOnTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getRouteLinkUrl() {
        return routeLinkUrl;
    }

    public void setRouteLinkUrl(String routeLinkUrl) {
        this.routeLinkUrl = routeLinkUrl;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public Double getMiles() {
        return miles;
    }

    public void setMiles(Double miles) {
        this.miles = miles;
    }

    @Override public boolean equals(Object obj) {

        if (obj instanceof StageDetail) {
            StageDetail other = (StageDetail) obj;

            return this.getDate().equals(other.getDate()) && this.getLocation().equals(other.getLocation())
                    && this.getRaceNumber().equals(other.getRaceNumber())
                    && this.getStageNumber().equals(other.getStageNumber())
                    && this.getRaceType().equals(other.getRaceType()) && this.getCategory().equals(other.getCategory())
                    && this.getSignOnTime().equals(other.getSignOnTime())
                    && this.getStartTime().equals(other.getStartTime())
                    && this.getRouteLinkUrl().equals(other.getRouteLinkUrl())
                    && this.getKilometers().equals(other.getKilometers()) && this.getMiles().equals(other.getMiles());
        }

        return false;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tRace ").append(this.getRaceNumber()).append(": ");
        sb.append("Stage ").append(this.getStageNumber()).append(": ");
        sb.append(this.getCategory()).append(" - ");
        sb.append(this.getKilometers()).append("km");
        return sb.toString();
    }
}
