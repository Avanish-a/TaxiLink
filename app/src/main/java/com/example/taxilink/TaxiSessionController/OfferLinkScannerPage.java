package com.example.taxilink.TaxiSessionController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taxilink.BaseEntity.Carpool;
import com.example.taxilink.BaseEntity.Profile;
import com.example.taxilink.databinding.OfferLinkPageBinding;
import com.example.taxilink.databinding.OfferLinkScannerPageBinding;
import com.example.taxilink.databinding.RequestLinkPageBinding;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OfferLinkScannerPage extends Fragment {

    private OfferLinkScannerPageBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = OfferLinkScannerPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView destination = binding.offerLinkDestination;
        MaterialButton submitBtn = binding.offerLinkSubmit;

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carpoolID = generateCarpoolID();
                Profile owner = new Profile("123456789", "John", "Smith", "admin@test.com", "01/01/2001", "1234567890");
                List<Profile> members = new ArrayList<Profile>();
                String taxiID = "001";
                Boolean active = true;
                String enteredDestination = destination.getText().toString();
                int capacity = 4;

                Carpool newOffer = new Carpool(carpoolID, owner, taxiID, enteredDestination, capacity);
                // send offer to database
                Toast.makeText(OfferLinkScannerPage.this.getContext(),
                        "Offer created successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String generateCarpoolID() {
        Random rand = new Random();

        int upperbound = 1000;
        int id = rand.nextInt(upperbound);

        return Integer.toString(id);
    }
}
