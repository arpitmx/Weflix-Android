package com.india.WEFLIX;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MovieList extends AppCompatActivity {

    RecyclerView movieListRecycler1,movieListRecycler2,movieListRecycler3;
GridView gridView;
Animation animFadeIn1;
    Animation animFadeIn2;
    Animation animFadeIn3;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        animFadeIn1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadeinanim);
        animFadeIn2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadeinanimde2);
        animFadeIn3 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadeinanimde3);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

  movieListRecycler1 = (RecyclerView) findViewById(R.id.AllMovieRecyclerView1);
movieListRecycler2 = (RecyclerView) findViewById(R.id.AllMovieRecyclerView2);
movieListRecycler3 = (RecyclerView) findViewById(R.id.AllMovieRecyclerView3);
    // gridView = findViewById(R.id.gridproductlayout);
    /*    TextView imageVieww = findViewById(R.id.StreamingText);


        ScrollView scrollView = (ScrollView)findViewById(R.id.scrollVieww);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if(scrollY<=oldScrollY)
                    {
                        //scroll up
                        imageVieww.setVisibility(View.VISIBLE);
                    }
                    else {
                        imageVieww.setAnimation(animFadeIn2);

                    }
                }
            });
        }*/

    }

    @Override
    protected void onResume() {
        super.onResume();

       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MovieList.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(MovieList.this);
        linearLayoutManager2.setOrientation(RecyclerView.HORIZONTAL);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(MovieList.this);
        linearLayoutManager3.setOrientation(RecyclerView.HORIZONTAL);


        movieListRecycler1.setLayoutManager(linearLayoutManager);
        movieListRecycler2.setLayoutManager(linearLayoutManager2);
        movieListRecycler3.setLayoutManager(linearLayoutManager3);

        List<MovieListModel> categorymodelList = new ArrayList<>();
        categorymodelList.add(new MovieListModel(R.drawable.ewpop));
        categorymodelList.add(new MovieListModel(R.drawable.bbflp));
        categorymodelList.add(new MovieListModel(R.drawable.bbp));
        categorymodelList.add(new MovieListModel(R.drawable.intestellarp));
        categorymodelList.add(new MovieListModel(R.drawable.lastchristmasp));

        List<MovieListModel> categorymodelList2 = new ArrayList<>();

        categorymodelList2.add(new MovieListModel(R.drawable.nm2));
        categorymodelList2.add(new MovieListModel(R.drawable.annabelp));
        categorymodelList2.add(new MovieListModel(R.drawable.insidious));
        categorymodelList2.add(new MovieListModel(R.drawable.strangerthingsp));

        List<MovieListModel> categorymodelList3 = new ArrayList<>();
        categorymodelList3.add(new MovieListModel(R.drawable.captainmp));
        categorymodelList3.add(new MovieListModel(R.drawable.arrowp));
        categorymodelList3.add(new MovieListModel(R.drawable.narcosp));


        MovieListAadapter movieListAadapter1 = new MovieListAadapter(categorymodelList,getApplicationContext());
        MovieListAadapter movieListAadapter2 = new MovieListAadapter(categorymodelList2,getApplicationContext());
        MovieListAadapter movieListAadapter3 = new MovieListAadapter(categorymodelList3,getApplicationContext());
        movieListRecycler1.setAdapter(movieListAadapter1);

        movieListRecycler2.setAdapter(movieListAadapter2);
        movieListRecycler3.setAdapter(movieListAadapter3);
        movieListAadapter1.notifyDataSetChanged();
        movieListAadapter2.notifyDataSetChanged();
        movieListAadapter3.notifyDataSetChanged();

        movieListRecycler1.setAnimation(animFadeIn1);
        movieListRecycler2.setAnimation(animFadeIn2);
        movieListRecycler3.setAnimation(animFadeIn3);



            }





      /*  List<MovieListModel> gridlist = new ArrayList<>();
        gridlist.add(new MovieListModel(R.drawable.ewpop));
        gridlist.add(new MovieListModel(R.drawable.captainmp));
        gridlist.add(new MovieListModel(R.drawable.bbflp));
        gridlist.add(new MovieListModel(R.drawable.instestellarp));
        gridlist.add(new MovieListModel(R.drawable.narcosp));
        gridlist.add(new MovieListModel(R.drawable.strangerthingsp));


        gridView.setAdapter(new GridBannerAdapter(gridlist));
*/
    }






