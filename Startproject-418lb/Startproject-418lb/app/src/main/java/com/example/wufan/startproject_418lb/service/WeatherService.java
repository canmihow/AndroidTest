package com.example.wufan.startproject_418lb.service;

import com.example.wufan.startproject_418lb.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by WuFan on 2017/3/14.
 */
//Retrofit访问网络-2,定义接口
public interface WeatherService {
 @GET("data/sk/{cityNumber}.html")
    Call<WeatherResult> getResult(@Path("cityNumber") String cityNumber);
}
