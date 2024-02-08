package com.gridnine.testing.service.impl;

import com.gridnine.testing.dao.FlightBuilder;
import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.service.FlightsFilter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingForMoreThanTwoHoursTest {
    FlightsFilter underTest = new ParkingForMoreThanTwoHours();
    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    void parkingForMoreThanTwoHours_returnCorrectFlights() {
        List<Flight> test = underTest.flightsFilter(flights);
        assertNotNull(test);
        assertEquals(4, test.size());
    }
}