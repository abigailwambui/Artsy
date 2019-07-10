package com.example.artsy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.artsy.adapters.FirebaseArtViewHolder;
import com.example.artsy.models.Artsy;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedArtListActivity extends AppCompatActivity {
    private DatabaseReference mArtsyReference;
    private FirebaseRecyclerAdapter<Artsy, FirebaseArtViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView)RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts);
        ButterKnife.bind(this);
        mArtsyReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ARTS);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Artsy> options =
                new FirebaseRecyclerOptions.Builder<Artsy>()
                        .setQuery(mArtsyReference, Artsy.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Artsy, FirebaseArtViewHolder>(options) {


            @Override
            protected void onBindViewHolder(@NonNull FirebaseArtViewHolder firebaseArtViewHolder, int position, @NonNull Artsy artsy) {
                firebaseArtViewHolder.bindArtsy(artsy);
            }

            @NonNull
            @Override
            public FirebaseArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_list_item, parent, false);
                return new FirebaseArtViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}
