package com.example.taxilink.TaxiSessionController;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.HomePageBinding;

public class HomePage extends Fragment {
    private HomePageBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = HomePageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.offerLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.taxilink.TaxiSessionController.HomePage.this)
                        .navigate(R.id.action_HomePage_to_OfferLink);
            }
        });
        binding.requestLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.taxilink.TaxiSessionController.HomePage.this)
                        .navigate(R.id.action_HomePage_to_RequestLink);
            }
        });
        binding.ConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.taxilink.TaxiSessionController.HomePage.this)
                        .navigate(R.id.action_HomePage_to_ConfirmArrivalPage);
            }
        });
    }
}
