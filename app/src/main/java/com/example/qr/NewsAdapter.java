package com.example.qr;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> implements Filterable {

Context mContext ;
List<NewsItem> mData ;
    List<NewsItem>mDataFiltered;

public NewsAdapter(Context mContext , List<NewsItem> mData){
    this.mContext=mContext;
    this.mData=mData;
this.mDataFiltered = mData;

}


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

       View layout ;
       layout= LayoutInflater.from(mContext).inflate(R.layout.item_news,viewGroup , false);


        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {

        newsViewHolder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));

newsViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));


newsViewHolder.tv_title.setText(mDataFiltered.get(position).getTitle());
   newsViewHolder.tv_content.setText(mDataFiltered.get(position).getContent());
   newsViewHolder.tv_date.setText(mDataFiltered.get(position).getDate());
   newsViewHolder.img_user.setImageResource(mDataFiltered.get(position).getUserPhoto());


    }

    @Override
    public int getItemCount() {
        return mDataFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
String key = constraint.toString();
           if (key.isEmpty()) {
mDataFiltered=mData;

           }
           else {
               List<NewsItem> IsFiltered = new ArrayList<>();
          for (NewsItem row : mData) {
              if (row.getTitle().toLowerCase().contains(key.toLowerCase())) {
                  IsFiltered.add(row);
              }
          }
           mDataFiltered = IsFiltered;
           }
            FilterResults filterResults = new FilterResults();
           filterResults.values=mDataFiltered;
           return  filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mDataFiltered=(List<NewsItem>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

TextView tv_title , tv_content, tv_date ;
ImageView img_user ;

RelativeLayout container;


    public  NewsViewHolder (@NonNull View itemView) {
    super(itemView);
container=itemView.findViewById(R.id.container);
    tv_title = itemView.findViewById(R.id.tv_title);
    tv_content = itemView.findViewById(R.id.tv_description);
        tv_date = itemView.findViewById(R.id.tv_date);
        img_user = itemView.findViewById(R.id.img_user);


    }
    }

}



