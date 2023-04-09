package com.example.taxilink.EndRide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.DisplayFarePageBinding;

import java.util.Map;

public class CustomerFare extends Fragment {

    Double fare;
    Map<String, String> rideInformation;

    private Double calculateFare(Map<String, String> rideInformation){
        fare = 100.00;
        return fare;
    }
    private DisplayFarePageBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DisplayFarePageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.displayNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CustomerFare.this)
                        .navigate(R.id.action_DisplayFarePage_to_RatingPage);
            }
        });
    }

}
