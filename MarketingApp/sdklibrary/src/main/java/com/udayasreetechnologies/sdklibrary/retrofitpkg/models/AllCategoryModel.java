package com.udayasreetechnologies.sdklibrary.retrofitpkg.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCategoryModel implements Parcelable {
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
    @SerializedName("category_icon")
    @Expose
    private String categoryIcon;

    protected AllCategoryModel(Parcel in) {
        parentId = in.readString();
        name = in.readString();
        position = in.readString();
        ischild = in.readString();
        leveltype = in.readString();
        categoryIcon = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(parentId);
        dest.writeString(name);
        dest.writeString(position);
        dest.writeString(ischild);
        dest.writeString(leveltype);
        dest.writeString(categoryIcon);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AllCategoryModel> CREATOR = new Creator<AllCategoryModel>() {
        @Override
        public AllCategoryModel createFromParcel(Parcel in) {
            return new AllCategoryModel(in);
        }

        @Override
        public AllCategoryModel[] newArray(int size) {
            return new AllCategoryModel[size];
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

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }
}
