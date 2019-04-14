package com.example.retrofitlocalhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback {

    TextView textView;
    final String TAG = "dipen";

    Api api;
    Call<ArrayList<StudentsJson>> callStudents;
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView); textView.setText("");

        retrofit = new Retrofit.Builder().baseUrl(Api.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);

        callStudents = api.getStudentsList();
        callStudents.enqueue(this);

    } // onCreate()


    @Override
    public void onResponse(Call call, Response response) {
        Log.e(TAG, "onResponse: "+ response.body());

        ArrayList<StudentsJson> studentsJsons = (ArrayList<StudentsJson>) response.body();

        for(StudentsJson studentJson: studentsJsons){
            textView.append(studentJson.getDisplayName()+"\n");
        }

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.d(TAG, "onFailure: "+ t.toString());
    }


} // MainClass
