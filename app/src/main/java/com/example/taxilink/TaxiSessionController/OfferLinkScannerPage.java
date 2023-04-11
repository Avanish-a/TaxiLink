package com.example.taxilink.TaxiSessionController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.BaseEntity.Carpool;
import com.example.taxilink.BaseEntity.Profile;
import com.example.taxilink.OfferLinkController.OfferLinkController;
import com.example.taxilink.R;
import com.example.taxilink.databinding.OfferLinkScannerPageBinding;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
        MaterialButton cancelBtn = binding.cancelOfferLinkSubmit;

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!destination.getText().toString().isEmpty()) {
                    String owner = "John Smith";
                    String taxiID = "T01";
                    String enteredDestination = destination.getText().toString();
                    int capacity = 4;

                    String encryptedOwner = TaxiSessionController.encrypt(owner);
                    String encryptedTaxiID = TaxiSessionController.encrypt(taxiID);
                    String encryptedDestination = TaxiSessionController.encrypt(enteredDestination);
                    Carpool newOffer = new Carpool(encryptedOwner, encryptedTaxiID, encryptedDestination, capacity);
                    OfferLinkController.createOffer(newOffer);
                    Toast.makeText(OfferLinkScannerPage.this.getContext(),
                            "Offer created successfully", Toast.LENGTH_SHORT).show();

                    // for hardcoded response
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    NavHostFragment.findNavController(OfferLinkScannerPage.this)
                            .navigate(R.id.action_ScannedOfferLink_to_OfferAcceptDeny);
                }
                else {
                    Toast.makeText(OfferLinkScannerPage.this.getContext(),
                            "Destination cannot be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(OfferLinkScannerPage.this)
                        .navigate(R.id.action_ScannedOfferLink_to_HomePage);
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
