package com.example.taxilink.RideInformation;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GeocodingTask extends AsyncTask<String,Void, String> {
    @Override
    protected String doInBackground(String... params) {
        String address = params[0];
        String apiKey = params[1];
        String latLng = null;

        OkHttpClient client = new OkHttpClient();
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + apiKey;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            JSONObject jsonObject = new JSONObject(json);

            if (jsonObject.has("results") && jsonObject.getJSONArray("results").length() > 0) {
                JSONObject location = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
                latLng = location.getString("lat") + "," + location.getString("lng");
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return latLng;
    }

    @Override
    protected void onPostExecute(String latLng) {
        // Use the latLng result here
    }
}
