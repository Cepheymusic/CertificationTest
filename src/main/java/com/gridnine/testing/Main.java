package com.gridnine.testing;
import com.gridnine.testing.dao.FlightBuilder;
import com.gridnine.testing.entity.Flight;

import com.gridnine.testing.service.impl.ArrivalDateBeforeDepartureDate;
import com.gridnine.testing.service.impl.DepartureBeforeTheCurrentTime;
import com.gridnine.testing.service.impl.ParkingForMoreThanTwoHours;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        DepartureBeforeTheCurrentTime departureBeforeTheCurrentTime = new DepartureBeforeTheCurrentTime();
        ArrivalDateBeforeDepartureDate arrivalDateBeforeDepartureDate = new ArrivalDateBeforeDepartureDate();
        ParkingForMoreThanTwoHours parkingForMoreThanTwoHours = new ParkingForMoreThanTwoHours();

        System.out.println("Исключение вылетов до текущего времени");
        printFlights(departureBeforeTheCurrentTime.flightsFilter(flights));
        System.out.println("Исключение вылетов с датой прилета раньше даты вылета");
        printFlights(arrivalDateBeforeDepartureDate.flightsFilter(flights));
        System.out.println("Исключение перелетов, где общее время, проведённое на земле, превышает два часа");
        printFlights(parkingForMoreThanTwoHours.flightsFilter(flights));
    }

    private static void printFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
