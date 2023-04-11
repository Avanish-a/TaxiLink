package com.example.taxilink.OfferLinkController;

import com.example.taxilink.BaseEntity.Carpool;
import com.example.taxilink.EncryptionController.RSAEncryption.RSA;
import com.example.taxilink.TaxiSessionController.TaxiSessionController;

import java.util.ArrayList;
import java.util.List;

public class OfferLinkController {
    private static RSA encryptionController = new RSA();
    public static void createOffer(Carpool newCarpool) {
        String owner = newCarpool.getOwner();
        String taxiID = newCarpool.getTaxiID();
        String destination = newCarpool.getDestination();

        String decryptedOwner = TaxiSessionController.decrypt(owner);
        String decryptedTaxiID = TaxiSessionController.decrypt(taxiID);
        String decryptedDestination = TaxiSessionController.decrypt(destination);

        Carpool addCarpool = new Carpool(decryptedOwner, decryptedTaxiID, decryptedDestination, newCarpool.capacity);
        // add carpool to database
    }
    protected static String encrypt(String data) {
        return encryptionController.encrypt(data);
    }
    protected static String decrypt(String data) {
        return encryptionController.decrypt(data);
    }
}
