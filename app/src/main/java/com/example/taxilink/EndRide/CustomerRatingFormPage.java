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
import com.example.taxilink.databinding.RatingPageBinding;

import java.util.Map;

public class CustomerRatingFormPage extends Fragment {
    Map<String, String> customerRatingInformation;

    private Map<String, String> addRating(String rating){
        return customerRatingInformation;
    }

    private Map<String, String> saveCustomeResponse(){
        return customerRatingInformation;
    }

    private void submitRating(Map<String, String> customerRatingInformation){
        System.out.println("test");
    }

    private String handleTouch(){
        return "Touch done";
    }
    private RatingPageBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = RatingPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ratingNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CustomerRatingFormPage.this)
                        .navigate(R.id.action_RatingPage_to_HomePage);
            }
        });
    }
}