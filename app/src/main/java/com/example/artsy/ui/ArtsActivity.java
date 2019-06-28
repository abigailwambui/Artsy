package com.example.artsy.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.artsy.R;
import com.example.artsy.models.Artsy;
import com.example.artsy.services.ArtsyService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ArtsActivity extends AppCompatActivity {
    public static final String TAG = ArtsActivity.class.getSimpleName();
    @BindView(R.id.listView)
    ListView mListView;
    public ArrayList<Artsy> mArtsies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts);
        ButterKnife.bind(this);
        getArts();
    }

    private void getArts() {
        final ArtsyService artsyService = new ArtsyService();
        artsyService.findArts(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mArtsies = artsyService.processResults(response);
                ArtsActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        String[] artsyDescription = new String[mArtsies.size()];
                        for (int i = 0; i < artsyDescription.length; i++) {
                            artsyDescription[i] = mArtsies.get(i).getDescription();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(ArtsActivity.this,
                                android.R.layout.simple_list_item_1, artsyDescription);
                        mListView.setAdapter(adapter);
                        for (Artsy art : mArtsies) {
                            Log.d(TAG, "Description: " + art.getDescription());
                            Log.d(TAG, "PrimaryImageUrl: " + art.getPrimaryImageUrl());
                            Log.d(TAG, "Culture: " + art.getCulture());
                            Log.d(TAG, "Title: " + art.getTitle());
                            Log.d(TAG, "CreditLine " + art.getCreditLine());
                            Log.d(TAG, "Medium" + art.getMedium());


                        }


                    }
                });
            }

        });
    }
}