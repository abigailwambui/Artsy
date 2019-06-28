package com.example.artsy;

import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class ArtsyService {

    public static void findArts( Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();
    }
}
