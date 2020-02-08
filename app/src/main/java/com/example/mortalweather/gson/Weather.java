package com.example.mortalweather.gson;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 总的天气类
 */
public class Weather {

    public String status;//状态
    public Basic basic;//基础信息
    public AQI aqi;//空气质量
    public Now now;//现在天气
    public Suggestion suggestion;//建议

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;//将来的天气
}

