package com.india.WEFLIX;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.MotionEventCompat;
import androidx.media2.exoplayer.external.C;
import androidx.media2.exoplayer.external.audio.AudioFocusManager;
import androidx.media2.exoplayer.external.source.hls.HlsMediaSource;
import androidx.media2.exoplayer.external.util.Util;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.firebase.platforminfo.UserAgentPublisher;

import java.util.concurrent.TimeUnit;

import static com.google.android.exoplayer2.Player.STATE_BUFFERING;
import static com.google.android.exoplayer2.Player.STATE_ENDED;
import static com.google.android.exoplayer2.Player.STATE_IDLE;
import static com.google.android.exoplayer2.Player.STATE_READY;

public class VideoPlayer extends AppCompatActivity {

    PlayerView playerView;
    SimpleExoPlayer player;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;
    Runnable updatePlayer;
    ConstraintLayout loadingPanel;
    private Handler mainHandler;
    FrameLayout frameLayout;
    TextView movie_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        // lock the current device orientation

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        mainHandler = new Handler();

        loadingPanel = (ConstraintLayout) findViewById(R.id.shit);
        playerView = findViewById(R.id.video_view);
        frameLayout = findViewById(R.id.video_frameLayout);
        movie_title = findViewById(R.id.movie_title);
        movie_title.setVisibility(View.INVISIBLE);

    }

    void initiatePlayer(){
      //  BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder(getApplicationContext()).build();
        player =  ExoPlayerFactory.newSimpleInstance(getApplicationContext());


       // https://firebasestorage.googleapis.com/v0/b/basicly-beta.appspot.com/o/Interstellar.2014.720p.BluRay.x264.YIFY.mp4?alt=media&token=dcab3518-a397-4ddf-b3b9-32b43d814377
       // https://firebasestorage.googleapis.com/v0/b/basicly-beta.appspot.com/o/Insidious.Chapter.3.2015.720p.HC.HDRip.700MB.MkvCage.mkv?alt=media&token=26a7f68c-6518-4450-8dd7-9c517def2674
       //https://firebasestorage.googleapis.com/v0/b/basicly-beta-74f80.appspot.com/o/MoviesRush.in_7..A.N9htmr.n.E1m.Strt.2010.B1ry.D1.Ad.Hnd.En91sh.480p%20(1).mkv?alt=media&token=d80aef6a-560c-4796-a4e1-e3d36a6afe11
      //  http://pairing:593AEA65856E6CF6A1CFF3725E6316C24396E922@127.0.0.1:49120/proxy?sid=3&file=0&token=593AEA65856E6CF6A1CFF3725E6316C24396E922&pairing=593AEA65856E6CF6A1CFF3725E6316C24396E922&service=STREAMING


        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String url = bundle.getString("url");
        Toast.makeText(getApplicationContext(),"WEFLIX PRESENTS : A NIGHTMARE ON ELM STREET ",Toast.LENGTH_LONG).show();
        Uri video = Uri.parse(url);
        DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("video");
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

        // MediaSource mediaSource = HlsMediaSource.Factory(new DefaultHttpDataSourceFactory(extractorsFactory)).createMediaSource(video);
        MediaSource mediaSource = new ExtractorMediaSource(video, dataSourceFactory, extractorsFactory, null, null);
        playerView.setPlayer(player);

        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playbackPosition);
        player.prepare(mediaSource, false, false);
        player.setPlayWhenReady(true);
       loadingPanel.setVisibility(View.VISIBLE);



       frameLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               movie_title.setVisibility(View.VISIBLE);

           }
       });


      player.addListener(new ExoPlayer.EventListener() {


            @Override
            public void onTimelineChanged(Timeline timeline, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {}

            @Override
            public void onLoadingChanged(boolean isLoading) {}


            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playbackState == ExoPlayer.STATE_BUFFERING) {
                    loadingPanel.setVisibility(View.VISIBLE);
                } else {
                                       loadingPanel.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {}

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {}
                           });



    }




       // mainHandler.postDelayed(updatePlayer, 200);




   /* {
       updatePlayer = new Runnable() {
            @Override
            public void run() {
                switch (player.getPlaybackState()) {
                    case STATE_BUFFERING:
                        loadingPanel.setVisibility(View.VISIBLE);
                        Log.d("VideoPlayer", "Buffering ");
                        break;
                    case STATE_ENDED:
                        finish();
                        Log.d("VideoPlayer", "Ended ");
                        break;
                    case STATE_IDLE:
                        loadingPanel.setVisibility(View.GONE);
                        break;
                    case STATE_READY:
                        loadingPanel.setVisibility(View.GONE);
                        Log.d("VideoPlayer", "Buffering Finished ");
                        break;
                    default:
                        break;
                }


            }
        };
    }

*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        player.release();
        finish();

    }

    @Override
    protected void onStop() {
        super.onStop();

        if (Util.SDK_INT >= 24) {
            releasePlayer();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT < 24) {
            releasePlayer();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT >= 24) {
            initiatePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        hideSystemUi();
        if ((Util.SDK_INT < 24 || player == null)) {
            initiatePlayer();
        }
    }

    private void hideSystemUi() {


        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }


    private void releasePlayer() {
        if (playerView != null) {
            playWhenReady =player.getPlayWhenReady();
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            playerView = null;
        }
    }

}