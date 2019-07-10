package com.example.artsy.services;

import com.example.artsy.Constants;
import com.example.artsy.models.Artsy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ArtsyService {

    public static void findArts(Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.ARTSY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.ARTSY_QUERY_PARAMETER, Constants.ARTSY_TOKEN);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Artsy> processResults(Response response) {

        ArrayList<Artsy> artsies = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject artsyJSON = new JSONObject(jsonData);
            JSONArray recordsJSON = artsyJSON.getJSONArray("records");
            if (response.isSuccessful()) {
                for (int i = 0; i < recordsJSON.length(); i++) {
                    JSONObject artJSON = recordsJSON.getJSONObject(i);
                    String description = artJSON.getString("description");
                    String primaryImageUrl = artJSON.getString("primaryimageurl");
                    String culture = artJSON.getString("culture");
                    String title = artJSON.getString("title");
                    String creditLine = artJSON.getString("creditline");
                    String medium = artJSON.getString("medium");

                    if (primaryImageUrl.equals("")) {
                        String secondUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7iK0y8rlPAziH4MckCK7sjQt2tU-yMABG6a-04b7Shtmlkf-1cw";
                        Artsy art = new Artsy(description, secondUrl, culture, title, creditLine, medium);
                        artsies.add(art);
                    }else {
                        Artsy art = new Artsy(description, primaryImageUrl, culture, title, creditLine, medium);
                        artsies.add(art);
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return artsies;
    }
}


