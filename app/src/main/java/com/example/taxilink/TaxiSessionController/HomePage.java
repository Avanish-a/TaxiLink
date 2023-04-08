package com.example.taxilink.TaxiSessionController;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taxilink.R;
import com.google.android.material.button.MaterialButton;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        MaterialButton requestLinkBtn = (MaterialButton) findViewById(R.id.requestLinkBtn);

        requestLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), RequestLinkPage.class));
            }
        });
    }
}
