package com.example.taxilink.EndRide;

import java.util.HashMap;
import java.util.Map;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.FragmentFirstBinding;



public class CustomerRatingFormPage extends AppCompatActivity {


    private RatingBar ratingBar;
    private Button submitButton;
    Map<String, String> customerRatingInformation = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_page);

        ratingBar = findViewById(R.id.rating_bar);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
                String message = "Rating: " + rating;
                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
                toast.show();
                System.out.println("clicked: "+rating);

                // you will need to input code for submitting the rating to the database
                customerRatingInformation.put("Customer1",Float.toString(rating));
                submitRating(customerRatingInformation);
            }
        });
    }



//
//    private Map<String, String> addRating(String rating){
//        return customerRatingInformation;
//    }
//
//    private Map<String, String> saveCustomerResponse(){
//        return customerRatingInformation;
//    }

    private void submitRating(Map<String, String> customerRatingInformation){
        System.out.println("Rating submitted to database");
    }

    private String handleTouch(){
        return "Touch done";
    }
}
