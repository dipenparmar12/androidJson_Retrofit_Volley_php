package com.example.androidvolley;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofit_Api {

    final String BASE_URL = "http://10.0.2.2/";

    @GET("college.php")
    Call<ApiJsonObject> getJsonString();

}
