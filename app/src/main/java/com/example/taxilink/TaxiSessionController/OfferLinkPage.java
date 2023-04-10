package com.example.taxilink.TaxiSessionController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.AppData.OfferInfo;
import com.example.taxilink.R;
import com.example.taxilink.databinding.OfferLinkPageBinding;

public class OfferLinkPage extends Fragment {

    private OfferLinkPageBinding binding;

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
                NavHostFragment.findNavController(OfferLinkPage.this)
                        .navigate(R.id.action_OfferLink_to_HomePage);
            }
        });

    }
}
