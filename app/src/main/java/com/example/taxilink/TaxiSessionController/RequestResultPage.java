package com.example.taxilink.TaxiSessionController;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.BaseEntity.Request;
import com.example.taxilink.R;
import com.example.taxilink.RequestLinkController.RequestLinkController;
import com.example.taxilink.databinding.RequestResultPageBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RequestResultPage extends Fragment{

    private RequestResultPageBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = RequestResultPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView requestResults = binding.requestResults;

        List<String> availableCarpools = RequestLinkController.getCarpools(RequestLinkPage.customerDestination);

        if (!availableCarpools.isEmpty()) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    RequestResultPage.this.getContext(), android.R.layout.simple_list_item_1, availableCarpools);
            requestResults.setAdapter(arrayAdapter);
        }
        else {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    RequestResultPage.this.getContext(), android.R.layout.simple_list_item_1, availableCarpools);

            requestResults.setAdapter(arrayAdapter);

            Toast.makeText(RequestResultPage.this.getContext(),
                    "No matching carpools. A taxi will be called for you.", Toast.LENGTH_SHORT).show();
        }

        requestResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(RequestResultPage.this.getContext(),
                        "Request sent for " + availableCarpools.get(i), Toast.LENGTH_SHORT).show();

                try {
                    TimeUnit.SECONDS.sleep(8);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                Toast.makeText(RequestResultPage.this.getContext(),
                        "Your Request for " + availableCarpools.get(i) +
                                " has been accepted.", Toast.LENGTH_SHORT).show();

                RequestLinkController.updateOffer("T01");

                NavHostFragment.findNavController(RequestResultPage.this)
                        .navigate(R.id.action_RequestResultPage_to_MapsDirectionPage);
            }
        });
    }
}

