package com.udayasreetechnologies.sdklibrary.ui.productlist.models;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeCategoryModel {
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("categoryImage")
    @Expose
    private String categoryImage;
    @SerializedName("categoryApi")
    @Expose
    private String categoryApi;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryApi() {
        return categoryApi;
    }

    public void setCategoryApi(String categoryApi) {
        this.categoryApi = categoryApi;
    }
}
