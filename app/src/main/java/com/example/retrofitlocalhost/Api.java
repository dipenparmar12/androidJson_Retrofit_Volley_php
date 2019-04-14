package com.example.retrofitlocalhost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*  --------- URL -----------

    //TODO localhost == 10.0.2.2 !Important


* "http://10.0.2.2/sql.php"
* "http://10.0.2.2/students.php"
*
*/


public interface Api {

    String URL = "http://10.0.2.2/";

    // Single Json Object
    @GET("sql.php/")
    Call<ArrayList<StudentsJson>>  getStudent();


    // List Of Json object
    @GET("students.php/")
    Call<ArrayList<StudentsJson>> getStudentsList();

}
