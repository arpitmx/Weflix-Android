package com.india.WEFLIX;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Homepage extends AppCompatActivity {




    ////////////////////Buttons//////////////////
    TextView moviebtn;
    TextView webseriesBtn;
   TextView MyList;
    //////////////////////////////////////////////


    //////////////////////BannerSlider//////////////////

    ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    int CurrentPage = 0;
    Timer timer;
    int DELAY_TIME = 5000;
    int PERIOD_TIME =5000;

    ConstraintLayout constraintLayoutHomePage;
    LayoutInflater inflaterx;

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    //////////////////////BannerSlider//////////////////

   ////////////////////////////Multiple Movie List straight///////////////////////////////


    private TextView layoutTitle ;
    private Button ViewAll;
    private RecyclerView HorizontalRecyclerView;

    ////////////////////Multiple Movie List Straight//////////////////////////////




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

/////////////////////////////////////////////Initiating
        constraintLayoutHomePage = (ConstraintLayout) findViewById(R.id.homepageConstraintLayout);
        categoryRecyclerView = findViewById(R.id.CategoryResc);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        MyList = findViewById(R.id.webseries);
        inflaterx = getLayoutInflater();
        Start(inflaterx, constraintLayoutHomePage);



        moviebtn = (TextView) findViewById(R.id.movieBtn);


///////////////////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////Category Recyclers


        LinearLayoutManager layoutManager = new LinearLayoutManager(Homepage.this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);


        List<Category_Model> categorymodelList = new ArrayList<>();
        categorymodelList.add(new Category_Model(R.drawable.elm, "Nightmare on Elm "));
        categorymodelList.add(new Category_Model(R.drawable.insicir, "Insidious"));
        categorymodelList.add(new Category_Model(R.drawable.scr, "Sacred Games"));
        categorymodelList.add(new Category_Model(R.drawable.st, "Stranger Things"));
        categorymodelList.add(new Category_Model(R.drawable.sts5, "ST-S5"));
        categorymodelList.add(new Category_Model(R.drawable.arrc, "Arrow"));
        categorymodelList.add(new Category_Model(R.drawable.efw, "End of f***ing world"));
        categorymodelList.add(new Category_Model(R.drawable.bdb, "Boyz for Life"));


        categoryAdapter = new CategoryAdapter(categorymodelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();




        ///////////////////////////////////////////category





        //////////////////////////////////Multiple Movie Banner////////////////////////



        layoutTitle = findViewById(R.id.txt);
        ViewAll = findViewById(R.id.viewallbtn);
        HorizontalRecyclerView = findViewById(R.id.RCview);
        List<MultipleProductbannerModel> list = new ArrayList<>();
        list.add(new MultipleProductbannerModel(R.drawable.nmp,"A","Ranked 1st","Nightmare on Elm Street"));
        list.add(new MultipleProductbannerModel(R.drawable.ewpo,"S3","Ranked 5rd","The End Of The F***ing World"));
        list.add(new MultipleProductbannerModel(R.drawable.brb3,"S5","Ranked 2nd","Breaking Bad"));
        list.add(new MultipleProductbannerModel(R.drawable.na,"S4","Ranked 3st","Narcos:Mexico"));
        list.add(new MultipleProductbannerModel(R.drawable.arrow,"S3","Ranked 4th","Arrow"));
        list.add(new MultipleProductbannerModel(R.drawable.str2,"S8","Ranked 1","Stranger Things"));


        try {
            MultipleProductbannerAdapter adapter = new MultipleProductbannerAdapter(list);
            LinearLayoutManager LM = new LinearLayoutManager(Homepage.this);
            LM.setOrientation(LinearLayoutManager.HORIZONTAL);
            HorizontalRecyclerView.setLayoutManager(LM);

            HorizontalRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }catch (Exception e ){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }








        /////////////////////////////////////////////////////////////////////////








    }

    @Override
    protected void onResume() {
        super.onResume();
        startBannerSlideShow();

        moviebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Homepage.this, MovieList.class);

              //  onPause();
             //   StopBannerSlider();
                startActivity(i);


            }
        });


        MyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this,MyList.class);
                startActivity(i);
            }
        });


    }


    public View Start(LayoutInflater inflater, ViewGroup container) {


        View view = inflater.inflate(R.layout.activity_homepage,container,false);

        bannerSliderViewPager = findViewById(R.id.banner_slider_viewpager);

        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.str2));
        sliderModelList.add(new SliderModel(R.drawable.arrow));


        sliderModelList.add(new SliderModel(R.drawable.nm));
        sliderModelList.add(new SliderModel(R.drawable.end));   //1
        sliderModelList.add(new SliderModel(R.drawable.brb3));  //2
        sliderModelList.add(new SliderModel(R.drawable.na));
        sliderModelList.add(new SliderModel(R.drawable.str));
        sliderModelList.add(new SliderModel(R.drawable.dilbe3));
        sliderModelList.add(new SliderModel(R.drawable.str2));
        sliderModelList.add(new SliderModel(R.drawable.arrow));


        sliderModelList.add(new SliderModel(R.drawable.nm));  //1
        sliderModelList.add(new SliderModel(R.drawable.brb3));  //2


        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);


        ViewPager.OnPageChangeListener onpageL = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                CurrentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if  ( state == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };



        bannerSliderViewPager.addOnPageChangeListener(onpageL);


        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event){

                pageLooper();
                StopBannerSlider();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });





        return view;

    }





    private void pageLooper(){

        if(CurrentPage == (sliderModelList.size()-2)){

            CurrentPage = 2;
            bannerSliderViewPager.setCurrentItem(CurrentPage,false);

        }
        if(CurrentPage == 1 ){

            CurrentPage = sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(CurrentPage,false);
        }

    }

    private void startBannerSlideShow(){
        Handler handler = new Handler();
        Runnable update = new Runnable(){
            @Override
            public void run(){
                if (CurrentPage >= sliderModelList.size()){
                    CurrentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(CurrentPage++,true);

            }

        };

        timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                handler.post(update);
            }},DELAY_TIME,PERIOD_TIME);

    }


    private void StopBannerSlider(){
        timer.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
