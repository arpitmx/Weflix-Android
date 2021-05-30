package com.india.WEFLIX;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private List<Category_Model> categoryModelList;

    public CategoryAdapter(List<Category_Model> categoryModelList) {


        this.categoryModelList = categoryModelList;

    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);


        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {

        int icon = categoryModelList.get(position).getCategoryIconLink();
        String name = categoryModelList.get(position).getCategory_name();
        holder.setCategoryName(name);
        holder.setCategoryIcon(icon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (position!=0) {

                    Log.d("Element Tapped", "Movie Poster tapped at :" + position);
                    Intent intent = new Intent(v.getContext(), StreamingNowMainPage.class);
                    intent.putExtra("SICON", categoryModelList.get(position).getCategoryIconLink());
                    intent.putExtra("STEXT", categoryModelList.get(position).getCategory_name());

                    v.getContext().startActivity(intent);
                }

                if(position ==0){

                            v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ZuYoEtEI_go")));
                            Log.i("Video", "Video Playing....");

                }

            }



        });

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView categoryIcon;
        private TextView categoryName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryIcon = itemView.findViewById(R.id.categoryIcon);
            categoryName = itemView.findViewById(R.id.categoryName);


        }

        private  void setCategoryIcon(int location){

categoryIcon.setImageResource(location);

        }
        private void setCategoryName(String name){

            categoryName.setText(name);
        }
    }
}
