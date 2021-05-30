package com.india.WEFLIX;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.india.WEFLIX.R;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {


    public RecyclerView mRecyclerView2;
    FirebaseDatabase mFirebaseDatabase2;
    DatabaseReference mref2;
    DatabaseReference reference;
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       getSupportActionBar().setTitle("Videos");


       // View view =getSupportActionBar().getCustomView();

        mRecyclerView2 = findViewById(R.id.video_recycler_view);
        mRecyclerView2.setHasFixedSize(true);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this));
        mFirebaseDatabase2 = FirebaseDatabase.getInstance();
        mref2 = mFirebaseDatabase2.getReference("video");
        textView = findViewById(R.id.rTitleTv2);
        reference = FirebaseDatabase.getInstance().getReference("video").child("1");

    }

    @Override
    protected void onStart() {

        super.onStart();

        FirebaseRecyclerOptions<Model2> options =
                new FirebaseRecyclerOptions.Builder<Model2>()
                        .setQuery(mref2,Model2.class)
                        .build();

        FirebaseRecyclerAdapter<Model2,ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model2, ViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Model2 model) {

                        holder.setDetails2(getApplication(),model.getName(),model.getUrl());

                    }

                    @NonNull
                    @Override
                    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.row,parent,false);


                        return new ViewHolder(view);
                    }
                };

        firebaseRecyclerAdapter.startListening();
        mRecyclerView2.setAdapter(firebaseRecyclerAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

      //  Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
      //  getSupportActionBar().setDisplayShowCustomEnabled(true);
      //  getSupportActionBar().setCustomView(R.layout.custom_actionbar);

    }
}
