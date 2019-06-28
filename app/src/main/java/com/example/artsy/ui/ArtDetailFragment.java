package com.example.artsy.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.artsy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtDetailFragment extends Fragment {


    public ArtDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_art_detail2, container, false);
    }

}
