package com.example.lb.startproject_418lb.iface;

/**
 * Created by lb on 2017/3/14.
 */
//统一不同方式获取信息，定义接口

public interface Weatheriface {
    void getWeather(String cityno,WeatherListener listener);
}
