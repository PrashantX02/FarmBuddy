package com.example.perfectwheather;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class MainActivity2 extends AppCompatActivity {
    final String API_ID = "8cee337a2970b1a6f8114d96e66a66b2";
    String weatherurl = "";

    ImageView base;
    FusedLocationProviderClient fusedLocationProviderClient;
    View view;

    private TextView cropy,temp,humi,soilR,RainF,realtemper,month,result,realmon,realHumi,nutrition,weatherType,result2;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        cropy = findViewById(R.id.cropy);
        temp = findViewById(R.id.temperature2);
        humi = findViewById(R.id.humidity1);
        soilR = findViewById(R.id.soil1);
        RainF = findViewById(R.id.rainfall1);
        realtemper = findViewById(R.id.temper);
        month = findViewById(R.id.month);
        result = findViewById(R.id.result);
        realmon = findViewById(R.id.realmonth);
        realHumi = findViewById(R.id.humi12);
        nutrition = findViewById(R.id.nutrition);
        weatherType = findViewById(R.id.weatherType);
        base = findViewById(R.id.baselINE);




        Intent intent = getIntent();

        String crop = intent.getStringExtra("s").trim().toLowerCase();




        if(crop.equals("gram")){
            cropy.setText("Requirement of "+crop);
            temp.setText("20-25 ℃");
            humi.setText("85 %");
            soilR.setText("loamy to sandy-loam soils");
            RainF.setText("40-45 cm");
            month.setText("October-November");


            LocalDate d  = LocalDate.now();
            String month1 = String.valueOf(d.getMonth()).toLowerCase();
            realmon.setText(month1);
            nutrition.setText("Nitrogen,Phosphorus,Potassium");

            if(month1.equals("october")||month1.equals("november")){
                result.setText("Perfect weather for this crop field");
            }else{
                result.setText("Not an Perfect weather !");
            }

            getLastLocation();

        }
        else if(crop.equals("millets")){
            cropy.setText("Requirement of "+crop);
            temp.setText("27-32 ℃");
            humi.setText("11.1-25 %");
            soilR.setText("alluvial soils");
            RainF.setText("50-100 cm");
            month.setText("june-November");


            LocalDate d  = LocalDate.now();
            String month1 = String.valueOf(d.getMonth()).toLowerCase();
            realmon.setText(month1);
            nutrition.setText("Nitrogen,Phosphorus,Potassium,calcium,iron,magnesium,manganese,sodium,zinc,copper,selenium");

            if(month1.equals("june")||month1.equals("july")||month1.equals("august")||month1.equals("september")||month1.equals("october")||month1.equals("november")){
                result.setText("Perfect weather for this crop field");
            }else{
                result.setText("Not an Perfect weather !");
            }


            getLastLocation();
        }
        else if(crop.equals("rice")){
            cropy.setText("Requirement of "+crop);
            temp.setText("22-32 ℃");
            humi.setText("60-80 %");
            soilR.setText("loamy soils");
            RainF.setText("150-300 cm");
            month.setText("june-july");


            LocalDate d  = LocalDate.now();
            String month1 = String.valueOf(d.getMonth()).toLowerCase();
            realmon.setText(month1);
            nutrition.setText("Nitrogen,Phosphorus,Potassium,magnesium,calcium,sulphur,zinc,iron,copper,baron,chlorine,manganese");

            if(month1.equals("june")||month1.equals("july")){
                result.setText("Perfect weather for this crop field");
            }else{
                result.setText("Not an Perfect weather !");
            }


            getLastLocation();
        }
        else if(crop.equals("wheat")){
            cropy.setText("Requirement of "+crop);
            temp.setText("15-20 ℃");
            humi.setText("50-60 %");
            soilR.setText("clayey and loamy soils");
            RainF.setText("75-100 cm");
            month.setText("November-december");


            LocalDate d  = LocalDate.now();
            String month1 = String.valueOf(d.getMonth()).toLowerCase();
            realmon.setText(month1);
            nutrition.setText("Nitrogen,Phosphorus,Potassium,magnesium,calcium,sulphur,zinc,iron,copper,baron,chlorine,manganese");

            if(month1.equals("november")||month1.equals("december")){
                result.setText("Perfect weather for this crop field");
            }else{
                result.setText("Not an Perfect weather !");
            }


            getLastLocation();
        }
        else if(crop.equals("cotton")){
            cropy.setText("Requirement of "+crop);
            temp.setText("21-30 ℃");
            humi.setText("43-76 %");
            soilR.setText("black soils");
            RainF.setText("50-100 cm");
            month.setText("march-may");


            LocalDate d  = LocalDate.now();
            String month1 = String.valueOf(d.getMonth()).toLowerCase();
            realmon.setText(month1);
            nutrition.setText("Nitrogen,Phosphorus,Potassium,cobalt,molybdenum");

            if(month1.equals("march")||month1.equals("april")||month1.equals("may")){
                result.setText("Perfect weather for this crop field");
            }else{
                result.setText("Not an Perfect weather !");
            }


            getLastLocation();
        }
        else if(crop.equals("tea")){
            cropy.setText("Requirement of "+crop);
            temp.setText("20-30 ℃");
            humi.setText("95-98 %");
            soilR.setText("loamy soils");
            RainF.setText("150-300 cm");
            month.setText("march-November");


            LocalDate d  = LocalDate.now();
            String month1 = String.valueOf(d.getMonth()).toLowerCase();
            realmon.setText(month1);
            nutrition.setText("Nitrogen,Phosphorus,potash fertilizers");

            if(month1.equals("march")||month1.equals("april")||month1.equals("may")||month1.equals("june")||month1.equals("july")||month1.equals("august")||month1.equals("september")||month1.equals("october")||month1.equals("november")){
                result.setText("Perfect weather for this crop field");
            }else{
                result.setText("Not an Perfect weather !");
            }


            getLastLocation();
        }
        else if(crop.equals("jute")){
            cropy.setText("Requirement of "+crop);
            temp.setText("25-35 ℃");
            humi.setText("70-90 %");
            soilR.setText("alluvial soils");
            RainF.setText("150-200 cm");
            month.setText("may-august");


            LocalDate d  = LocalDate.now();
            String month1 = String.valueOf(d.getMonth()).toLowerCase();
            realmon.setText(month1);
            nutrition.setText("baron,copper,iron,manganese,zinc");

            if(month1.equals("may")||month1.equals("june")||month1.equals("july")||month1.equals("august")){
                result.setText("Perfect weather for this crop field");
            }else{
                result.setText("Not an Perfect weather !");
            }


            getLastLocation();
        }
        else if(crop.equals("coffee")){
            cropy.setText("Requirement of "+crop);
            temp.setText("15-20 ℃");
            humi.setText("50-70 %");
            soilR.setText("loamy soils");
            RainF.setText("150-200 cm");
            month.setText("november-february");


            LocalDate d  = LocalDate.now();
            String month1 = String.valueOf(d.getMonth()).toLowerCase();
            realmon.setText(month1);
            nutrition.setText("Nitrogen,Phosphorus,Potassium pentoxide,potassium oxide");

            if(month1.equals("november")||month1.equals("december")||month1.equals("january")||month1.equals("february")){
                result.setText("Perfect weather for this crop field");
            }else{
                result.setText("Not an Perfect weather !");
            }


            getLastLocation();
        }
        else if(crop.equals("rubber")){
            cropy.setText("Requirement of "+crop);
            temp.setText("27-30 ℃");
            humi.setText("80-82 %");
            soilR.setText("alluvial soils");
            RainF.setText("50-100 cm");
            month.setText("may-august");


            LocalDate d  = LocalDate.now();
            String month1 = String.valueOf(d.getMonth()).toLowerCase();
            realmon.setText(month1);
            nutrition.setText("Nitrogen,Phosphorus,Potassium");

            if(month1.equals("may")||month1.equals("june")||month1.equals("july")||month1.equals("august")){
                result.setText("Perfect weather for this crop field");
            }else{
                result.setText("Not an Perfect weather !");
            }


            getLastLocation();
        }
    }
    private void getLastLocation() {

        if (ContextCompat.checkSelfPermission(MainActivity2.this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity2.this);
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {

                    if (location != null) {


                        Geocoder geocoder = new Geocoder(MainActivity2.this, Locale.getDefault());
                        List<Address> addresses;
                        try {
                            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }





//location block
                        String s = String.valueOf(addresses.get(0).getAdminArea());
                        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                        intent.putExtra("addressline",String.valueOf(addresses.get(0).getAddressLine(1)));

                        weatherurl = "https://api.openweathermap.org/data/2.5/weather?q=" + s
                                + "&units=metric&appid=" + API_ID;

                        RequestParams params = new RequestParams();
                        params.put("lat",addresses.get(0).getLatitude());
                        params.put("long",addresses.get(0).getLongitude());
                        params.put("appid",API_ID);

                        networking(params);

                    } else {
                        Toast.makeText(MainActivity2.this, "location is null", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            ActivityCompat.requestPermissions(MainActivity2.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

    }

    ////////////////////////////////////

    private void networking(RequestParams params){

        AsyncHttpClient client  = new AsyncHttpClient();
        client.get(weatherurl,params,new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
               // Toast.makeText(MainActivity2.this, "Data get successes", Toast.LENGTH_SHORT).show();
                //super.onSuccess(statusCode, headers, response);
                weather weatherdata =weather.fromJson(response);

                assert weatherdata != null;
// getter block
                realtemper.setText(weatherdata.getTempp());
                realHumi.setText(weatherdata.getHumidity());
                weatherType.setText(weatherdata.getWeathertype());


                if(weatherdata.getWeathertype().toLowerCase().equals("clear")){
                    base.setImageResource(R.drawable.rr21);
                }else if(weatherdata.getWeathertype().toLowerCase().equals("clouds")){
                    base.setImageResource(R.drawable.rr22);
                } else if (weatherdata.getWeathertype().toLowerCase().equals("scattered clouds")) {
                    base.setImageResource(R.drawable.rr24);
                } else if(weatherdata.getWeathertype().toLowerCase().equals("broken clouds")){
                    base.setImageResource(R.drawable.driz01);
                }else if(weatherdata.getWeathertype().toLowerCase().equals("shower rain")){
                    base.setImageResource(R.drawable.rr25);
                }
                else if(weatherdata.getWeathertype().toLowerCase().equals("rain")){
                    base.setImageResource(R.drawable.rr26);
                }
                else if(weatherdata.getWeathertype().toLowerCase().equals("thunderstorm")){
                    base.setImageResource(R.drawable.rr27);
                }
                else if(weatherdata.getWeathertype().toLowerCase().equals("snow")){
                    base.setImageResource(R.drawable.rr28);
                }
                else if(weatherdata.getWeathertype().toLowerCase().equals("mist")){
                    base.setImageResource(R.drawable.rr29);
                }else if(weatherdata.getWeathertype().toLowerCase().equals("drizzle")){
                    base.setImageResource(R.drawable.driz01);
                }
                else if(weatherdata.getWeathertype().toLowerCase().equals("haze")){
                    base.setImageResource(R.drawable.haze02);
                }else if(weatherdata.getWeathertype().toLowerCase().equals("sand")){
                    base.setImageResource(R.drawable.sandstorm03);
                }else if(weatherdata.getWeathertype().toLowerCase().equals("dust")){
                    base.setImageResource(R.drawable.dust01);
                }else if(weatherdata.getWeathertype().toLowerCase().equals("ash")){
                    base.setImageResource(R.drawable.ashcloud01);
                }else if(weatherdata.getWeathertype().toLowerCase().equals("squall")){
                    base.setImageResource(R.drawable.squall01);
                }else if(weatherdata.getWeathertype().toLowerCase().equals("tornado")){
                    base.setImageResource(R.drawable.tornado01);
                }

              ///////////////////  if(!weatherdata.getTempp().equals(temp));


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                //super.onFailure(statusCode, headers, throwable, errorResponse);
            }

        });
    }

    /////////////////////////////


    ////////////////////////////

}
