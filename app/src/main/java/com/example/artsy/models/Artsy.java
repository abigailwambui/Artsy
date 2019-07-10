package com.example.artsy.models;


import org.parceler.Parcel;

@Parcel
public class Artsy {
     String description;
     String primaryImageUrl;
     String culture;
     String title;
     String creditLine;
     String medium;


    public Artsy() {}

public Artsy(String description, String primaryImageUrl, String culture, String title, String creditLine, String medium) {
    this.description = description;
    this.primaryImageUrl = primaryImageUrl;
    this.culture = culture;
    this.title = title;
    this.creditLine = creditLine;
    this.medium = medium;
}

public String getDescription() {
        return description;
}

public String getPrimaryImageUrl() {
        return primaryImageUrl;
}

public String getCulture() {
        return culture;
}

public String getTitle() {
        return title;
}

public String getCreditLine() {
        return creditLine;
}

public String getMedium () {
        return medium;
}
}
