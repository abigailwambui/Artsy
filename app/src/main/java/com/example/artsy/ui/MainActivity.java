package com.example.artsy.ui;

//import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.artsy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.welcomeButton) Button mWelcomeButton;
    @BindView(R.id.artsyTextView) TextView mArtsyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface adalgisaFont = Typeface.createFromAsset(getAssets(), "fonts/Adalgisa Personal Use.ttf");
        mArtsyTextView.setTypeface(adalgisaFont);

        mWelcomeButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ArtsActivity.class);
                startActivity(intent);
            }

    }

