package com.bidyut.messfinder.Models;

public class Users {

    String profilepic, userName , mail ,passowrd;

    public Users(String profilepic, String userName, String mail, String passowrd, String userId, String message, String messName , String location) {
        this.profilepic = profilepic;
        this.userName = userName;
        this.mail = mail;
        this.passowrd = passowrd;

    }

    // empty constructor
    public Users (){

    }

    // sign up constructor
    public Users( String userName, String mail, String passowrd) {
        this.userName = userName;
        this.mail = mail;
        this.passowrd = passowrd;
    }


    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

}
