package com.example.taxilink.LoginController;

import com.example.taxilink.EncryptionController.RSAEncryption.RSA;

public class LoginController {
    public static boolean login(String emailRSA, String passRSA) {
        String email = RSA.decrypt(emailRSA);
        String pass = RSA.decrypt(passRSA);

        // temp conditional
        if (email == "admin" && pass == "password") {
            return true;
        }

        return false;
    }
}
