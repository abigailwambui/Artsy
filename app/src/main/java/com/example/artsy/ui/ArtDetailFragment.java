package com.example.artsy.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artsy.R;
import com.example.artsy.models.Artsy;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtDetailFragment extends Fragment {


    @BindView(R.id.artImageView)ImageView mImageLabel;
    @BindView(R.id.artDescriptionTextView) TextView mDescriptionLabel;
    @BindView(R.id.cultureTextView)TextView mCultureLabel;
    @BindView(R.id.mediumTextView) TextView mMediumLabel;
    @BindView(R.id.titleTextView) TextView mTitleLabel;
    @BindView(R.id.creditLineTextView) TextView mCreditLineLabel;


    private Artsy mArtsies;

    public static ArtDetailFragment newInstance(Artsy mArtsies) {
        ArtDetailFragment mArtsiesDetailFragment = new ArtDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("art", Parcels.wrap(mArtsies));
        mArtsiesDetailFragment.setArguments(args);
        return mArtsiesDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArtsies = Parcels.unwrap(getArguments().getParcelable("art"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_art_detail2, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mArtsies.getPrimaryImageUrl()).into(mImageLabel);

        mTitleLabel.setText(mArtsies.getTitle());
        mDescriptionLabel.setText(mArtsies.getDescription());
        mCultureLabel.setText(mArtsies.getCulture());
        mMediumLabel.setText(mArtsies.getMedium());
        mCreditLineLabel.setText(mArtsies.getCreditLine());

        return view;
    }
}
