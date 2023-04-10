package com.example.taxilink.RideInformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.taxilink.R;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NearbyPage extends Fragment {

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nearby_page, container, false);
        mListView = view.findViewById(R.id.listView);
        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Get the user-provided address from the arguments bundle
        String address = "176 Haddon Avenue South, Hamilton, ON";
        String apiKey = "AIzaSyC42oZdvHGae7r2JWS9jZ3mKA1FV37zSEU";

        // Build the URL to fetch nearby places based on the address
        String url = null;
        url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?"
                + "location=" + addressToLatLng(address, apiKey)
                + "&radius=1500"
                + "&type=restaurant"
                + "&key=AIzaSyC42oZdvHGae7r2JWS9jZ3mKA1FV37zSEU";

        // Create an OkHttpClient instance to send the HTTP request
        OkHttpClient client = new OkHttpClient();

        // Build the HTTP request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Send the HTTP request asynchronously
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Handle the failure to connect to the server
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "Failed to connect to server", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Get the response body as a string
                String responseString = response.body().string();

                // Parse the JSON response to a list of strings with location names and addresses
                List<String> placesList = parsePlacesResponse(responseString);

                // Update the UI with the list of places
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, placesList);
                        mListView.setAdapter(adapter);
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

    private static List<String> parsePlacesResponse(String responseString) {
        List<String> placesList = new ArrayList<>();

        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            JSONArray results = jsonResponse.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject place = results.getJSONObject(i);
                String name = place.getString("name");
                String address = place.getString("vicinity");
                String placeInfo = name + "\n" + address;
                placesList.add(placeInfo);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return placesList;
    }
}
