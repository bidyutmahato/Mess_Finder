package com.bidyut.messfinder.Models;

public class MainModel {

    String  name;
    String location;
    String type;
    String mimage;

    MainModel(){

    }


    public MainModel(String name, String location, String type, String mimage ) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.mimage = mimage;
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
}
