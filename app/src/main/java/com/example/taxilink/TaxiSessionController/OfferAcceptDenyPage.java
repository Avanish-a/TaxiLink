package com.example.taxilink.TaxiSessionController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.RequestAcceptDenyPageBinding;

import java.util.ArrayList;

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

        TextView customerName = binding.joiningCustomerName;
        TextView customerRating = binding.joiningCustomerRating;
        TextView customerPickupLocation = binding.newJoinPickup;
        TextView distanceAway = binding.distanceAway;
        TextView increasedTripTime = binding.increasedTripTime;
        TextView fareChange = binding.fareChange;

        Button acceptBtn = binding.acceptJoinRequestButton;
        Button denyBtn = binding.denyJoinRequestButton;

        ArrayList<String> customerData = TaxiSessionController.getRequestData("123456789");

        // setting TextViews
        customerName.setText("Customer Name: " + customerData.get(1));
        customerRating.setText("Customer Rating: " + customerData.get(2));
        customerPickupLocation.setText("Pickup Location: " + customerData.get(3));
        distanceAway.setText("Distance Away: " + customerData.get(4));
        increasedTripTime.setText("Increased Trip Time: " + customerData.get(5));
        fareChange.setText("Fare Increase: " + customerData.get(6));

        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OfferAcceptDenyPage.this.getContext(),
                        "Customer was added to Carpool.", Toast.LENGTH_SHORT).show();
                // message dispatcher to increment/add person to ArrayList
                NavHostFragment.findNavController(OfferAcceptDenyPage.this)
                        .navigate(R.id.action_OfferAcceptDenyPage_to_HomePage);
            }
        });

        denyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OfferAcceptDenyPage.this.getContext(),
                        "Customer was rejected from Carpool", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(OfferAcceptDenyPage.this)
                        .navigate(R.id.action_OfferAcceptDenyPage_to_HomePage);
            }
        });
    }
}
