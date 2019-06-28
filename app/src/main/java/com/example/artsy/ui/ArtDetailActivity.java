package com.example.artsy.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.artsy.R;
import com.example.artsy.adapters.ArtPagerAdapter;
import com.example.artsy.models.Artsy;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)ViewPager mViewPager;
    private ArtPagerAdapter adapterViewPager;
    ArrayList<Artsy> mArtsies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_detail);
        ButterKnife.bind(this);

        mArtsies = Parcels.unwrap(getIntent().getParcelableExtra("restaurants"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new ArtPagerAdapter(getSupportFragmentManager(), mArtsies);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}

