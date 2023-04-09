package com.example.taxilink.TaxiSessionController;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.AppData.RequestInfo;
import com.example.taxilink.R;
import com.example.taxilink.databinding.RequestLinkPageBinding;
import com.google.android.material.button.MaterialButton;

public class RequestLinkPage extends Fragment {
    private RequestLinkPageBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = RequestLinkPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView destination = binding.requestDestinationInput;
        TextView start = binding.requestPickupInput;

        MaterialButton submitBtn = binding.submitRequestButton;
        MaterialButton cancelBtn = binding.cancelRequestButton;

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call TaxiSessionController with a method to encrypt and submit data to
                // requestLinkController
                String enteredDestination = destination.getText().toString();
                String enteredPickup = start.getText().toString();
                if (!enteredDestination.isEmpty() && !enteredPickup.isEmpty()) {
                    NavHostFragment.findNavController(RequestLinkPage.this)
                            .navigate(R.id.action_RequestLink_to_RequestResultPage);
                } else {
                    Toast.makeText(RequestLinkPage.this.getContext(), "Please fill in a Destination and pickup location" +
                            " Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RequestLinkPage.this)
                        .navigate(R.id.action_RequestLink_to_HomePage);
            }
        });
    }
}