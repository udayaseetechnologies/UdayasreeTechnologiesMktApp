package com.udayasreetechnologies.sdklibrary.retrofitpkg.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostalMainModel implements Parcelable {

    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("PostOffice")
    @Expose
    private List<PostalDetailModel> postalDetailModelList = null;

    protected PostalMainModel(Parcel in) {
        message = in.readString();
        status = in.readString();
        postalDetailModelList = in.createTypedArrayList(PostalDetailModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(status);
        dest.writeTypedList(postalDetailModelList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PostalMainModel> CREATOR = new Creator<PostalMainModel>() {
        @Override
        public PostalMainModel createFromParcel(Parcel in) {
            return new PostalMainModel(in);
        }

        @Override
        public PostalMainModel[] newArray(int size) {
            return new PostalMainModel[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PostalDetailModel> getPostOffice() {
        return postalDetailModelList;
    }

    public void setPostOffice(List<PostalDetailModel> postalDetailModelList) {
        this.postalDetailModelList = postalDetailModelList;
    }
}
