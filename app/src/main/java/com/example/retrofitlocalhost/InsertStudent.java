package com.example.retrofitlocalhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InsertStudent extends AppCompatActivity implements Callback<ArrayList<StudentsJson>> {

    Api api;
    Retrofit retrofit;
    Call<ArrayList<StudentsJson>> getStudentById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);

        retrofit = new Retrofit.Builder().baseUrl(Api.URL).addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(Api.class);
        getStudentById = api.getStudentById("1");
        getStudentById.enqueue(this);

    }


    @Override
    public void onResponse(Call<ArrayList<StudentsJson>> call, Response<ArrayList<StudentsJson>> response) {
        Log.e("dipen", "onResponse: "+response.body());
    }

    @Override
    public void onFailure(Call<ArrayList<StudentsJson>> call, Throwable t) {
        Log.e("dipen", "onFailure: "+t.toString() );
    }

}
