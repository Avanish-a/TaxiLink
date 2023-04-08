package com.example.taxilink.TaxiSessionController;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.taxilink.R;
import com.google.android.material.button.MaterialButton;

public class RequestLinkPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_link_page);

        TextView destination = (TextView) findViewById(R.id.requestDestinationInput);
        TextView start = (TextView) findViewById(R.id.requestPickupInput);

        MaterialButton submitBtn = (MaterialButton) findViewById(R.id.submitRequestButton);
        MaterialButton cancelBtn = (MaterialButton) findViewById(R.id.cancelRequestButton);
    }
}
