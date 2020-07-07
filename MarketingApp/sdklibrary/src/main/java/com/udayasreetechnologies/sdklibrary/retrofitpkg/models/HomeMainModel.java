package com.udayasreetechnologies.sdklibrary.retrofitpkg.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeMainModel implements Parcelable {
    @SerializedName("banner")
    @Expose
    private List<HomeBannerModel> homeBannerModels = null;
    @SerializedName("list")
    @Expose
    private List<Object> list = null;

    protected HomeMainModel(Parcel in) {
        homeBannerModels = in.createTypedArrayList(HomeBannerModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(homeBannerModels);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeMainModel> CREATOR = new Creator<HomeMainModel>() {
        @Override
        public HomeMainModel createFromParcel(Parcel in) {
            return new HomeMainModel(in);
        }

        @Override
        public HomeMainModel[] newArray(int size) {
            return new HomeMainModel[size];
        }
    };

    public List<HomeBannerModel> getBanner() {
        return homeBannerModels;
    }

    public void setBanner(List<HomeBannerModel> homeBannerModels) {
        this.homeBannerModels = homeBannerModels;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
