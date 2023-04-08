package com.example.taxilink.RequestLinkController;
import com.example.taxilink.EncryptionController.RSAEncryption.RSA;
import java.util.ArrayList;
import java.util.List;

public class RequestLinkController {
    private static RSA encryptionController = new RSA();
    public List<String> getCarpools(String destination) {
        List<String> availCarpools = new ArrayList<String>();

        // logic to access DB and fetch carpools

        return availCarpools;
    }
    protected String encrypt(String data) {
        return encryptionController.encrypt(data);
    }
    protected String decrypt(String data) {
        return encryptionController.decrypt(data);
    }
}
