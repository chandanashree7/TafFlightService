package com.tekarch.TafFlightService.resttemplate;

import com.tekarch.TafFlightService.model.FlightRequest;
import com.tekarch.TafFlightService.model.FlightResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FlightRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL="http://localhost:8083/api";

    public List<FlightResponse> getFlights(){
        String url=BASE_URL+"/flights";
        System.out.println("Get Flight url:"+url);
        try {
            // Fetching data with ParameterizedTypeReference for a List
            ResponseEntity<List<FlightResponse>> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<FlightResponse>>() {}
            );

            return responseEntity.getBody(); // Return list of flights
        } catch (HttpClientErrorException e) {
            System.err.println("Error fetching flights: " + e.getMessage());
            throw new RuntimeException("Failed to fetch flights from the external service.", e);
        }
    }

    public FlightResponse getFlightById(Long flightId){
        String url=BASE_URL+"/flights/{flightId}";
        System.out.println("Get Flight url:"+url);
        return restTemplate.getForObject(url,FlightResponse.class,flightId);
    }

    public FlightResponse createFlight(FlightRequest requestBooking){
        String url=BASE_URL+"/flights";
        FlightResponse response = restTemplate.postForObject(url,requestBooking, FlightResponse.class);
        System.out.println("Flight response:"+response);
        return response;
    }

    public ResponseEntity<FlightRequest> updateFlight(Long flightId, FlightRequest updatedFlight){
        String url=BASE_URL+" /flights/{flightId}";
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FlightRequest> requestEntity=new HttpEntity<>(updatedFlight,headers);
        return restTemplate.exchange(url,HttpMethod.PUT,requestEntity,FlightRequest.class,flightId);
    }

    public ResponseEntity<String> deleteFlight(Long flightId){
        String url=BASE_URL+"/flights/{flightId}";
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FlightRequest> requestEntity=new HttpEntity<>(headers);
        return restTemplate.exchange(url,HttpMethod.DELETE,requestEntity,String.class,flightId);
    }
}
