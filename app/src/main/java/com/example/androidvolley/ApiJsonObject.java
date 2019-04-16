package com.example.androidvolley;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ApiJsonObject {

    @SerializedName("college")
    String College;

    @SerializedName("streme")
    String streme;

    @SerializedName("students")
    ArrayList<StudentsJson> studentsJson;

    @Override
    public String toString() {
        return "ApiJsonObject{" +
                "College='" + College + '\'' +
                ", streme='" + streme + '\'' +
                ", studentsJson=" + studentsJson +
                '}';
    }

    public String getCollege() {
        return College;
    }

    public ApiJsonObject(String college, String streme, ArrayList<StudentsJson> studentsJson) {
        College = college;
        this.streme = streme;
        this.studentsJson = studentsJson;
    }
}
