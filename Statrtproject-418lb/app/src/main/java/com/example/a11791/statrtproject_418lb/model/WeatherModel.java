package com.example.a11791.statrtproject_418lb.model;

import com.example.a11791.statrtproject_418lb.bean.WeatherResult;
import com.example.a11791.statrtproject_418lb.iface.WeatherListener;
import com.example.a11791.statrtproject_418lb.iface.Weatheriface;
import com.example.a11791.statrtproject_418lb.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 11791 on 2017/3/14.
 */

public class WeatherModel implements Weatheriface{
    private Retrofit retrofit;
    private String BASEURL="http://www.weather.com.cn/";
    public WeatherModel() {

        retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        WeatherService weatherService=retrofit.create(WeatherService.class);
        Call<WeatherResult> call=weatherService.getResult(cityno);
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if (response.isSuccessful() && response.body()!=null)
                  listener.onResponse(response.body().getWeatherinfo());
                else
                    listener.onFail("onResponse error");
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
