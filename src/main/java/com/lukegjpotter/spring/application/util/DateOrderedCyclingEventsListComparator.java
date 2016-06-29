package com.lukegjpotter.spring.application.util;

import java.util.Comparator;

import com.lukegjpotter.spring.application.model.CyclingEventModel;

public class DateOrderedCyclingEventsListComparator implements Comparator<CyclingEventModel> {

	@Override public int compare(CyclingEventModel o1, CyclingEventModel o2) {
		return o1.getStartDate().compareTo(o2.getStartDate());
	}
}
