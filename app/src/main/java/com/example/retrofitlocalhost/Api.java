package com.example.retrofitlocalhost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*  --------- URL -----------

    // localhost == 10.0.2.2 !Important


* "http://10.0.2.2/students.php"

*  http://127.0.0.1/sql.php?opration=select
*  http://127.0.0.1/sql.php?opration=select&id=1
*
*/


public interface Api {

    String URL = "http://10.0.2.2/";

    // List Of Json object
    @GET("students.php/")
    Call<ArrayList<StudentsJson>> getStudentsList();


    @GET("sql.php")
    Call<ArrayList<StudentsJson>> getStudentById(@Query("id") String id);


//    @GET("sql.php")
//    Call<ArrayList<StudentsJson>> getAllStudents();

}

