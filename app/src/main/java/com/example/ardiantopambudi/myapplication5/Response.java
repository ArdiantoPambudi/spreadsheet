package com.example.ardiantopambudi.myapplication5;

import java.util.List;


import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("user")
    public List<UserItem> user;
}