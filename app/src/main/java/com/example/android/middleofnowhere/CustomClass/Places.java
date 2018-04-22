package com.example.android.middleofnowhere.CustomClass;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Custom Class to create the custom Object Places that hold six elements
 * @Param newImage - image of the place
 * @Param newPlaceName - name of the place
 * @Param newShortDescription - a brief description/curiosity about the place
 * @Param newWebsite - website of the place when available, NA should be used when there is none
 * @Param newAddress - address of the place
 * @Param newPhoneNumber - office phone number of the place
 **/
public class Places implements Parcelable{

    private final int newImage;
    private final String newPlaceName;
    private final String newShortDescription;
    private final String newWebsite;
    private final String newAddress;
    private final String newPhoneNumber;

    //constructor needed to create the custom Object
    public Places(int newImage, String newPlaceName, String newShortDescription, String newWebsite,
                  String newAddress, String newPhoneNumber) {
        this.newImage = newImage;
        this.newPlaceName = newPlaceName;
        this.newShortDescription = newShortDescription;
        this.newWebsite = newWebsite;
        this.newAddress = newAddress;
        this.newPhoneNumber = newPhoneNumber;
    }
    //methods related to Parcelable by this order
    //add data
    //write data to the parcel
    //describe its contents
    //creator of the parcel
    protected Places(Parcel in) {
        newImage = in.readInt();
        newPlaceName = in.readString();
        newShortDescription = in.readString();
        newWebsite = in.readString();
        newAddress = in.readString();
        newPhoneNumber = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(newImage);
        dest.writeString(newPlaceName);
        dest.writeString(newShortDescription);
        dest.writeString(newWebsite);
        dest.writeString(newAddress);
        dest.writeString(newPhoneNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Places> CREATOR = new Creator<Places>() {
        @Override
        public Places createFromParcel(Parcel in) {
            return new Places(in);
        }

        @Override
        public Places[] newArray(int size) {
            return new Places[size];
        }
    };

    //get methods to retrieve their values
    public int getNewImage() {
        return newImage;
    }

    public String getNewPlaceName() {
        return newPlaceName;
    }

    public String getNewShortDescription() {
        return newShortDescription;
    }

    public String getNewWebsite() {
        return newWebsite;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }

}
