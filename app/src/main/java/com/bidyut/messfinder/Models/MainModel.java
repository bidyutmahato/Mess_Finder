package com.bidyut.messfinder.Models;

public class MainModel {

    String  name ,food , type;

    MainModel(){

    }

    public MainModel(String name, String food, String type) {
        this.name = name;
        this.food = food;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
