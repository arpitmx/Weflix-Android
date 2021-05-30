package com.india.WEFLIX;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MovieHomePage extends AppCompatActivity {

    ImageView posterImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_home_page);

        posterImage = findViewById(R.id.posterImage);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int posterimage_Resource = bundle.getInt("poster");
            posterImage.setImageResource(posterimage_Resource);

        }


    }
}