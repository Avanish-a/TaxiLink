package com.example.taxilink.Database;

import com.example.taxilink.EncryptionController.DataEncryption;
import com.example.taxilink.EncryptionController.RSAEncryption.RSA;

import java.io.File;
import java.util.ArrayList;

public class CustomerDB {
    private DataEncryption encryption = new RSA();
    private ArrayList<String> attributes = new ArrayList<String>();
    private ArrayList<String> custIDs = new ArrayList<String>();
    private File db;

    public static void insert(String attrID, String custID) {

    }

    public static void delete(String attrID, String custID) {

    }

    public static void update(String attrID, String custID) {

    }

    public static ArrayList<String> acquire(String attrID, String custID) {
        return new ArrayList<String>();
    }

    private void addAttr(String attrID) {

    }

    private void removeAttr(String attrID) {

    }

}
