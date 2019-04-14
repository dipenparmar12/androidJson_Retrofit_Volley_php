package com.example.retrofitlocalhost;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListStudentInfo extends AppCompatActivity implements Callback<ArrayList<StudentsJson>> {

    Api api;
    Retrofit retrofit;
    Call<ArrayList<StudentsJson>> getStudentById;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    Spinner spinner;
    ArrayAdapter spinnerArrayAdapter;

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

                getStudentById = api.getStudentById(spinner.getSelectedItem()+"");
                getStudentById.enqueue(new Callback<ArrayList<StudentsJson>>() {
                    @Override
                    public void onResponse(Call<ArrayList<StudentsJson>> call, Response<ArrayList<StudentsJson>> response) {
                        Log.e("dipen", "onResponse: "+response.body() );

                        bindData(ListStudentInfo.this,response.body());

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

        bindData(this,response.body());

        List studentIdList = new ArrayList();
        for(StudentsJson studentJson:response.body()){
            studentIdList.add(studentJson.getId());
        }

        spinner = findViewById(R.id.spinner2);
        spinnerArrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,studentIdList);
        spinner.setAdapter(spinnerArrayAdapter);


    }

    @Override
    public void onFailure(Call<ArrayList<StudentsJson>> call, Throwable t) {
        Log.e("dipen", "onFailure: "+t.toString() );
    }



    public void bindData(Context c,Object object){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListStudentInfo.this));
        adapter = new StudentAdapter(c, (ArrayList<StudentsJson>) object);
        recyclerView.setAdapter(adapter);
    }


}
