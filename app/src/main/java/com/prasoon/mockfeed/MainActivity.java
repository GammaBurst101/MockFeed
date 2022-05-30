package com.prasoon.mockfeed;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_start, R.string.nav_stop);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}