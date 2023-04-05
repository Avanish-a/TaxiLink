package com.example.taxilink.EncryptionController;

import java.util.ArrayList;

public interface DataEncryption {
    public ArrayList<String> encrypt(ArrayList<String> data);
    public ArrayList<String> decrypt(ArrayList<String> data);
}
