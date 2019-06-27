package com.example.artsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mWelcomeButton;
    private TextView mArtsyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArtsyTextView = (TextView) findViewById(R.id.artsyTextView);
        Typeface adalgisaFont = Typeface.createFromAsset(getAssets(), "fonts/Adalgisa Personal Use.ttf");
        mArtsyTextView.setTypeface(adalgisaFont);
        mWelcomeButton = (Button) findViewById(R.id.welcomeButton);
        mWelcomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}
