package com.example.androidvolley;


import com.google.gson.annotations.SerializedName;

public class StudentsJson {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String displayName;

    @SerializedName("address")
    String address;

    @SerializedName("mobile")
    String mobile;

    @SerializedName("2")
    String value;

    @Override
    public String toString() {
        return "StudentsJson{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public StudentsJson(String id, String displayName, String address, String mobile, String value) {
        this.id = id;
        this.displayName = displayName;
        this.address = address;
        this.mobile = mobile;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }


}
