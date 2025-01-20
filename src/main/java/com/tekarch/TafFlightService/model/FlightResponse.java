package com.tekarch.TafFlightService.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightResponse {

    private Long id;
    private String flightNumber;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer price;
    private int availableSeats;
}
