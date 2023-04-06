package com.example.taxilink.EndRide;

import com.example.taxilink.EncryptionController.DataEncryption;

import java.util.Map;

public class EndRideController {
    DataEncryption encoder;
    Map<String, String> ratingFormInformation;
    Map<String, String> rideInformation;
    String homePageId;

    public void navigateHomePage(){
        System.out.println("navigate to home page button");
    }

    public void sendData(Map<String, String> data){
        System.out.println("sendData function has been run");
    }

//    public void pageFlow(pageID String){
//        System.out.println(" ");
//    }
}
