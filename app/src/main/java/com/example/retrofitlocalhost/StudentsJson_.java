package com.example.retrofitlocalhost;


import com.google.gson.annotations.SerializedName;

public class StudentsJson_ {

    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("address")
    String address;
    @SerializedName("mobile")
    String mobile;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public StudentsJson_(String id, String name, String address, String mobile) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }
}
