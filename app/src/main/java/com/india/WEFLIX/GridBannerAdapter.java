package com.india.WEFLIX;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridBannerAdapter extends BaseAdapter {

    ImageView productImage;


    List<MovieListModel> GridBannerModelList;

    public GridBannerAdapter(List<MovieListModel> movieModelList) {
        this.GridBannerModelList = movieModelList;
    }

    @Override
    public int getCount() {
        return 13;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view ;
        if (convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row,null);
            productImage = view.findViewById(R.id.movie_poster);


            productImage.setImageResource(GridBannerModelList.get(position).getPoster_image());


        }else{
            view = convertView;
        }

        return view;
    }
}
