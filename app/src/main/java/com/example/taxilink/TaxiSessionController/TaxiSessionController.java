package com.example.taxilink.TaxiSessionController;

import com.example.taxilink.EncryptionController.RSAEncryption.RSA;

import java.util.ArrayList;
import java.util.List;

public class TaxiSessionController {
    private static RSA encryptionController = new RSA();

    public static ArrayList<String> getRequestData(String requestID) {
        ArrayList<String> customerData = new ArrayList<String>();

        // hard coded request
        double fareRate = 2.5;
        double distance = 1;
        double newFare = fareRate*distance;

        customerData.add(requestID);
        customerData.add("John Smith");
        customerData.add("4/5");
        customerData.add("West End Pub");
        customerData.add(distance + " km");
        customerData.add("5 minutes");
        customerData.add("$" + newFare);


        return customerData;
    }

    public static String sendJoinRequest(String custID) {
        return "Send Join Request";
    }

    public static boolean getRequestStatus(String custID) {
        return true;
    }

    public static void deleteProfile(String custID) {

    }

    public static void updateProfile(String custID) {

    }
    public static Profile getProfile(String custID) {
        return new Profile();
    }

    public static boolean submitData() {
        return true;
    }
    protected static String encrypt(String data) {
        return encryptionController.encrypt(data);
    }

    protected static String decrypt(String data) {
        return encryptionController.decrypt(data);
    }
}
