package com.example.taxilink.RideInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapsInformation {
    String startLocation;
    String endLocation;
    ArrayList<String> nearbyLocations;
    String routeInfo;
    Double distance;

    // Look into how to stsructure this: should be startLocation: jlkjklj , endLocation: jalkjklej
//    public Map<String, String> getRideInfo(){
////        Map<String, String> rideInfo = new HashMap<String, String>(){
////
////        }
////        return test;
//    }

    public String generateRoute(String startLocation, String endLocation){
        return "testing generate route";
    }

    // use google API
    public ArrayList<String> getNearbyLocations(String endLocation){
        return nearbyLocations;
    }
}
