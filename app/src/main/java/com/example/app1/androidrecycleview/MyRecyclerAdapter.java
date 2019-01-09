package com.example.app1.androidrecycleview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by nlwd on 1/10/2018.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<ListRowViewHolder> {

    private List<ListItem> listItemList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, List<ListItem> listItemList) {
        this.listItemList = listItemList;
        this.mContext = context;
    }

    @Override
    public ListRowViewHolder onCreateViewHolder(final ViewGroup viewGroup, int position) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_layout,viewGroup, false);
        ListRowViewHolder holder = new ListRowViewHolder(v);

        return holder;
    }

    public void onBindViewHolder(final ListRowViewHolder holder, int position) {
        final ListItem listItem = listItemList.get(position);
        holder.idTitle.setText("ID : "+listItem.getId());
        holder.nameTitle.setText("Title : "+listItem.getTitle());

        Picasso.with(mContext)
                .load(listItem.getThumbnailUrl()).into(holder.thumbnail);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SecondActivity.class);
                intent.putExtra("Id",listItem.getId());
                intent.putExtra("AlbumId",listItem.getAlbumId());
                intent.putExtra("Title",listItem.getTitle());
                intent.putExtra("Image",listItem.getUrl());
                mContext.startActivity(intent);
            }
        });
        //holder.bind(listItem,listener );

    }

/*************************************/
    public void clearAdapter(){
        listItemList.clear();
        notifyDataSetChanged();
    }
/*************************************/
    @Override
    public int getItemCount() {
        return (listItemList.size());
    }


}
