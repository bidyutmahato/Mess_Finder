package com.bidyut.messfinder.Models;

public class MainModel {

    String  name;
    String location;
    String type;
    String mimage;
    String amount;
    String about;

    MainModel(){

    }


    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public MainModel(String name, String location, String type, String mimage, String amount, String about ) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.mimage = mimage;
        this.amount = amount;
        this.about = about;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMimage() {
        return mimage;
    }

    public void setMimage(String mimage) {
        this.mimage = mimage;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
