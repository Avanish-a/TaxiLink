package com.example.taxilink.AccountReg;

import com.example.taxilink.EncryptionController.RSAEncryption.RSA;

public class AccountRegController {
    private static RSA encryptionController = new RSA();
    public static boolean createAccount(String emailRSA, String passRSA, String firstNameRSA, String lastNameRSA, String phoneRSA) {
        String email = decrypt(emailRSA);
        String pass = decrypt(passRSA);
        String firstName = decrypt(firstNameRSA);
        String lastName = decrypt(lastNameRSA);
        String dob = decrypt(phoneRSA);
        // temp conditional
        if (!email.isEmpty() && !pass.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !dob.isEmpty()) {
            //should create an account if a database is connected
            return true;
        }
        return false;
    }

    protected static String encrypt(String data) {
        return encryptionController.encrypt(data);
    }
    protected static String decrypt(String data) {
        return encryptionController.decrypt(data);
    }
}

