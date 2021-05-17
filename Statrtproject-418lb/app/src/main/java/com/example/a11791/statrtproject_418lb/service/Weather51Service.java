package com.example.a11791.statrtproject_418lb.service;

import com.example.a11791.statrtproject_418lb.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 11791 on 2017/3/14.
 */

public interface Weather51Service {
    @GET("GetMoreWeather")
    Call<WeatherResult> getResult(
            @Query("cityCode")String cityNumber,
            @Query("weatherType")int weatherType
    );
}
