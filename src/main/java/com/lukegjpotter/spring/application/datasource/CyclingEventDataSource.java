package com.lukegjpotter.spring.application.datasource;

import java.util.List;

import com.lukegjpotter.spring.application.model.CyclingEventModel;

public interface CyclingEventDataSource {

	public List<CyclingEventModel> getAllRoadRaces();
}
