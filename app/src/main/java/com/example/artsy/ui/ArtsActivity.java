package com.example.artsy.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.artsy.R;
import com.example.artsy.adapters.ArtListAdapter;
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
    @BindView(R.id.recyclerView)RecyclerView mRecyclerView;
    ListView mListView;
    private ArtListAdapter mAdapter;
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
                        mAdapter = new ArtListAdapter(getApplicationContext(), mArtsies);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(ArtsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}