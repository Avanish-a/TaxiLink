package com.example.taxilink.TaxiSessionController;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
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

        Button qrScanBtn = binding.offerBtn;
        binding.offerBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OfferLinkPage.this)
                        .navigate(R.id.action_OfferLink_to_HomePage);
            }
        });

        qrScanBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA);
            }

            private ActivityResultLauncher<String> requestPermissionLauncher =
                    registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                        if (isGranted) {
                            // Permission is granted. Continue the action or workflow in your
                            // app.
                            NavHostFragment.findNavController(OfferLinkPage.this)
                                    .navigate(R.id.action_OfferLink_to_QR);
                        } else {
                            // Explain to the user that the feature is unavailable because the
                            // feature requires a permission that the user has denied. At the
                            // same time, respect the user's decision. Don't link to system
                            // settings in an effort to convince the user to change their
                            // decision.
                            Toast.makeText(OfferLinkPage.this.getContext(),
                                    "Please give permissions to continue.", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

    }
}
