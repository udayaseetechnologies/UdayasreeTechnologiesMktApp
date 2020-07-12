package com.udayasreetechnologies.sdklibrary.ui.signin.models;

import android.os.Parcel;
import android.os.Parcelable;

public class DetailModel implements Parcelable {
    private String firstName, lastName, mobile, email, password, address1, address2, landmark, country, state, city, pincode, addressType;

    public DetailModel(String firstName, String lastName, String mobile, String email, String password,
                       String address1, String address2, String landmark, String country, String state,
                       String city, String pincode, String addressType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.landmark = landmark;
        this.country = country;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.addressType = addressType;
    }

    public DetailModel(String email, String password) {
        this.email = email;
        this.password = password;
    }


    protected DetailModel(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        mobile = in.readString();
        email = in.readString();
        password = in.readString();
        address1 = in.readString();
        address2 = in.readString();
        landmark = in.readString();
        country = in.readString();
        state = in.readString();
        city = in.readString();
        pincode = in.readString();
        addressType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(mobile);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(address1);
        dest.writeString(address2);
        dest.writeString(landmark);
        dest.writeString(country);
        dest.writeString(state);
        dest.writeString(city);
        dest.writeString(pincode);
        dest.writeString(addressType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DetailModel> CREATOR = new Creator<DetailModel>() {
        @Override
        public DetailModel createFromParcel(Parcel in) {
            return new DetailModel(in);
        }

        @Override
        public DetailModel[] newArray(int size) {
            return new DetailModel[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }

    public String getAddressType() {
        return addressType;
    }
}
