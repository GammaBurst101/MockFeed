package com.prasoon.mockfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the data from the resources
        String[] userNames, userInfos, postTitles, postSmallInfos;
        TypedArray profilePics, postPics;
        profilePics = getResources().obtainTypedArray(R.array.profile_pics);
        userNames = getResources().getStringArray(R.array.user_names);
        userInfos = getResources().getStringArray(R.array.user_infos);
        postPics = getResources().obtainTypedArray(R.array.post_pics);
        postTitles = getResources().getStringArray(R.array.post_titles);
        postSmallInfos = getResources().getStringArray(R.array.post_small_infos);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Adapter adapter = new Adapter(profilePics, userNames, userInfos, postPics, postTitles, postSmallInfos, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}