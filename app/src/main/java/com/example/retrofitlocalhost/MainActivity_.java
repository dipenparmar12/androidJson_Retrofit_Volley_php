package com.example.retrofitlocalhost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
//TODO:6 Check Response Data

//TODO:7 Create Basic Layout
//TODO:8 List item Layout

//---------------------
//  TODO--- StudentAdapter_
//---------------------
//TODO:9 extends RecyclerView.Adapter<StudentAdapter_.ViewHolder>

//TODO:10 set RecyclerView Layout By Cusome Adapter


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

        RecyclerView recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter customeAdapter;
        customeAdapter = new StudentAdapter_(response.body(),getApplicationContext());
        recyclerView.setAdapter(customeAdapter);

//        for(StudentsJson_ student: response.body()){
//            (student.getName()+"\n");
//        }
    }

    @Override
    public void onFailure(Call<ArrayList<StudentsJson_>> call, Throwable t) {
        Log.e("dipen", "onFailure: "+t.toString() );
    }
}


