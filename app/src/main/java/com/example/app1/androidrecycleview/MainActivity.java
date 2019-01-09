package com.example.app1.androidrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nlwd on 1/10/2018.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerAdapter adapter;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getWebservice();

    }

    private void getWebservice(){

        final Request request = new Request.Builder().url("https://jsonplaceholder.typicode.com/photos").build();
        client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       Log.d( "Error","onFailure");
                    }
                });

            }

            @Override
            public void onResponse(Call call,final Response response)  {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Log.d( "Success","onResponse");

                            final Gson gson = new Gson();
                            List<ListItem> posts = Arrays.asList(gson.fromJson(response.body().string(),ListItem[].class));
                            adapter = new MyRecyclerAdapter(getApplicationContext(),posts);
                            recyclerView.setAdapter(adapter);

                        }

                        catch (IOException ioe){
                            Log.d( "Error","Error during getting body");
                            Toast.makeText(MainActivity.this,"Error during getting body",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });



    }
}
