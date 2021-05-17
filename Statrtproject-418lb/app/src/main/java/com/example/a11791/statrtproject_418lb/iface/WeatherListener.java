package com.example.a11791.statrtproject_418lb.iface;

import com.example.a11791.statrtproject_418lb.bean.WeatherInfo;

/**
 * Created by 11791 on 2017/3/14.
 */

public interface WeatherListener {
    void onResponse(WeatherInfo weatherInfo);
    void onFail(String msg);

}
