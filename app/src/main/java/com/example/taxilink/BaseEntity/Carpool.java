package com.example.taxilink.BaseEntity;

import java.util.ArrayList;

public class Carpool {
    private String carpoolID;
    private String owner;
    private String taxiID;
    private String destination;
    public Integer capacity;
    private final ArrayList<String> members = new ArrayList<>();
    private Boolean active;

    public Carpool() {
    }

    public Carpool(String owner, String taxiID, String destination, Integer capacity) {
        if (capacity < 2) {
            throw new IllegalArgumentException("Capacity must be more than 1");
        }
        this.owner = owner;
        this.taxiID = taxiID;
        this.destination = destination;
        this.members.add(owner);
        this.capacity = capacity;
        this.active = true;
    }

    public String getCarpoolID() {
        return carpoolID;
    }

    public String getTaxiID() {
        return taxiID;
    }

    public String getOwner() {
        return owner;
    }

    public String getDestination() {
        return destination;
    }

    public Boolean isFull() {
        return members.size() == capacity;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void addMember(String newMember) {
        if (this.members.size() < capacity) {
            this.members.add(newMember);
        }
    }

    public Boolean isActive() {
        return active;
    }

    public void setStatus(Boolean status) {
        if (status) {
            active = false;
        }
    }
}
