package com.example.mortalweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 基本的天气信息
 */
public class Basic {

    //SerializedName注解,让JSON字段和java字段建立映射关系
    @SerializedName("city")
    public String cityName;//城市名

    @SerializedName("id")
    public String weatherId;//对应天气的id

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;//天气的更新时间
    }
}
