package com.gridnine.testing.service.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.service.FlightsFilter;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalDateBeforeDepartureDate implements FlightsFilter {
    @Override
    public List<Flight> flightsFilter(List<Flight> flights) {
        return flights.stream().filter(segments -> segments.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate())))
                .collect(Collectors.toList());
    }
}
