package com.udayasreetechnologies.sdklibrary.retrofitpkg;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @GET
    Call<ArrayList<String>> getSearch();

}
