package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

RecyclerView NewsRecyclerView ;
NewsAdapter newsAdapter ;
List<NewsItem> mData;
EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        ;


        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        NewsRecyclerView = findViewById(R.id.news_rv);
        mData = new ArrayList<>();

        mData.add(new NewsItem("One Plus","ffff","1 janv 2014",R.drawable.profile ));
        mData.add(new NewsItem("One Plus","ffff","3 march 2014",R.drawable.profile2 ));
        mData.add(new NewsItem("One Plus","ffff","5 july 2021",R.drawable.profile3 ));
        mData.add(new NewsItem("One Plus","ffff","6 avril 2017",R.drawable.profile4 ));
        mData.add(new NewsItem("One Plus","ffff","9 mai 2019",R.drawable.profile5 ));
        mData.add(new NewsItem("One Plus","ffff","7 july 2018",R.drawable.profile ));
        mData.add(new NewsItem("One Plus","ffff","16 septem 2021",R.drawable.profile ));
        mData.add(new NewsItem("One Plus","ffff","19 july 2022",R.drawable.profile2 ));
        mData.add(new NewsItem("One Plus","ffff","22 octob 2020",R.drawable.profile ));
        mData.add(new NewsItem("One Plus","ffff","28 july 2021",R.drawable.profile ));
        mData.add(new NewsItem("One Plus","ffff","1 fev 2018",R.drawable.profile5 ));

newsAdapter = new NewsAdapter(this,mData);
NewsRecyclerView.setAdapter(newsAdapter);
NewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    };

}
