package com.example.taxilink.EndRide;

import java.util.Map;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.taxilink.R;

public class CustomerFare extends AppCompatActivity{

    private double fare;
    private double fareRate;
    private double distance;
    Map<String, String> rideInformation;

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
    }

    // make an Onclick function

    private double calculateFare(double distance, double fareRate){
        // use the maps ride info function
        fare = distance * fareRate;
        return fare;
    }

}
