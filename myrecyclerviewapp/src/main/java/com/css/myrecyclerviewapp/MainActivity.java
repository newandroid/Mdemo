package com.css.myrecyclerviewapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.css.learnrecyclerview.widget.GridLayoutManager;
import com.css.learnrecyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normalSet();
//        gridSet();
    }

    private void gridSet() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new PagerGridLayoutManager(3, 3, PagerGridLayoutManager.HORIZONTAL));
        PagerGridSnapHelper pagerGridSnapHelper = new PagerGridSnapHelper();
//        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerGridSnapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new RecyclerView.ViewHolder(new Button(parent.getContext())) {
                };
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
                TextView itemView = (TextView) holder.itemView;
                itemView.setText("" + position + " r:" + random);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        random = createRandom();
                        notifyItemChanged(position);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });
    }

    private void normalSet() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false));
//        PagerGridSnapHelper pagerGridSnapHelper = new PagerGridSnapHelper();
////        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
//        pagerGridSnapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new RecyclerView.ViewHolder(new Button(parent.getContext())) {

                };
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
                final TextView itemView = (TextView) holder.itemView;
                itemView.setText("" + position + " r:" + random);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        random = createRandom();
                        notifyItemChanged(position);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });
    }

    private int createRandom(){
        return (int) (Math.random()*100);
    }
}
