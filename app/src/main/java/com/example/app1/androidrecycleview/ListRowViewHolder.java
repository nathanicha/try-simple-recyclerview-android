package com.example.app1.androidrecycleview;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by nlwd on 1/10/2018.
 */

public class ListRowViewHolder extends RecyclerView.ViewHolder {

    public ImageView thumbnail;
    public TextView idTitle;
    public TextView nameTitle;
    public RelativeLayout relativeLayout;

    @SuppressLint("WrongViewCast")
    public  ListRowViewHolder(View view){
        super(view);
        thumbnail= view.findViewById(R.id.imageView);
        idTitle= view.findViewById(R.id.idTitle);
        nameTitle= view.findViewById(R.id.nameTitle);
        relativeLayout= view.findViewById(R.id.relLayout);
        view.setClickable(true);
    }

}
