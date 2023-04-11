package com.example.taxilink.AppData;

import com.example.taxilink.BaseEntity.Carpool;

import java.util.HashMap;

public class OfferInfo {

    private HashMap<String, Carpool> activePools;
    private HashMap<String, Carpool> inactivePools;

    public void addOffer(Carpool carpool, boolean status) {
        if (status) {
            activePools.put(carpool.getCarpoolID(), carpool);
        }
        else  {
            inactivePools.put(carpool.getCarpoolID(), carpool);
        }
    }
    public Carpool getOffer(String carpoolID, boolean status) {
        if (status) {
            return activePools.get(carpoolID);
        }
        else  {
            return inactivePools.get(carpoolID);
        }
    }

    private String generateOfferID() {
        return "";
    }

}
