package com.udayasreetechnologies.utilitylibrary.customuiview;

import java.util.ArrayList;

public class DeleteResponse {
    private ArrayList<String> bannerImages;

    private ArrayList<CategoryProduct> category;

    private String productName, productImage, productURL;

    public DeleteResponse(ArrayList<String> bannerImages, ArrayList<CategoryProduct> category,
                          String productName, String productImage, String productURL) {
        this.bannerImages = bannerImages;
        this.category = category;
        this.productName = productName;
        this.productImage = productImage;
        this.productURL = productURL;
    }

    public ArrayList<String> getBannerImages() {
        return bannerImages;
    }

    public void setBannerImages(ArrayList<String> bannerImages) {
        this.bannerImages = bannerImages;
    }

    public ArrayList<CategoryProduct> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<CategoryProduct> category) {
        this.category = category;
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

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }
}
