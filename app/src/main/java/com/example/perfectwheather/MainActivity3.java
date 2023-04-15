package com.example.perfectwheather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    private Button okay;
    private EditText name,price,product,number,code;

    FusedLocationProviderClient fusedLocationProviderClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3); //7973171938

        okay = findViewById(R.id.okay);
        name = findViewById(R.id.name);
        price = findViewById(R.id.sellingPrice);
        number = findViewById(R.id.number);
        product = findViewById(R.id.product);




        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLastLocation1();

            }
        });
    }
            private void getLastLocation1() {

                if (ContextCompat.checkSelfPermission(MainActivity3.this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity3.this);
                    fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {

                            if (location != null) {


                                Geocoder geocoder = new Geocoder(MainActivity3.this, Locale.getDefault());
                                List<Address> addresses;
                                try {
                                    addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                String gps = String.valueOf(addresses.get(0).getLocality());
                                String name1 = name.getText().toString();
                                String price1 = String.valueOf(price.getText().toString());
                                String number1 = String.valueOf(number.getText().toString());
                                String product1 = product.getText().toString();



                                String person =name1+" selling "+ product1 +" at"+" " + "Rs." + price1 + " " + " +91" + number1 + " " +gps ;
               HashMap<String,Object> map = new HashMap<>();
               map.put("detail",person);
                /*person.put("price",price1);
                person.put("number",number1);
                person.put("product",product1);*/
                                FirebaseDatabase.getInstance().getReference().child("seller").push().setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(MainActivity3.this, "Data added !", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }

                                });
                            }

                        }
                    });
                } else {
                    ActivityCompat.requestPermissions(MainActivity3.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }

            }
        }

