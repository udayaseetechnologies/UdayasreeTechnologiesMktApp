package com.udayasreetechnologies.sdklibrary.retrofitpkg.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeBannerModel implements Parcelable {
    @SerializedName("parentId")
    @Expose
    private String parentId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("Ischild")
    @Expose
    private String ischild;
    @SerializedName("leveltype")
    @Expose
    private String leveltype;
    @SerializedName("categoryImage")
    @Expose
    private String categoryImage;

    protected HomeBannerModel(Parcel in) {
        parentId = in.readString();
        name = in.readString();
        position = in.readString();
        ischild = in.readString();
        leveltype = in.readString();
        categoryImage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(parentId);
        dest.writeString(name);
        dest.writeString(position);
        dest.writeString(ischild);
        dest.writeString(leveltype);
        dest.writeString(categoryImage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeBannerModel> CREATOR = new Creator<HomeBannerModel>() {
        @Override
        public HomeBannerModel createFromParcel(Parcel in) {
            return new HomeBannerModel(in);
        }

        @Override
        public HomeBannerModel[] newArray(int size) {
            return new HomeBannerModel[size];
        }
    };

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIschild() {
        return ischild;
    }

    public void setIschild(String ischild) {
        this.ischild = ischild;
    }

    public String getLeveltype() {
        return leveltype;
    }

    public void setLeveltype(String leveltype) {
        this.leveltype = leveltype;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
