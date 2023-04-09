package com.example.taxilink.TaxiSessionController;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.RequestResultPageBinding;

import java.util.ArrayList;
import java.util.List;

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

        List<String> availableCarpools = new ArrayList<String>();

        // fetch array list of available taxis here -- dummy values for now
        availableCarpools.add("Taxi 1");
        availableCarpools.add("Taxi 2");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                RequestResultPage.this.getContext(), android.R.layout.simple_list_item_1, availableCarpools );

        requestResults.setAdapter(arrayAdapter);
    }
}

