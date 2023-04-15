package com.example.perfectwheather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button sell;

    private ImageView fertilizer,pestiside;

    ListView listView;





   /* final String API_ID = "8cee337a2970b1a6f8114d96e66a66b2";
    String weatherurl = "";*/

    private ImageView gram,millets,wheat,tea,cotton,coffee,jute,rubber,rice;


    private TextView textView, tempT, temp_maxT, temp_minTxt, windT, pressureT, humidityT;
    //FusedLocationProviderClient fusedLocationProviderClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView  = findViewById(R.id.listView);

        // adapter setting
       ArrayList<String> arr = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list,arr);
        listView.setAdapter(adapter);

        ArrayList<String> id = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("seller").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot snapshot1 :snapshot.getChildren()){
                        id.add(snapshot.getKey().toString());
                        seller i = snapshot1.getValue(seller.class);
                        String t = null;
                        if (i != null) {
                            t = i.getDetail();
                        }
                        arr.add(t);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        DatabaseReference databaseReference ;
//deleting task performing:-
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                final int item = position;

                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Are sure to delete your selling card ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //arr.remove(item);
                               arr.remove(item);
                               adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }
        });
//adapter setting ended;

        gram = findViewById(R.id.imageView13);

        millets = findViewById(R.id.Millets);

        wheat = findViewById(R.id.wheat);

        tea = findViewById(R.id.tea);

        jute = findViewById(R.id.jute);

        cotton=findViewById(R.id.cotton);

        coffee = findViewById(R.id.coffee);

        rubber = findViewById(R.id.rubber);

        rice = findViewById(R.id.rice);

        sell = findViewById(R.id.sellproduct);

        fertilizer = findViewById(R.id.fertilizer);
        pestiside = findViewById(R.id.pestiside);







        gram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("s","gram");

               // getLastLocation();
                startActivity(intent);
            }
        });

        millets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("s","millets");
                startActivity(intent);
            }
        });

        wheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("s","wheat");
                startActivity(intent);
            }
        });

        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("s","tea");
                startActivity(intent);
            }
        });

        cotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("s","cotton");
                startActivity(intent);
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("s","coffee");
                startActivity(intent);
            }
        });

        jute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("s","jute");
                startActivity(intent);
            }
        });

        rubber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("s","rubber");
                startActivity(intent);
            }
        });

        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("s","rice");
                startActivity(intent);
            }
        });

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });

        pestiside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity4.class);
                startActivity(intent);
            }
        });

        fertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity5.class);
                startActivity(intent);
            }
        });




    }

 ///////////////////////////////////////////////////////////////////

  /*  private void getLastLocation() {

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {

                    if (location != null) {


                        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                        List<Address> addresses;
                        try {
                            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }






                        String s = String.valueOf(addresses.get(0).getAdminArea());

                       weatherurl = "https://api.openweathermap.org/data/2.5/weather?q=" + s
                               + "&units=metric&appid=" + API_ID;

                        RequestParams params = new RequestParams();
                        params.put("lat",addresses.get(0).getLatitude());
                        params.put("long",addresses.get(0).getLongitude());
                        params.put("appid",API_ID);

                        networking(params);

                    } else {
                        Toast.makeText(MainActivity.this, "location is null", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

    }

 ////////////////////////////////////

      private void networking(RequestParams params){

        AsyncHttpClient client  = new AsyncHttpClient();
        client.get(weatherurl,params,new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(MainActivity.this, "Data get successes", Toast.LENGTH_SHORT).show();
                //super.onSuccess(statusCode, headers, response);
                weather weatherdata =weather.fromJson(response);

                assert weatherdata != null;

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("weatherTemp",String.valueOf(weatherdata.getTempp()));
                intent.putExtra("weatherType",String.valueOf(weatherdata.getWeathertype()));



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                //super.onFailure(statusCode, headers, throwable, errorResponse);
            }

        });
    }*/

    /////////////////////////////


    ////////////////////////////

}

