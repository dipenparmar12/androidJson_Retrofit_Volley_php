package com.example.androidvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity implements Callback {

    Retrofit_Api api;
    Retrofit retrofit;
    Call call;
    ArrayList<StudentsJson> studentsJsons;

    RecyclerView recyclerView;
    RecyclerView.Adapter studentAdapter;


    final String TAG = "dipen";
    TextView textView;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); textView = findViewById(R.id.textView);
        recyclerView = findViewById(R.id.recyclerView);

        retrofit = new Retrofit.Builder().baseUrl(Retrofit_Api.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(Retrofit_Api.class);
        call = api.getJsonString();


        call.enqueue(this);



    }

    @Override
    public void onResponse(Call call, Response response) {
        Log.e(TAG, "onResponse: "+response );
//        textView.append(response.body().toString());


        studentsJsons = ((ApiJsonObject) response.body()).studentsJson;

        studentAdapter = new StudentAdapter( studentsJsons  ,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);


//            for(StudentsJson s:studentsJsons){
//                textView.append(s.getDisplayName()+"\n");
//            }

//            for(int i=0; i < jsonArray.length(); i++){
//                Log.e(TAG, "JsonArray:" + jsonArray.get(i) );
//                studentsJsons.add(gson.fromJson(String.valueOf(jsonArray.getJSONObject(i)),StudentsJson.class));
//            }

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.e(TAG, "onFailure: "+t.toString() );
    }
}
