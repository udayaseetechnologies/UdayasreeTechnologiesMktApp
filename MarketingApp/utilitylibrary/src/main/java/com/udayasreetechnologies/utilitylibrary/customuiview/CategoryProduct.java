package com.udayasreetechnologies.utilitylibrary.customuiview;

public class CategoryProduct {
    private String categoryName, categoryImage, categoryURL;

    public CategoryProduct(String categoryName, String categoryImage, String categoryURL) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryURL = categoryURL;
    }

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

    public String getCategoryURL() {
        return categoryURL;
    }

    public void setCategoryURL(String categoryURL) {
        this.categoryURL = categoryURL;
    }
}
