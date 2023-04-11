package com.example.taxilink.RideInformation;

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


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.MapsDirectionPage;
import com.example.taxilink.R;
import com.example.taxilink.databinding.MapsDirectionPageBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.android.PolyUtil;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import java.util.List;

public class DirectionPage extends Fragment implements OnMapReadyCallback{
    private MapsDirectionPageBinding binding;
    private GoogleMap mMap;
    private MapView mapView;
    private GeoApiContext geoApiContext;

    NotificationManagerCompat notificationManagerCompat;
    Notification notification;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = MapsDirectionPageBinding.inflate(inflater, container, false);
        mapView = binding.mapView;
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
        return binding.getRoot();

    }

    // Add the required onMapReady() method
    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;
        LatLng location = new LatLng(43.2622445, -79.9202861); // Centering location
        float zoomLevel = 13.0f; // Zoom level between 2.0 (zoomed out) and 21.0 (zoomed in)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, zoomLevel));
        getDirections();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicking Button");
                NavHostFragment.findNavController(DirectionPage.this)
                        .navigate(R.id.action_mapsDirectionPage_to_HomePage);
            }
        });

        geoApiContext = new GeoApiContext.Builder()
                .apiKey("AIzaSyC42oZdvHGae7r2JWS9jZ3mKA1FV37zSEU")
                .build();

        binding.locMessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("myCh", "my channel", NotificationManager.IMPORTANCE_HIGH);
                    NotificationManager manager = (NotificationManager) getActivity().getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }

                NotificationCompat.Builder builder = new NotificationCompat.Builder(DirectionPage.this.requireContext(), "myCh")
                        .setSmallIcon(android.R.drawable.stat_notify_more)
                        .setContentTitle("Heads Up!")
                        .setContentText("Jeff Winger is on his way to McMaster University!");

                Notification notification = builder.build();
                notificationManagerCompat = NotificationManagerCompat.from(DirectionPage.this.requireContext());

                if (ActivityCompat.checkSelfPermission(DirectionPage.this.requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                notificationManagerCompat.notify(1, notification);
            }
        });

    }

    private void getDirections(){
        String endLocation = "1280 Main Street West, Hamilton, ON";
        String startLocation = "University Plaza, Osler Drive, Dundas, ON";
        String apiKey = "AIzaSyC42oZdvHGae7r2JWS9jZ3mKA1FV37zSEU";

        DirectionsApi.newRequest(geoApiContext)
                .mode(TravelMode.DRIVING)
                .origin(startLocation)
                .destination(endLocation)
                .setCallback(new PendingResult.Callback<DirectionsResult>() {
                    @Override
                    public void onResult(DirectionsResult result) {
                        System.out.println("this is the results"+result);
                        if(result.routes.length > 0){
                            mMap.clear();
                            mMap.addMarker(new MarkerOptions().position(new LatLng(result.routes[0].legs[0].startLocation.lat, result.routes[0].legs[0].startLocation.lng)).title(result.routes[0].legs[0].startAddress));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(result.routes[0].legs[0].endLocation.lat, result.routes[0].legs[0].endLocation.lng)).title(result.routes[0].legs[0].endAddress));

                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        String startLatLng =  addressToLatLng(startLocation, apiKey);
                        String endLatLng = addressToLatLng(endLocation,apiKey);
                        System.out.println(startLatLng);
                        System.out.println(endLatLng);

                        double startLat = 43.2583338;
                        double startLog = -79.9423619;
                        double endLat = 43.2622445;
                        double endLog = -79.9202861;

                        getActivity().runOnUiThread(new Runnable(){
                            @Override
                            public void run(){
                                mMap.addMarker(new MarkerOptions().position(new LatLng(startLat, startLog)).title(startLocation));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(endLat, endLog)).title(endLocation));
                                drawPolyLines();
                                System.out.println(" a failure has occurred");
                            }

                        });

                    }
                });
    }

    private static String addressToLatLng(String address, String apiKey) {
        String latLng = "";
        try {
            GeocodingTask task = new GeocodingTask();
            latLng = task.execute(address, apiKey).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (latLng.isEmpty()) {
            // Return default location
            return "-33.8670522,151.1957362"; // Sydney, Australia (default)
        } else {
            return latLng;
        }
    }

    // method to draw the polylines
    public void drawPolyLines(){
        // Adding the blue polyline
        String encodedPolyline = "s{_gGtv|fNODEWI_@q@w@Oy@?m@Pc@@YXm@hAiDLm@p@kDxAkNLiAN{CCaGMqQO}Na@_`@Co@DMAeB?WQA[DUFc@P{@j@s@h@u@f@o@TgANqALkAJ_@E}BJuBJcBHMGGKAq@r@C^H`@Ld@Bf@GC_DFsBCQEEKEs@DAyC";
        List<LatLng> decodedPolyline = PolyUtil.decode(encodedPolyline);
        PolylineOptions polylineOptions = new PolylineOptions();

        for(LatLng point: decodedPolyline){
            polylineOptions.add(point);
        }

        polylineOptions.width(10);
        mMap.addPolyline(polylineOptions);


    }



}
