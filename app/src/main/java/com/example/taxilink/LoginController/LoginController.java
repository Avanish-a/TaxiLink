package com.example.taxilink.LoginController;

import com.example.taxilink.EncryptionController.RSAEncryption.RSA;

public class LoginController {
    static RSA encryptionController = new RSA();
    public static String login(String emailRSA, String passRSA) {
        String email = encryptionController.decrypt(emailRSA);
        String pass = encryptionController.decrypt(passRSA);

        // temp conditional
        if (email.equals("admin") && pass.equals("password")) {
            String customerID = "12345678";
            return customerID;
        }

        return null;
    }
}
