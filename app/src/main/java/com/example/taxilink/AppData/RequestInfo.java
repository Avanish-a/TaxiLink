package com.example.taxilink.AppData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.AccountReg.CreateAccountPage;
import com.example.taxilink.BaseEntity.Request;
import com.example.taxilink.R;
import com.example.taxilink.databinding.RequestLinkPageBinding;

import java.util.HashMap;

public class RequestInfo{
    private HashMap<String, Request> requests = new HashMap<String, Request>();

    private RequestLinkPageBinding binding;


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
