package com.example.taxilink.RideInformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.MapsDirectionPageBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

public class DirectionPage extends Fragment implements OnMapReadyCallback{
    private MapsDirectionPageBinding binding;
    private GoogleMap mMap;
    private MapView mapView;
    private GeoApiContext geoApiContext;




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

    }

    private void getDirections(){
        String endLocation = "1280 Main Street West, Hamilton, ON";
        String startLocation = "University Plaza, Osler Drive, Dundas, ON";

        DirectionsApi.newRequest(geoApiContext)
                .mode(TravelMode.DRIVING)
                .origin(startLocation)
                .destination(endLocation)
                .setCallback(new PendingResult.Callback<DirectionsResult>() {
                    @Override
                    public void onResult(DirectionsResult result) {
                        if(result.routes.length > 0){
                            mMap.clear();
                            mMap.addMarker(new MarkerOptions().position(new LatLng(result.routes[0].legs[0].startLocation.lat, result.routes[0].legs[0].startLocation.lng)).title(result.routes[0].legs[0].startAddress));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(result.routes[0].legs[0].endLocation.lat, result.routes[0].legs[0].endLocation.lng)).title(result.routes[0].legs[0].endAddress));

                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        System.out.println(" a failure has occurred");
                    }
                });
    }

}
