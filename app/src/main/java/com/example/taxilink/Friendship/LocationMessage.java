package com.example.taxilink.Friendship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taxilink.FirstFragment;
import com.example.taxilink.R;

public class LocationMessage extends AppCompatActivity {

    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_message);

        notifyBtn = findViewById(R.id.locationMessageBtn);

        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(LocationMessage.this, "My notification" );
                builder.setContentTitle("Heads Up!");
                builder.setContentText("Arvind is on his way to McMaster University!");
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(LocationMessage.this);
                managerCompat.notify(1, builder.build());

            }
        });

    }
}