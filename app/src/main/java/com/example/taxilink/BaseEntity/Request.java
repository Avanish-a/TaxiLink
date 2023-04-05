package com.example.taxilink.BaseEntity;

public class Request {

    private final String reqID;
    public final Carpool carpool;
    private final Profile reqCustomer;
    private final String destination;
    private final String startLocation;
    private Boolean acceptance;

    public Request(String reqID, Carpool carpool, Profile reqCustomer, String destination, String startLocation) {
        this.reqID = reqID;
        this.carpool = carpool;
        this.reqCustomer = reqCustomer;
        this.destination = destination;
        this.startLocation = startLocation;
        this.acceptance = false;
    }

    public String getReqID() {
        return this.reqID;
    }

    public String getCarpoolID() {
        return this.carpool.getCarpoolID();
    }

    public Profile getCustomer() {
        return this.reqCustomer;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getStart() {
        return this.startLocation;
    }

    public void setAcceptance(Boolean accept) {
        this.acceptance = accept;
    }

    public Boolean isAccepted() {
        return this.acceptance;
    }
}


//+ reqID : String
//- carpoolReq : Carpool
//+ reqCustomer : Profile
//- destination : String
//- startLocation : String
//- acceptance : Boolean
//
//+ getCarpoolID() : String
//+ getCustomer() : Profile
//+ getDest() : String
//+ setAcceptance(accept : Boolean) : void
//+ isAccepted() : Boolean