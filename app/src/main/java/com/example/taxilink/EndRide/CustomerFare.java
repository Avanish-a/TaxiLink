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
import com.example.taxilink.databinding.DisplayFarePageBinding;

import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.taxilink.R;

public class CustomerFare extends AppCompatActivity{

    private double fare;
    private double fareRate;
    private double distance;
    Map<String, String> rideInformation;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_fare_page);

        // get the distance traveled and fare rate from the previous activity or user input
        distance = 10.5;
        fareRate = 2.5;

        // calculate the fare based on distance and fare rate
        fare = calculateFare(distance, fareRate);

        // display the total fare on the screen
        TextView fareTextView = findViewById(R.id.fareValue);
        fareTextView.setText(String.format("$%.2f", fare));

        // code for clicking the button
        nextButton = findViewById(R.id.display_next);

        // Set a click listener to the button - will have to change based on what Travis gives me
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to navigate to the next page goes here
                Intent intent = new Intent(CustomerFare.this, CustomerRatingFormPage.class);
                startActivity(intent);
            }
        });


    }


    private double calculateFare(double distance, double fareRate){
        // use the maps ride info function
        fare = distance * fareRate;
        return fare;
    }


}
