package com.example.taxilink.TaxiSessionController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taxilink.databinding.RequestAcceptDenyPageBinding;
import com.example.taxilink.databinding.RequestLinkPageBinding;

public class OfferAcceptDenyPage extends Fragment {

    private RequestAcceptDenyPageBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = RequestAcceptDenyPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // hard coded request
        double fareRate = 2.5;
        double distance = 1;
        double newFare = fareRate*distance;

        TextView customerName = binding.joiningCustomerName;
        TextView customerRating = binding.joiningCustomerRating;
        TextView customerPickupLocation = binding.newJoinPickup;
        TextView distanceAway = binding.distanceAway;
        TextView increasedTripTime = binding.increasedTripTime;
        TextView fareChange = binding.fareChange;

        customerName.setText("John Smith");
        customerRating.setText("4/5");
        customerPickupLocation.setText("West End Pub");
        distanceAway.setText(distance + " km");
        increasedTripTime.setText("5 minutes");
        fareChange.setText("$" + newFare);
    }
}
