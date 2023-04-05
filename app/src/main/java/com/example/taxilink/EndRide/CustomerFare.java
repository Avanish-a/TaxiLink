package com.example.taxilink.EndRide;

import java.util.Map;

public class CustomerFare {

    Double fare;
    Map<String, String> rideInformation;

    private Double calculateFare(Map<String, String> rideInformation){
        fare = 100.00;
        return fare;
    }

}
