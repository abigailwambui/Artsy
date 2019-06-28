package com.example.artsy.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.artsy.models.Artsy;
import com.example.artsy.ui.ArtDetailFragment;

import java.util.ArrayList;

public class ArtPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Artsy> mArtsies;

    public ArtPagerAdapter(FragmentManager fm, ArrayList<Artsy> artsies) {
        super(fm);
        mArtsies = artsies;
    }

    @Override
    public Fragment getItem(int position) {
        return ArtDetailFragment.newInstance(mArtsies.get(position));
    }

    @Override
    public int getCount() {
        return mArtsies.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mArtsies.get(position).getTitle();
    }
}

