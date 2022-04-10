package com.bidyut.messfinder.Models;

public class Users {

    String profilepic, userName , mail ,passowrd, userId, message;

    public Users(String profilepic, String userName, String mail, String passowrd, String userId, String message) {
        this.profilepic = profilepic;
        this.userName = userName;
        this.mail = mail;
        this.passowrd = passowrd;
        this.userId = userId;
        this.message = message;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
