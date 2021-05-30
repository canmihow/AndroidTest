package com.example.lb.startproject_418lb.iface;

import com.example.lb.startproject_418lb.bean.WeatherInfo;

/**
 * Created by lb on 2017/3/14.
 */

public interface WeatherListener {
    void onResponse(WeatherInfo weatherInfo);
    void onFail(String msg);
}
