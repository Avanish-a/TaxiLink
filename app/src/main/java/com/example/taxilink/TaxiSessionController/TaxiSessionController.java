package com.example.taxilink.TaxiSessionController;

import com.example.taxilink.EncryptionController.RSAEncryption.RSA;

public class TaxiSessionController {
    private static RSA encryptionController = new RSA();
    protected static String encrypt(String data) {
        return encryptionController.encrypt(data);
    }

    protected static String decrypt(String data) {
        return encryptionController.decrypt(data);
    }
}
