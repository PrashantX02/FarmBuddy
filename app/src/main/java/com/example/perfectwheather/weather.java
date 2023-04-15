package com.example.perfectwheather;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class weather {
    private  String tempp;
    private String humidity;
    private String mcity;
    private String micon;
    private String weathertype;
    private int mcondition;

    public static weather fromJson(JSONObject jsonObject){
        try {
            weather weatherdata = new weather();
            weatherdata.mcity = jsonObject.getString("name");
            weatherdata.mcondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherdata.weathertype = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");

            double tempresult = (int) (jsonObject.getJSONObject("main").getDouble("temp"));
            int roundedvalue = (int)Math.rint(tempresult);
            weatherdata.tempp = String.valueOf(roundedvalue);


            double humidityresult = jsonObject.getJSONObject("main").getDouble("humidity");
            int roundedvalue1 = (int)Math.rint(humidityresult);
            weatherdata.humidity = String.valueOf(roundedvalue1);

            return weatherdata;

        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

    public String getHumidity() {

        return humidity;
    }

    public String getTempp() {
        return tempp+" ℃";
    }


    public String getWeathertype() {
        return weathertype;
    }
}
