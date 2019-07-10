package com.example.artsy.ui;

//import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.artsy.R;
import com.example.artsy.SavedArtListActivity;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.welcomeButton)
    Button mWelcomeButton;
    @BindView(R.id.artsyTextView)
    TextView mArtsyTextView;
    @BindView(R.id.savedArtsButton)
    Button mSavedArtsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface adalgisaFont = Typeface.createFromAsset(getAssets(), "fonts/Adalgisa Personal Use.ttf");
        mArtsyTextView.setTypeface(adalgisaFont);

        mWelcomeButton.setOnClickListener(this);
        mSavedArtsButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View v) {
        if (v == mWelcomeButton) {
            Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, ArtsActivity.class);
            startActivity(intent);
        }

        if (v == mSavedArtsButton) {
            Intent intent = new Intent(MainActivity.this, SavedArtListActivity.class);
            startActivity(intent);
        }

    }
}


