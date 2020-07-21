package com.udayasreetechnologies.sdklibrary.ui.productlist.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainHomeModel {
    @SerializedName("viewType")
    @Expose
    private int viewType;
    @SerializedName("sliderImage")
    @Expose
    private List<String> sliderImage = null;
    @SerializedName("categories")
    @Expose
    private List<HomeCategoryModel> categories = null;
    @SerializedName("products")
    @Expose
    private List<HomeProductModel> products = null;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public List<String> getSliderImage() {
        return sliderImage;
    }

    public void setSliderImage(List<String> sliderImage) {
        this.sliderImage = sliderImage;
    }

    public List<HomeCategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(List<HomeCategoryModel> categories) {
        this.categories = categories;
    }

    public List<HomeProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<HomeProductModel> products) {
        this.products = products;
    }
}
