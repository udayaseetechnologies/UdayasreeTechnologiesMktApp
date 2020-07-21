package com.udayasreetechnologies.sdklibrary.ui.productlist.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeProductModel {
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productImage")
    @Expose
    private String productImage;
    @SerializedName("productApi")
    @Expose
    private String productApi;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductApi() {
        return productApi;
    }

    public void setProductApi(String productApi) {
        this.productApi = productApi;
    }
}
