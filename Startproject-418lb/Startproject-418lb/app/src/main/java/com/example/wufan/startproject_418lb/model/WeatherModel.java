package com.example.wufan.startproject_418lb.model;

import com.example.wufan.startproject_418lb.bean.WeatherResult;
import com.example.wufan.startproject_418lb.iface.WeatherListener;
import com.example.wufan.startproject_418lb.iface.Weatheriface;
import com.example.wufan.startproject_418lb.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WuFan on 2017/3/14.
 */

public class WeatherModel implements Weatheriface {
    private Retrofit retrofit;
    private  String BASEURL="http://www.weather.com.cn/";
    public WeatherModel() {

        //Retrofit初始化
        retrofit=new Retrofit.Builder().baseUrl(BASEURL)//主机地址
        .addConverterFactory(GsonConverterFactory.create()).build();
    }


    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        //retroft接口使用3-2
        WeatherService weatherService=retrofit.create(WeatherService.class);
        Call<WeatherResult> call=weatherService.getResult(cityno);
        //retrofit3-2
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                System.out.println("----weaterModel---onresponse1111");
                if(response.isSuccessful() && response.body()!=null)
                listener.onResponse(response.body().getWeatherinfo());
                else
                    listener.onFail("onResponse error");
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                System.out.println("----weaterModel---onresponse2222");
                listener.onFail(t.toString());

            }
        });

    }
}