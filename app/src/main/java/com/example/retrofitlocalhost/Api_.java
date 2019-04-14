package com.example.retrofitlocalhost;



//---------------------
//TODO---Json Data Holder Class
//---------------------

//TODO:1 Json Data Holder Object/Class
//TODO:2 File > ProejctStructure > app > Dependencies > { 1. google.Gson , 2. Retrofit2}
//TODO:3 Json Fields/ Varialbes Getter and Construtor


//---------------------
//TODO--- Api Class
//---------------------

//TODO:3 Json Fields/ Varialbes Getter and Construtor
//TODO:4 Follow TODO:2 Steps

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_{

    final String BASE_URL = "http://10.0.2.2/";

    @GET("sql.php")
    Call<ArrayList<StudentsJson_>> getStuddensList_();

}
