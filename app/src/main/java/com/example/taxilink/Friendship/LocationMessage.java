package com.example.taxilink.Friendship;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taxilink.databinding.ActivityLocationMessageBinding;

public class LocationMessage extends Fragment {

    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    private ActivityLocationMessageBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = ActivityLocationMessageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("myCh", "my channel", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = (NotificationManager) getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(LocationMessage.this.requireContext(), "myCh")
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setContentTitle("Heads Up!")
                .setContentText("Jeff Winger is on his way to McMaster University!");

        notification = builder.build();
        notificationManagerCompat = NotificationManagerCompat.from(LocationMessage.this.requireContext());

        if (ActivityCompat.checkSelfPermission(LocationMessage.this.requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManagerCompat.notify(1, notification);
    }
}