package com.prasoon.mockfeed;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    public static String[]  userNames, userInfos, postTitles, postSmallInfos;
    Context context;
    public static TypedArray profilePics, postPics;

    Adapter(TypedArray profPics, String[] usrNames, String[] usrInfos, TypedArray pstPics, String[] pstTitles, String[] pstSmallInfos, Context context){
        //Get the data from the main activity
        profilePics = profPics;
        userNames = usrNames;
        userInfos = usrInfos;
        postPics = pstPics;
        postTitles = pstTitles;
        postSmallInfos = pstSmallInfos;

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_card, parent, false), this);
    }

    /*
    When the layoutmanager requires a view, it asks the recyclerview (getViewForPosition())
    The RV checks the cache and if no view is found then the recycled pool is queried (getViewHolderByType())
    If it's found there then the RV calls the Adapter's onBindViewHolder() and passes the
    holder(which is to be recycled right now) and also the position on the list for which all of this
    work is being done for.
    This method then 'binds' the data according to the position, to the given ViewHolder
    * */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.profilePic.setImageDrawable(context.getResources().getDrawable(profilePics.getResourceId(position, 0)));
        holder.userName.setText(userNames[position]);
        holder.userInfo.setText(userInfos[position]);
        holder.postPic.setImageDrawable(context.getDrawable(postPics.getResourceId(position, 0)));
        holder.postTitle.setText(postTitles[position]);
        holder.postSmallInfo.setText(postSmallInfos[position]);
    }

    /*
    Returns the number of items in the list
    (NOTE: returning 0 causes nothing to be displayed)
    * */
    @Override
    public int getItemCount() {
        return userNames.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView profilePic, postPic;
        TextView userName, userInfo, postTitle, postSmallInfo;
        Adapter adapter;

        public ViewHolder(@NonNull View itemView, Adapter adapter) {
            super(itemView);

            profilePic = itemView.findViewById(R.id.profile_pic);
            postPic = itemView.findViewById(R.id.post_pic);
            userName = itemView.findViewById(R.id.user_name);
            userInfo = itemView.findViewById(R.id.user_info);
            postTitle = itemView.findViewById(R.id.post_title);
            postSmallInfo = itemView.findViewById(R.id.post_small_info);

            this.adapter = adapter;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, PostActivity.class);
            intent.putExtra("position", getAdapterPosition());
            context.startActivity(intent);
        }
    }
}
