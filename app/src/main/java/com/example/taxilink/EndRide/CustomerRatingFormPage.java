package com.example.taxilink.EndRide;

import java.util.Map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.FragmentFirstBinding;



public class CustomerRatingFormPage extends Fragment {

//    private CustomerRatingFormPageBinding binding;
    private RatingBar ratingBar;
    private Button submitButton;

    public CustomerRatingFormPage(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.rating_page, container, false);

        ratingBar = view.findViewById(R.id.rating_bar);
        submitButton = view.findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                Toast.makeText(getActivity(), "Thanks for rating your person " + rating + " stars!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


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
}
