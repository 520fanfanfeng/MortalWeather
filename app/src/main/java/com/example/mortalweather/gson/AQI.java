package com.example.mortalweather.gson;

/**
 * 表示当前空气质量情况
 */
public class AQI {

    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}

