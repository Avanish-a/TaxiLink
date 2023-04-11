package com.example.taxilink.BaseEntity;

public class Request {

    private String reqID;
    public String carpoolID;
    private String reqCustomer;
    private String destination;
    private String startLocation;
    private Boolean acceptance;

    public Request() {
    }

    public Request(String carpoolID, String reqCustomer, String destination, String startLocation) {
        this.carpoolID = carpoolID;
        this.reqCustomer = reqCustomer;
        this.destination = destination;
        this.startLocation = startLocation;
        this.acceptance = false;
    }

    public String getReqID() {
        return reqID;
    }

    public String getCarpoolID() {
        return carpoolID;
    }

    public String getCustomer() {
        return reqCustomer;
    }

    public String getDestination() {
        return destination;
    }

    public String getStart() {
        return startLocation;
    }

    public void setAcceptance(Boolean accept) {
        acceptance = accept;
    }

    public Boolean isAccepted() {
        return acceptance;
    }
}
