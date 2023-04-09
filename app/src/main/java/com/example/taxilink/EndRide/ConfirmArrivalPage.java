package com.example.taxilink.EndRide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taxilink.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.taxilink.R;

public class ConfirmArrivalPage extends AppCompatActivity {
    Boolean endStatus;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_arrival);
        confirmButton = findViewById(R.id.confirm_btn);

        // Will have to add in Travis's navigation stuff
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Confirmed Arrival");
            }
        });


    }



    private String handleTouch(){
        return "Handle Touch pressed";
    }
}
