package com.india.WEFLIX;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

public class HorrorMovie extends AppCompatActivity {

    ImageButton trailerButton , Play_Movie_Button;
    CheckBox checkBox1,checkBox2,checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horror_movie);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        trailerButton = findViewById(R.id.movie_play_trailer);
        Play_Movie_Button = findViewById(R.id.movie_play_button);

        Play_Movie_Button.setEnabled(false);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);




        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Play_Movie_Button.setEnabled(true);
                    Toast.makeText(HorrorMovie.this, "Selected 720p Eng", Toast.LENGTH_LONG).show();
                    Intent i = new Intent();


                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Play_Movie_Button.setEnabled(true);
                    Toast.makeText(HorrorMovie.this, "Selected 720p Hindi", Toast.LENGTH_LONG).show();
                    Intent i = new Intent();

                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Play_Movie_Button.setEnabled(true);
                    Toast.makeText(HorrorMovie.this, "Selected 420p Hindi", Toast.LENGTH_LONG).show();



                }
            }
        });





        trailerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ZuYoEtEI_go")));
                Log.i("Video", "Video Playing....");
                Toast.makeText(HorrorMovie.this, "Selected 720p Eng", Toast.LENGTH_LONG).show();

            }
        });

        Play_Movie_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBox1.isChecked()) {
                    Intent i = new Intent(HorrorMovie.this,VideoPlayer.class);
                    i.putExtra("url","https://firebasestorage.googleapis.com/v0/b/basicly-beta-74f80.appspot.com/o/A.Nightmare.on.Elm.Street.2010.720p.BrRip.x264.BOKUTOX.YIFY.mp4?alt=media&token=bb55df13-49b2-486e-a7ad-8d9c3d7e2f6f");
                    Toast.makeText(HorrorMovie.this, "Opening WeFlix Player : 720p Eng", Toast.LENGTH_LONG).show();

                    startActivity(i);
                }
                else if (checkBox2.isChecked()) {
                    Intent i = new Intent(HorrorMovie.this,VideoPlayer.class);
                    i.putExtra("url","https://firebasestorage.googleapis.com/v0/b/basicly-beta-74f80.appspot.com/o/elm%20hindi.mkv?alt=media&token=3e32479b-c2ea-4fa0-a42c-3f5a347c5833");
                    Toast.makeText(HorrorMovie.this, "Opening WeFlix Player : 720p Hindi", Toast.LENGTH_LONG).show();

                    startActivity(i);
                }
                else if (checkBox3.isChecked()) {
                    Intent i = new Intent(HorrorMovie.this,VideoPlayer.class);
                    i.putExtra("url","https://firebasestorage.googleapis.com/v0/b/basicly-beta-74f80.appspot.com/o/MoviesRush.in_7..A.N9htmr.n.E1m.Strt.2010.B1ry.D1.Ad.Hnd.En91sh.480p%20(1).mkv?alt=media&token=d80aef6a-560c-4796-a4e1-e3d36a6afe11");
                    Toast.makeText(HorrorMovie.this, "Opening WeFlix Player : 420p Hindi", Toast.LENGTH_LONG).show();

                    startActivity(i);
                }else{

                    Toast.makeText(HorrorMovie.this, "Selected resoultion first", Toast.LENGTH_LONG).show();

                }
                    /*else if (checkBox1.isChecked()){

                        Play_Movie_Button.setEnabled(true);
                        try {




                            Log.d("Btn Click", "Clicked on the movie play button");

                    }catch (Exception e){
                            Log.d("@HorrorMovie.java", e.toString());
                        }


                    }
                    else if (checkBox2.isChecked()){
                        Play_Movie_Button.setEnabled(true);
                        try {

                            startActivity(new Intent(HorrorMovie.this, VideoPlayer.class));
                            Toast.makeText(HorrorMovie.this, "Selected 720p Hindi", Toast.LENGTH_LONG).show();


                            Log.d("Btn Click", "Clicked on the movie play button");
                        }catch (Exception e){
                            Log.d("@HorrorMovie.java", e.toString());
                        }


                    }

                    else if (checkBox3.isChecked()){
                        Play_Movie_Button.setEnabled(true);
                        try {

                            startActivity(new Intent(HorrorMovie.this, VideoPlayer.class));
                            Toast.makeText(HorrorMovie.this, "Selected 420p Hindi", Toast.LENGTH_LONG).show();

                            Log.d("Btn Click", "Clicked on the movie play button");
                        }catch (Exception e){
                            Log.d("@HorrorMovie.java", e.toString());
                        }
*/



            }
        });





    }
}