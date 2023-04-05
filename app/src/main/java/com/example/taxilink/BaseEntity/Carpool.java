package com.example.taxilink.BaseEntity;

import java.util.ArrayList;

public class Carpool {
    private final String carpoolID;
    private final Profile owner;
    private final String taxiID;
    private final String destination;
    public final Integer capacity;
    private ArrayList<Profile> members = new ArrayList<Profile>();
    private Boolean active;

    public Carpool(String carpoolID, Profile owner, String taxiID, String destination, Integer capacity) {
        if (capacity < 2) {
            throw new IllegalArgumentException("Capacity must be more than 1");
        }
        this.carpoolID = carpoolID;
        this.owner = owner;
        this.taxiID = taxiID;
        this.destination = destination;
        this.members.add(owner);
        this.active = true;
        this.capacity = capacity;
    }

    public String getCarpoolID() {
        return this.carpoolID;
    }

    public String getTaxiID() {
        return this.taxiID;
    }

    public Profile getOwner() {
        return this.owner;
    }

    public String getDestination() {
        return this.destination;
    }

    public Boolean isFull() {
        return this.members.size() == this.capacity;
    }

    public ArrayList<Profile> members() {
        return this.members;
    }

    public void addMember(Profile newMember) {
        if (this.members.size() < capacity) {
            this.members.add(newMember);
        }
    }

    public Boolean isActive() {
        return this.active;
    }

    public void setStatus(Boolean status) {
        if (status) {
            this.active = false;
        }
    }
}

//- carpoolID : String
//- owner : Profile
//- members : ArrayList<Profile>
//- taxiId : String
//- active : Boolean
//- destination : String
//+ capacity : Integer
//
//+ getCarpoolID() : String
//+ getTaxiID() : String
//+ getOwner() : Profile
//+ getDest() : String
//+ isFull() : Boolean
//+ members() : ArrayList<Profile>
//+ addMember(member : Profile): void
//+ isActive() : Boolean