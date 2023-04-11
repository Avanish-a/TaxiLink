package com.example.taxilink.EndRide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.DisplayFarePageBinding;
import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.util.Map;

public class CustomerFare extends Fragment {

    private double fare;
    private double fareRate;
    private double distance;
    private double num_carpooler;
    Map<String, String> rideInformation;

    private double calculateFare(double fareRate, double distance, double num_carpooler){
        fare = fareRate * distance - 1.00*num_carpooler;
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
        fareRate = 2.5;
        distance = 2.6;
        num_carpooler = 1;

        fare = calculateFare(fareRate, distance, num_carpooler);

        // change the text on the screen
        TextView fare_text = binding.fareValue;
        fare_text.setText(String.format("$%.2f",fare));

        binding.displayNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CustomerFare.this)
                        .navigate(R.id.action_DisplayFarePage_to_RatingPage);
            }
        });
    }

}