package com.example.taxilink.EncryptionController;

import java.io.File;
import java.util.ArrayList;

public class RSAEncryption implements DataEncryption{
    private Integer prvKey;
    private Integer pubKey;
    private File keyFile;

    @Override
    public ArrayList<String> encrypt(ArrayList<String> data) {
        return null;
    }

    @Override
    public ArrayList<String> decrypt(ArrayList<String> data) {
        return null;
    }

    private ArrayList<String> formatData(String data) {
        return null;
    }

    private void generateKeys() {

    }

}
