//package com.example.taxilink.RideInformation;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.List;
//
//import android.os.AsyncTask;
//import android.util.Log;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.PolylineOptions;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//
//public class GetDirectionsTask extends AsyncTask<String, Void, String> {
//    private final String TAG = GetDirectionsTask.class.getSimpleName();
//    private final String API_KEY = "YOUR_API_KEY";
//
//    private Context mContext;
//    private OnTaskCompleted mListener;
//
//    public GetDirectionsTask(Context context, OnTaskCompleted listener) {
//        mContext = context;
//        mListener = listener;
//    }
//
//    public GetDirectionsTask() {
//
//    }
//
//    @Override
//    protected String doInBackground(String... params) {
//        String responseString = null;
//        try {
//            String startLocation = params[0];
//            String endLocation = params[1];
//            String urlString = "https://maps.googleapis.com/maps/api/directions/json?" +
//                    "origin=" + URLEncoder.encode(startLocation, "utf-8") +
//                    "&destination=" + URLEncoder.encode(endLocation, "utf-8") +
//                    "&mode=driving&key=" + API_KEY;
//            URL url = new URL(urlString);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream inputStream = connection.getInputStream();
//            StringBuffer buffer = new StringBuffer();
//            if (inputStream == null) {
//                return null;
//            }
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                buffer.append(line + "\n");
//            }
//            if (buffer.length() == 0) {
//                return null;
//            }
//            responseString = buffer.toString();
//        } catch (IOException e) {
//            Log.e(TAG, "Error retrieving directions", e);
//        }
//        return responseString;
//    }
//
//    @Override
//    protected void onPostExecute(String responseString) {
//        super.onPostExecute(responseString);
//        if (responseString != null) {
//            DirectionsJSONParser parser = new DirectionsJSONParser();
//            List<List<HashMap<String, String>>> routes = null;
//            try {
//                routes = parser.parse(new JSONObject(responseString));
//            } catch (JSONException e) {
//                throw new RuntimeException(e);
//            }
//            mListener.onTaskCompleted(routes);
//        }
//    }
//}
//
