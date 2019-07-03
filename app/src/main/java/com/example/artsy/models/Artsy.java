package com.example.artsy.models;


import org.parceler.Parcel;

@Parcel
public class Artsy {
     String mDescription;
     String mPrimaryImageUrl;
     String mCulture;
     String mTitle;
     String mCreditLine;
     String mMedium;


    public Artsy() {}

public Artsy(String description, String primaryImageUrl, String culture, String title, String creditLine, String medium) {
    this.mDescription = description;
    this.mPrimaryImageUrl = primaryImageUrl;
    this.mCulture = culture;
    this.mTitle = title;
    this.mCreditLine = creditLine;
    this.mMedium = medium;
}

public String getDescription() {
        return mDescription;
}

public String getPrimaryImageUrl() {
        return mPrimaryImageUrl;
}

public String getCulture() {
        return mCulture;
}

public String getTitle() {
        return mTitle;
}

public String getCreditLine() {
        return mCreditLine;
}

public String getMedium () {
        return mMedium;
}
}
