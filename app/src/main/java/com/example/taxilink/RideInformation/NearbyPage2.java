package com.example.taxilink.RideInformation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taxilink.R;
import com.example.taxilink.RideInformation.NearbyPlacesAdapter;
import com.example.taxilink.databinding.NearbyPageBinding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NearbyPage2 extends Fragment {
    Boolean endStatus;

    private NearbyPageBinding binding;
    private String address;
    private String apiKey;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = NearbyPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Using the user's current location
        address = "176 Haddon Avenue South, Hamilton, ON";
        apiKey = "AIzaSyC42oZdvHGae7r2JWS9jZ3mKA1FV37zSEU";

        // use the geocoding api to get the latitude and longitude coordinates for the address
        Geocoder geocoder = new Geocoder((getContext()));
        LatLng latLng = null;
        try {
            List<Address> addresses = geocoder.getFromLocationName(address, 1);
            if (!addresses.isEmpty()) {
                Address firstAddress = addresses.get(0);
                latLng = new LatLng((firstAddress.getLatitude()), firstAddress.getLongitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // new uncoded region
        // Use the places API to retrieve nearby places
        if (latLng != null) {
            System.out.println("Hi");
            Places.initialize(getContext(), apiKey);
            PlacesClient placesClient = Places.createClient(getContext());
            List<Place.Field> placesFields = Arrays.asList(Place.Field.NAME, Place.Field.ADDRESS);
            FindCurrentPlaceRequest request = FindCurrentPlaceRequest.newInstance(placesFields);

            int my_var = (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION));
            if (my_var != PackageManager.PERMISSION_GRANTED) {
                System.out.println("Stuck in here");
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            System.out.println("made it out?");
            Task<FindCurrentPlaceResponse> placeResponse = placesClient.findCurrentPlace(request);
            placeResponse.addOnSuccessListener(response -> {

                System.out.println("in this code here");
                List<String> nearbyPlaces = response.getPlaceLikelihoods().stream()
                        .map(placeLikelihood -> placeLikelihood.getPlace())
                        .map(place -> place.getName()+ "\n" + place.getAddress())
                        .collect(Collectors.toList());

                System.out.println(nearbyPlaces);

//                // Display the list of nearby places using a recycler View
//                //RecyclerView recyclerView = view.findViewById(R.id.recycler_view); // changed but can put back in
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                NearbyPlacesAdapter adapter = new NearbyPlacesAdapter(nearbyPlaces);
//                recyclerView.setAdapter(adapter);
            });


        }


        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("CLicked home button");
                NavHostFragment.findNavController(NearbyPage2.this)
                        .navigate(R.id.action_NearbyPage_to_HomePage);
            }
        });
    }
}