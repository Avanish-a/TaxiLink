package com.example.taxilink.LoginController;

import com.example.taxilink.EncryptionController.RSAEncryption.RSA;

public class LoginController {
    private static RSA encryptionController = new RSA();
    public static String login(String emailRSA, String passRSA) {
        String email = decrypt(emailRSA);
        String pass = decrypt(passRSA);
        // temp conditional
        if (email.equals("admin") && pass.equals("password")) {
            String customerID = "12345678"; // will use actual customerID depending on DB
            return customerID;
        }
        return null;
    }

    protected static String encrypt(String data) {
        return encryptionController.encrypt(data);
    }
    protected static String decrypt(String data) {
        return encryptionController.decrypt(data);
    }
}
