package com.india.WEFLIX;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MovieListAadapter extends RecyclerView.Adapter<MovieListAadapter.ViewHolder>  {

       private List<MovieListModel> MovieList;
       private Context context;


       public MovieListAadapter(List<MovieListModel>  MovieList , Context context){

           this.MovieList = MovieList;
           this.context = context;

       }

    @NonNull
    @Override
    public MovieListAadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row,parent,false);
        Animation  animFadeIn1 = AnimationUtils.loadAnimation(context,
                R.anim.fadeinanim);
       view.setAnimation(animFadeIn1);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MovieListAadapter.ViewHolder holder, int position) {


           int posterImage = MovieList.get(position).getPoster_image();

        holder.setPosterImage(posterImage);

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if(position != 0){
               Log.d("Element Tapped","Movie Poster tapped at :"+position);
               Intent intent = new Intent(v.getContext(), MovieHomePage.class);
               intent.putExtra("poster",(MovieList.get(position).getPoster_image()) );
               v.getContext().startActivity(intent);
           }else{
                   Intent intent = new Intent(v.getContext(), HorrorMovie.class);
                   v.getContext().startActivity(intent);


               }
           }
       });


    }

    @Override
    public int getItemCount() {
        return MovieList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView pImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pImage = itemView.findViewById(R.id.movie_poster);




        }

        private void setPosterImage(int posterImage){
            pImage.setImageResource(posterImage);


        }


    }



}
