package com.gridnine.testing.service;

import com.gridnine.testing.entity.Flight;

import java.util.List;

public interface FlightsFilter {
    List<Flight> flightsFilter(List<Flight> flights);
}
