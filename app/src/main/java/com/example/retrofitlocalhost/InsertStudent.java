package com.example.retrofitlocalhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        getStudentById = api.getStudentsList();
        getStudentById.enqueue(this);


        Button button = findViewById(R.id.btn_select_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getStudentById = api.getStudentById("3");
                getStudentById.enqueue(new Callback<ArrayList<StudentsJson>>() {
                    @Override
                    public void onResponse(Call<ArrayList<StudentsJson>> call, Response<ArrayList<StudentsJson>> response) {
                        Log.e("dipen", "onResponse: "+response.body() );
                        RecyclerView recyclerView;
                        RecyclerView.Adapter adapter;

                        recyclerView = findViewById(R.id.recyclerView);
                        recyclerView.setLayoutManager(new LinearLayoutManager(InsertStudent.this));

                        adapter = new StudentAdapter(InsertStudent.this, response.body());
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<StudentsJson>> call, Throwable t) {
                        Log.e("dipen", "onFailure: "+t.toString() );
                    }
                });
            }
        });


    }


    @Override
    public void onResponse(Call<ArrayList<StudentsJson>> call, Response<ArrayList<StudentsJson>> response) {
        Log.e("dipen", "onResponse: "+response.body());

        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new StudentAdapter(this,response.body());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFailure(Call<ArrayList<StudentsJson>> call, Throwable t) {
        Log.e("dipen", "onFailure: "+t.toString() );
    }

}
