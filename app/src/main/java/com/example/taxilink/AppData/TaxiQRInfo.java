package com.example.taxilink.AppData;

import java.util.HashMap;

public class TaxiQRInfo {

    private final HashMap<String, String> QRtoID = new HashMap<>();

    private void addQR(String qr, String taxiID) {
        QRtoID.put(qr, taxiID);
    }

    public String getID(String qr) {
        return QRtoID.get(qr);
    }

}
