package com.example.app1.androidrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by nlwd on 1/11/2018.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView id_2;
    private TextView albumId_2;
    private TextView title_2;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        id_2= (TextView) findViewById(R.id.id_2);
        albumId_2= (TextView) findViewById(R.id.albumId_2);
        title_2= (TextView) findViewById(R.id.title_2);
        imageView2= (ImageView) findViewById(R.id.imageView2);


        int x1 = getIntent().getIntExtra("Id",0);
        id_2.setText("ID : "+Integer.toString(x1));

        int x2 = getIntent().getIntExtra("AlbumId",0);
        albumId_2.setText("AlbumID : "+Integer.toString(x2));

        //int x3 = getIntent().getIntExtra("AlbumId",0);
        title_2.setText("Title : "+getIntent().getStringExtra("Title"));

        String x3 = getIntent().getStringExtra("Image");
        Picasso.with(getApplicationContext())
                .load(x3).into(imageView2);











    }
}
