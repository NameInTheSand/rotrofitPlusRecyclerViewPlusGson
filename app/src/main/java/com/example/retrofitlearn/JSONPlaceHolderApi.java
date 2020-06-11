package com.example.retrofitlearn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface JSONPlaceHolderApi {

    @GET("/data/2.5/weather")
            public Call<Post> getPostofUser(@Query("q") String city, @Query("APPID") String UserApi);

    public class Post {
        @SerializedName("coord")
        public Coord coord;
        @SerializedName("sys")
        public Sys sys;
        @SerializedName("weather")
        public ArrayList<Weather> weather = new ArrayList<Weather>();
        @SerializedName("main")
        public Main main;
        @SerializedName("wind")
        public Wind wind;
        @SerializedName("rain")
        public Rain rain;
        @SerializedName("clouds")
        public Clouds clouds;
        @SerializedName("dt")
        public float dt;
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
        @SerializedName("cod")
        public float cod;

        class Weather {
            @SerializedName("id")
            public int id;
            @SerializedName("main")
            public String main;
            @SerializedName("description")
            public String description;
            @SerializedName("icon")
            public String icon;
        }

        class Clouds {
            @SerializedName("all")
            public float all;
        }

        class Rain {
            @SerializedName("3h")
            public float h3;
        }

        class Wind {
            @SerializedName("speed")
            public float speed;
            @SerializedName("deg")
            public float deg;
        }

        class Main {
            @SerializedName("temp")
            public float temp;
            @SerializedName("feel_like")
            public float feels;
            @SerializedName("humidity")
            public float humidity;
            @SerializedName("pressure")
            public float pressure;
            @SerializedName("temp_min")
            public float temp_min;
            @SerializedName("temp_max")
            public float temp_max;
        }

        class Sys {
            @SerializedName("country")
            public String country;
            @SerializedName("sunrise")
            public long sunrise;
            @SerializedName("sunset")
            public long sunset;
            @SerializedName("city")
            public String city;
        }

        class Coord {
            @SerializedName("lon")
            public float lon;
            @SerializedName("lat")
            public float lat;
        }

}


}
