package com.example.retrofitlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    NetworkAPI networkAPI;
    LinearLayoutManager layoutManager;
    WeatherAdapter weatherAdapter;
    RecyclerView weather;
    Button get;
    EditText city;
    private ArrayList<String> resID;
    private ArrayList<String> resText;
    final static String APIKEy="ca0a95a410afc258968832c02c698429";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get=findViewById(R.id.Get);
        city=findViewById(R.id.City);
        weather=findViewById(R.id.weatherSet);
        final LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        weather.setLayoutManager(layoutManager);
        weather.setHasFixedSize(true);
        resID=new ArrayList<String>();
        resText=new ArrayList<String>();
        get.setOnClickListener(new View.OnClickListener()
        {
         @Override
         public void onClick(View v) {
             NetworkAPI.getInstance()
                     .getJSONApi()
                     .getPostofUser(city.getText().toString(),APIKEy)
                     .enqueue(new Callback<JSONPlaceHolderApi.Post>() {
                         @Override
                         public void onResponse(@NonNull Call<JSONPlaceHolderApi.Post> call,
                                                @NonNull Response<JSONPlaceHolderApi.Post> response) {
                             JSONPlaceHolderApi.Post post = response.body();
                             try {
                                 resText.add(String.valueOf(post.weather.get(0).main));
                                 resID.add("main");
                                 resText.add(Float.toString(post.clouds.all));
                                 resID.add("Clouds all");
                                 resText.add(String.valueOf(post.wind.speed));
                                 resID.add("Wind Speed");
                                 resText.add(String.valueOf(post.main.temp));
                                 resID.add("Temperature");
                                 resText.add(String.valueOf(post.main.humidity));
                                 resID.add("Humidity");
                                 resText.add(String.valueOf(post.main.temp_max));
                                 resID.add("Max temp");
                                 resText.add(String.valueOf(post.main.temp_min));
                                 resID.add("Min temp");
                                 resText.add(String.valueOf(post.sys.country));
                                 resID.add("Country");
                                 resText.add(String.valueOf(post.sys.city));
                                 resID.add("City");
                                 resText.add(String.valueOf(post.coord.lon));
                                 resID.add("Lon");
                                 resText.add(String.valueOf(post.coord.lat));
                                 resID.add("Lat");
                                 weatherAdapter = new WeatherAdapter(resID,resText,11);
                                 weather.setAdapter(weatherAdapter);
                             }
                             catch (Exception e)
                             {
                                 Log.d("PostEror", Objects.requireNonNull(e.getMessage()));
                             }
                             }

                         @Override
                         public void onFailure(@NonNull Call<JSONPlaceHolderApi.Post> call, @NonNull Throwable t) {

                             Toast toast = Toast.makeText(getApplicationContext(),"Error to get weather",Toast.LENGTH_SHORT);
                             toast.show();
                         }
                     });
         }});

    }
}
