package com.india.WEFLIX;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StreamingNowMainPage extends AppCompatActivity {

    TextView stText;
    ImageView stImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_now_main_page);


        stText = findViewById(R.id.stText);
        stImage = findViewById(R.id.stImage);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            int ImageResource = bundle.getInt("SICON");
            stImage.setImageResource(ImageResource);
        }
if (bundle != null){
    String title = bundle.getString("STEXT");
    stText.setText(title);
}



    }



}