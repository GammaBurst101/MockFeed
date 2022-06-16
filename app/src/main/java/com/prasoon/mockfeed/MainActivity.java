package com.prasoon.mockfeed;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        //Set toolbar as the action bar
        setSupportActionBar(toolbar);

        //Remove the default text because we'll be using a custom textview instead
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        //Implement the navigation drawer
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_start, R.string.nav_stop);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //Getting the data from the app resources
        String[] userNames, userInfos, postTitles, postSmallInfos;
        TypedArray profilePics, postPics; //TypedArray are good when we need to handle imageview
        profilePics = getResources().obtainTypedArray(R.array.profile_pics);
        userNames = getResources().getStringArray(R.array.user_names);
        userInfos = getResources().getStringArray(R.array.user_infos);
        postPics = getResources().obtainTypedArray(R.array.post_pics);
        postTitles = getResources().getStringArray(R.array.post_titles);
        postSmallInfos = getResources().getStringArray(R.array.post_small_infos);

        //Set up the recycler view list
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Adapter adapter = new Adapter(profilePics, userNames, userInfos, postPics, postTitles, postSmallInfos, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //Necessary for the nav drawer button in the action bar to work. Don't know why
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}