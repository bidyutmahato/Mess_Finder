package com.bidyut.messfinder.Models;

public class MainModel {

    String  name ,location , type;

    MainModel(){

    }

    public MainModel(String name, String location, String type) {
        this.name = name;
        this.location = location;
        this.type = type;
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

    public void setLocation(String food) {
        this.location = food;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
