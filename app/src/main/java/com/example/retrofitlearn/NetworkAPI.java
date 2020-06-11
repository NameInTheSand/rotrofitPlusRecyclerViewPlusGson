package com.example.retrofitlearn;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkAPI {
    private static NetworkAPI mInstance;
    private static final String BASE_URL = "http://api.openweathermap.org";
    private Retrofit mRetrofit;

    private NetworkAPI() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkAPI getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkAPI();
        }
        return mInstance;
    }
    public JSONPlaceHolderApi getJSONApi() {
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }
}
