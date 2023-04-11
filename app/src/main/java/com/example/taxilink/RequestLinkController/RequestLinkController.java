package com.example.taxilink.RequestLinkController;
import com.example.taxilink.EncryptionController.RSAEncryption.RSA;
import com.example.taxilink.TaxiSessionController.TaxiSessionController;

import java.util.ArrayList;
import java.util.List;

public class RequestLinkController {
    private static RSA encryptionController = new RSA();
    public static List<String> getCarpools(String destination) {
        List<String> availCarpools = new ArrayList<String>();

        String givenDestination = TaxiSessionController.decrypt(destination);

        // match offers in database with destination
        if (givenDestination.equals("McMaster University")) {
            String match = "Taxi #01";
            availCarpools.add(match);
        }

        return availCarpools;
    }
    protected static String encrypt(String data) {
        return encryptionController.encrypt(data);
    }
    protected static String decrypt(String data) {
        return encryptionController.decrypt(data);
    }
}
