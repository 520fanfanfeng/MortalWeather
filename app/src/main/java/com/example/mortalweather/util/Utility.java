package com.example.mortalweather.util;

import android.text.TextUtils;
import com.example.mortalweather.db.Province;
import com.example.mortalweather.db.City;
import com.example.mortalweather.db.County;
import com.example.mortalweather.gson.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 请求服务器,并将响应结果存到数据库
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i=0;i<allProvinces.length();i++) {
                    JSONObject provincesJSONObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provincesJSONObject.getString("name"));
                    province.setProvinceCode(provincesJSONObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i=0;i<allCities.length();i++) {
                    JSONObject citiesJSONObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(citiesJSONObject.getString("name"));
                    city.setCityCode(citiesJSONObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i=0;i<allCounties.length();i++) {
                    JSONObject countiesJSONObject = allCounties.getJSONObject(i);
                    //将数据解析成对象
                    County county = new County();
                    county.setCountyName(countiesJSONObject.getString("name"));
                    county.setWeatherId(countiesJSONObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                    //将数据存储到数据库中
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将返回的JSON数据解析成Weather实体类
     */
    public static Weather handleWeatherResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
            //将JSON数据装换为Weather对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
