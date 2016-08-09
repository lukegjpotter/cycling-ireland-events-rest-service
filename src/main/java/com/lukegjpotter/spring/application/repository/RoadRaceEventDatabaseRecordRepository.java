package com.lukegjpotter.spring.application.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;

public interface RoadRaceEventDatabaseRecordRepository extends CrudRepository<RoadRaceEventDatabaseRecord, Long> {

    public List<RoadRaceEventDatabaseRecord> findByStartDateBetween(Date searchStartDate, Date searchEndDate);

    public List<RoadRaceEventDatabaseRecord> findByMonthNumber(int monthNumber);
}
