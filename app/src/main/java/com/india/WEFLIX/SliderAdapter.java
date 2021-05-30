package com.india.WEFLIX;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

	private List<SliderModel> sliderModelList;

	public SliderAdapter(List<SliderModel> sliderModelList) {
		this.sliderModelList = sliderModelList;
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		View view = LayoutInflater.from(container.getContext()).inflate(R.layout.slider_layout,container,false);
		ImageView banner  = view.findViewById(R.id.viewpagerimageslider);
		banner.setImageResource(sliderModelList.get(position).getBanner());
		container.addView(view);
		return view;
	}

	@Override
	public int getCount() {

		return sliderModelList.size() ;
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
		return view ==object ;

	}
	@Override
	public void destroyItem(@NonNull ViewGroup container , int Position,@NonNull Object obj) {
		container.removeView((View) obj);

	}
}

