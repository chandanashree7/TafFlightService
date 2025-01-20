package com.tekarch.TafFlightService.service.Interface;

import com.tekarch.TafFlightService.model.FlightRequest;
import com.tekarch.TafFlightService.model.FlightResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FlightServiceInterface {

    FlightResponse createFlight(FlightRequest requestFlight);
    List<FlightResponse> getAllFlights();
    FlightResponse getFlightById(Long flightId);
    ResponseEntity<FlightRequest> updateFlight(FlightRequest flights, Long flightId);
    ResponseEntity<String> deleteFlight(Long flightId);
}
