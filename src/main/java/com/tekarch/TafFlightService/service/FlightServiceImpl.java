package com.tekarch.TafFlightService.service;

import com.tekarch.TafFlightService.model.FlightRequest;
import com.tekarch.TafFlightService.model.FlightResponse;
import com.tekarch.TafFlightService.resttemplate.FlightRestTemplate;
import com.tekarch.TafFlightService.service.Interface.FlightServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightServiceInterface {

    @Autowired
    FlightRestTemplate flightrestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public FlightResponse createFlight(FlightRequest flight) {
        return flightrestTemplate.createFlight(flight);
    }

    @Override
    public List<FlightResponse> getAllFlights() {
        return flightrestTemplate.getFlights();

    }

    @Override
    public FlightResponse getFlightById(Long flightId) {
        return flightrestTemplate.getFlightById(flightId);
    }

    @Override
    public ResponseEntity<FlightRequest> updateFlight(FlightRequest flights, Long flightId) {
        return flightrestTemplate.updateFlight(flightId,flights);
    }

    @Override
    public ResponseEntity<String> deleteFlight(Long flightId) {
        return flightrestTemplate.deleteFlight(flightId);
    }
}
