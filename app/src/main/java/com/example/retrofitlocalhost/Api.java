package com.example.retrofitlocalhost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*  --------- URL -----------

    // localhost == 10.0.2.2 !Important

* "http://10.0.2.2/getdata.php"
* "http://10.0.2.2/student.php"
* "http://10.0.2.2/students.php"
*
*/


public interface Api {

    String URL = "http://10.0.2.2/";

    // List Of Json object
    @GET("students.php/")
    Call<ArrayList<StudentsJson>> getStudentsList();



}







/*
 * URL: https://api.github.com/
 * https://api.github.com/users/{user}
 * https://api.github.com/users/{user}/repos
 * URL: https://api.github.com/
 * https://api.github.com/users/taylorotwell
 * https://api.github.com/users/taylorotwell/repos
 * https://api.github.com/search/repositories?q=flexsass
 * https://api.github.com/repos/dipenparmar12/FlexSass
 * Download Uri
 * https://github.com/userName/RepoName/archive/master.zip
 * svn_url+"/archive/"+default_branch+".zip"
 */


//public interface GitApi {
//
//    public final String BASE_URL = "https://api.github.com/";
//
//    @GET("users/{gitUser}")
//    Call<GitUserDetailJson> getUserDetail(@Path("gitUser") String gitUser);
//
//    @GET("users/{gitUser}/repos")
//    Call<ArrayList<GitRepoDetailJson>> getReposByUser(@Path("gitUser") String gitUser);
//
//    @GET("search/repositories")
//    Call<RepoListItemsJson> getReposBySearchPara(@Query("q") String SearchQry);
//
////    @GET("search/repositories?q={SearchQry}")
////    Call<ArrayList<GitUserDetailJson>> getReposBySearchPara(@Path("SearchQry") String SearchQry);
//
//}
