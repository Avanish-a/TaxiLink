package com.example.taxilink.AppData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.BaseEntity.Carpool;
import com.example.taxilink.R;
import com.example.taxilink.databinding.OfferLinkPageBinding;

import java.util.HashMap;

public class OfferInfo extends Fragment {

    private HashMap<String, Carpool> activePools;
    private HashMap<String, Carpool> inactivePools;

    private OfferLinkPageBinding binding;

    public void addOffer(Carpool carpool, boolean status) {
        if (status) {
            activePools.put(carpool.getCarpoolID(), carpool);
        }
        else  {
            inactivePools.put(carpool.getCarpoolID(), carpool);
        }
    }
    public Carpool getOffer(String carpoolID, boolean status) {
        if (status) {
            return activePools.get(carpoolID);
        }
        else  {
            return inactivePools.get(carpoolID);
        }
    }

    private String generateOfferID() {
        return "";
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = OfferLinkPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.offerBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OfferInfo.this)
                        .navigate(R.id.action_OfferLink_to_HomePage);
            }
        });

    }

}
