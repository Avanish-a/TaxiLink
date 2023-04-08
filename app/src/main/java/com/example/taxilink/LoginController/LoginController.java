package com.example.taxilink.LoginController;

import com.example.taxilink.EncryptionController.RSAEncryption.RSA;

public class LoginController {
    static RSA encryptionController = new RSA();
    public static boolean login(String emailRSA, String passRSA) {
        String email = encryptionController.decrypt(emailRSA);
        String pass = encryptionController.decrypt(passRSA);

        // temp conditional
        if (email.equals("admin") && pass.equals("password")) {
            return true;
        }

        return false;
    }
}
