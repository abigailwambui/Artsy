package com.example.artsy.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artsy.R;
import com.example.artsy.models.Artsy;
import com.example.artsy.ui.ArtDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtListAdapter extends RecyclerView.Adapter<ArtListAdapter.ArtViewHolder>{
    public ArrayList<Artsy> mArtsies = new ArrayList<>();
    private Context mContext;

    public ArtListAdapter(Context context, ArrayList<Artsy> mArtsies) {
        mContext = context;
        this.mArtsies = mArtsies;
    }

    @Override
    public ArtListAdapter.ArtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_list_item, parent, false);
        ArtViewHolder viewHolder = new ArtViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ArtListAdapter.ArtViewHolder holder, int position) {
        holder.bindArt(mArtsies.get(position));
    }

    @Override
    public int getItemCount() {
        return mArtsies.size();
    }


    public class ArtViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.artImageView)ImageView mArtImageView;
        @BindView(R.id.artDescriptionTextView)TextView mDescriptionTextView;
        @BindView(R.id.titleTextView) TextView mTitleTextView;
        @BindView(R.id.cultureTextView) TextView mCultureTextView;

        private Context mContext;

        public ArtViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ArtDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("restaurants", Parcels.wrap(mArtsies));
            mContext.startActivity(intent);
        }

            public void bindArt(Artsy art) {
                Picasso.get().load(art.getPrimaryImageUrl()).into(mArtImageView);
                mDescriptionTextView.setText(art.getDescription());
                mTitleTextView.setText(art.getTitle());
                mCultureTextView.setText(art.getCulture());
            }
        }
    }
