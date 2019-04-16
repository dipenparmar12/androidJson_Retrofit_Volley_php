package com.example.androidvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class VolleyActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener{

    final String URL = "http://10.0.2.2/students.php",TAG="dipen";
    TextView textView;
    Gson gson = new Gson();

    StringRequest stringRequest;
    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;

    RequestQueue requestQueue;

    ArrayList<StudentsJson> studentsList = new ArrayList<StudentsJson>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        stringRequest = new StringRequest(URL,this,this);
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        
        RecyclerView.Adapter studentAdapter = new StudentAdapter(studentsList, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);

    }


    @Override
    public void onResponse(Object response) {
        Log.e(TAG, "onResponse: "+response );

        try {

            JSONArray jsonArray = new JSONArray(response.toString());

            for(int i=0; i < jsonArray.length(); i++){
                studentsList.add(gson.fromJson(String.valueOf(jsonArray.getJSONObject(i)),StudentsJson.class));
            }

            Log.e(TAG, "onResponse: "+studentsList );



//            JSONArray jsonArray = new JSONArray(response.toString());
//            JSONObject object = jsonArray.getJSONObject(0);
//            StudentsJson studentsJson = (StudentsJson) gson.fromJson(String.valueOf(object),StudentsJson.class);
//            textView.setText(studentsJson.displayName);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(TAG, "onErrorResponse: "+error.toString() );
    }


}// MainClass
