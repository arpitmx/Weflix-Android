package com.india.WEFLIX;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.india.WEFLIX.MainActivity;

import java.util.Objects;

public class SplashScreen extends AppCompatActivity {
    Animation animFadeIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );



        // getSupportActionBar().hide();
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animlefttoright);
        Animation animFadeIn2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadeinanim);

        ImageView tw3 = (ImageView) findViewById(R.id.imageView2);
        TextView tw4 = (TextView) findViewById(R.id.textView2);
        Thread background = new Thread() {
            public void run() {
                try {

                   tw3.startAnimation(animFadeIn2);
                    tw4.startAnimation(animFadeIn2);

                    sleep(4*1000);


                    Intent i=new Intent(getBaseContext(), Homepage.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();

    }
}
