package com.example.taxilink.EncryptionController;


public interface DataEncryption {
    String encrypt(String data);

    String decrypt(String data);
}
