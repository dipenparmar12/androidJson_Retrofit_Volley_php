package com.example.retrofitlocalhost;

//---------------------
//   TODO---Json Data Holder Class
//---------------------

//TODO:1 Json Data Holder Object/Class
//TODO:2 File > ProejctStructure > app > Dependencies > { 1. google.Gson , 2. Retrofit2, 3.retrofit Converter (Gson) }
//TODO:3 Json Fields/ Varialbes Getter and Construtor


//---------------------
//  TODO--- Api Class
//---------------------

//TODO:3 Json Fields/ Varialbes Getter and Construtor
//TODO:4 Follow TODO:2.2 Steps


//---------------------
//  TODO--- MainActivity
//---------------------
//TODO:5 Follow TODO:2.3 Steps
//TODO:5.1  Inisilize 3 Main Objects ( 1.Api, 2.Call, 3.Retrofit )
//TODO:6

//TODO implementation 'com.google.code.gson:gson:2.8.5'
//TODO implementation 'com.squareup.retrofit2:retrofit:2.5.0'
//TODO implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
//TODO implementation 'com.android.support:recyclerview-v7:28.0.0'
//TODO implementation 'com.android.support:cardview-v7:28.0.0'


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity_ extends AppCompatActivity implements Callback<ArrayList<StudentsJson_>> {

    Api_ api_;
    Call<ArrayList<StudentsJson_>> callStudent_;
    Retrofit retrofit_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit_ = new Retrofit.Builder().
                baseUrl(Api_.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        api_ = retrofit_.create(Api_.class);
        callStudent_ = api_.getStuddensList_();
        callStudent_.enqueue(this);

    } // onCreate()


    @Override
    public void onResponse(Call<ArrayList<StudentsJson_>> call, Response<ArrayList<StudentsJson_>> response) {
        Log.e("dipen", "onResponse: "+response.body() );
        TextView textView = findViewById(R.id.textView);
        textView.setText("");

        for(StudentsJson_ student: response.body()){
            textView.append(student.getName()+"\n");
        }


    }

    @Override
    public void onFailure(Call<ArrayList<StudentsJson_>> call, Throwable t) {
        Log.e("dipen", "onFailure: "+t.toString() );
    }
}
