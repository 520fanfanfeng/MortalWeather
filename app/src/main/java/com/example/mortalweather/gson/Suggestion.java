package com.example.mortalweather.gson;

import com.google.gson.annotations.SerializedName;
/**
 * 与天气相关的生活建议
 */
public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;//舒适度

    @SerializedName("cw")
    public CarWash carWash;//洗车

    public Sport sport;//运动

    public class Comfort {
        @SerializedName("txt")
        public String info;
    }

    public class CarWash {
        @SerializedName("txt")
        public String info;
    }

    public class Sport {
        @SerializedName("txt")
        public String info;
    }
}

