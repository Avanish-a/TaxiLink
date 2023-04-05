package com.example.taxilink.AppData;

import com.example.taxilink.BaseEntity.Request;
import java.util.HashMap;

public class RequestInfo {
    private HashMap<String, Request> requests = new HashMap<String, Request>();

    public void addRequest(Request request) {
        requests.put(request.getReqID(), request);
    }
    public Request getRequest(String reqID) {
        return requests.get(reqID);
    }

    private String generateReqID() {
        return "";
    }

}
