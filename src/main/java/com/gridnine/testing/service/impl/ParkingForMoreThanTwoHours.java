package com.gridnine.testing.service.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.service.FlightsFilter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingForMoreThanTwoHours implements FlightsFilter {
    @Override
    public List<Flight> flightsFilter(List<Flight> flights) {
        List<Flight> newFlightList = new ArrayList<>();
        int limitHours = 2;
        long sumInterval = 0;
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrival = segments.get(i).getArrivalDate();
                LocalDateTime departure = segments.get(i + 1).getDepartureDate();
                long groundTime = Duration.between(arrival, departure).toHours();
                sumInterval += groundTime;
            }
            if (sumInterval <= limitHours) {
                newFlightList.add(flight);
            }
        }
        return newFlightList;
    }
}
