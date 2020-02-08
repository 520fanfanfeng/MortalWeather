package com.example.mortalweather.gson;

import com.google.gson.annotations.SerializedName;
/**
 * 当前的天气信息
 */
public class Now {
    @SerializedName("tmp")
    public String temperature;//温度

    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}

