package com.example.retrofitlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>{
   private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> info = new ArrayList<String>();
    private int numberItems;
   private int i=0;
    public WeatherAdapter (ArrayList<String> tit, ArrayList<String> inf,int num)
    {
        for(int j=0;j<=num;j++)
        {
            titles.add(tit.get(j));
            info.add(inf.get(j));
        }

        numberItems=num;
    }
    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdforListItem= R.layout.element_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=  inflater.inflate(layoutIdforListItem,parent,false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        viewHolder.weatherInfo.setText(info.get(i));
        viewHolder.weatherTitle.setText(titles.get(i));
        i++;
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numberItems;
    }



    class WeatherViewHolder extends RecyclerView.ViewHolder
    {
        TextView weatherTitle;
        TextView weatherInfo;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            weatherTitle=itemView.findViewById(R.id.tv_title);
            weatherInfo=itemView.findViewById(R.id.tv_info);
        }
    }
}
