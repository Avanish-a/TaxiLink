package com.example.taxilink.EndRide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.ConfirmArrivalBinding;

public class ConfirmArrivalPage extends Fragment {
    Boolean endStatus;

    public void displayMessage(){
        System.out.println("testing");
    }

    private String handleTouch(){
        return "Handle Touch pressed";
    }
    private ConfirmArrivalBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = ConfirmArrivalBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConfirmArrivalPage.this)
                        .navigate(R.id.action_ConfirmArrivalPage_to_DisplayFarePage);
            }
        });
    }
}