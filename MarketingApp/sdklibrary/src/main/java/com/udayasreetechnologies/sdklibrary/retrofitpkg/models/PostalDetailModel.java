package com.udayasreetechnologies.sdklibrary.retrofitpkg.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostalDetailModel implements Parcelable {
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("BranchType")
    @Expose
    private String branchType;
    @SerializedName("DeliveryStatus")
    @Expose
    private String deliveryStatus;
    @SerializedName("Taluk")
    @Expose
    private String taluk;
    @SerializedName("Circle")
    @Expose
    private String circle;
    @SerializedName("District")
    @Expose
    private String district;
    @SerializedName("Division")
    @Expose
    private String division;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("State")
    @Expose
    private String state;
    @SerializedName("Country")
    @Expose
    private String country;

    protected PostalDetailModel(Parcel in) {
        name = in.readString();
        description = in.readString();
        branchType = in.readString();
        deliveryStatus = in.readString();
        taluk = in.readString();
        circle = in.readString();
        district = in.readString();
        division = in.readString();
        region = in.readString();
        state = in.readString();
        country = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(branchType);
        dest.writeString(deliveryStatus);
        dest.writeString(taluk);
        dest.writeString(circle);
        dest.writeString(district);
        dest.writeString(division);
        dest.writeString(region);
        dest.writeString(state);
        dest.writeString(country);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PostalDetailModel> CREATOR = new Creator<PostalDetailModel>() {
        @Override
        public PostalDetailModel createFromParcel(Parcel in) {
            return new PostalDetailModel(in);
        }

        @Override
        public PostalDetailModel[] newArray(int size) {
            return new PostalDetailModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
