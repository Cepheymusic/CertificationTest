package com.gridnine.testing.service.impl;

import com.gridnine.testing.service.FlightsFilter;
import org.junit.jupiter.api.Test;

import com.gridnine.testing.dao.FlightBuilder;
import com.gridnine.testing.entity.Flight;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrivalDateBeforeDepartureDateTest {

    FlightsFilter underTest = new ArrivalDateBeforeDepartureDate();
    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    void arrivalDateBeforeDepartureDate_returnCorrectFlights() {
        List<Flight> test = underTest.flightsFilter(flights);
        assertNotNull(test);
        assertEquals(5, test.size());
    }
}