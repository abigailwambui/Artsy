package com.example.artsy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artsy.R;
import com.example.artsy.models.Artsy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtListAdapter extends RecyclerView.Adapter<ArtListAdapter.ArtViewHolder>{
    public ArrayList<Artsy> mArtsies = new ArrayList<>();
    private Context mContext;

    public ArtListAdapter(Context context, ArrayList<Artsy> mArtsies) {
        mContext = context;
        mArtsies = artsies;
    }

    @Override
    public ArtListAdapter.ArtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_list_item, parent, false);
        ArtViewHolder viewHolder = new ArtViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mArtsies.size();
    }


    public class ArtViewHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.artImageView)ImageView mArtImageView;
        @BindView(R.id.artDescriptionTextView)TextView mDescriptionTextView;
        @BindView(R.id.titleTextView) TextView mTitleTextView;
        @BindView(R.id.cultureTextView) TextView mCultureTextView;

        private Context mContext;

        public ArtViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

            public void bindArt(Artsy art) {
                mDescriptionTextView.setText(art.getDescription());
                mTitleTextView.setText(art.getTitle());
                mCultureTextView.setText(art.getCulture());
            }
        }
    }
