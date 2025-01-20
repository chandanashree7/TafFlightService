package com.tekarch.TafFlightService.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class FlightRequest implements Serializable {

        private Long id;
        private String flightNumber;
        private String departure;
        private String arrival;
        private LocalDateTime departureTime;
        private LocalDateTime arrivalTime;
        private Integer price;
        private int availableSeats;
}
