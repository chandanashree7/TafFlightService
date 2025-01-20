package com.tekarch.TafFlightService.controller;

import com.tekarch.TafFlightService.model.FlightRequest;
import com.tekarch.TafFlightService.model.FlightResponse;
import com.tekarch.TafFlightService.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping("/getAllFlights/flights")
    public ResponseEntity<List<FlightResponse>> getAllFlights() {
        List<FlightResponse> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping(path="/getFlight/{flightId}")
    public ResponseEntity<FlightResponse> getBookingById(@PathVariable Long flightId) {
        FlightResponse bookingResponse = flightService.getFlightById(flightId);
        return ResponseEntity.status(HttpStatus.OK).body(bookingResponse);
    }

    @PostMapping(path="/create")
    public ResponseEntity<FlightResponse> createFlight(@RequestBody FlightRequest flightRequest) {
        FlightResponse flightResponse = flightService.createFlight(flightRequest);
        return new ResponseEntity<>(flightResponse, HttpStatus.CREATED);
    }

    @PutMapping(path="/updateFlight/{flightId}")
    public ResponseEntity<ResponseEntity<FlightRequest>> updateFlight(@PathVariable Long flightId, @RequestBody FlightRequest flightRequest){
        ResponseEntity<FlightRequest> flightResponse = flightService.updateFlight(flightRequest, flightId);
        return new ResponseEntity<>(flightResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteflight/{flightId}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long flightId) {
        flightService.deleteFlight(flightId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
