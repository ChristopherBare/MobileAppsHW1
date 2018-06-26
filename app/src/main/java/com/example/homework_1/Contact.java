package com.example.homework_1;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Contact implements Serializable {

    private String firstName;
    private String lastName;
    private String phone;
    private String company;
    private String email;
    private String url;
    private String address;
    private String birthday;
    private String nickname;
    private String facebook;
    private String twitter;
    private String skype;
    private String youtube;
    private byte[] image;

    public Contact() {
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
        this.company = "";
        this.email = "";
        this.url = "";
        this.address = "";
        this.birthday = "";
        this.nickname = "";
        this.facebook = "";
        this.twitter = "";
        this.skype = "";
        this.youtube = "";
        this.image = null;
    }

    public Contact(String firstName, String lastName, String phone, String company, String email,
                   String url, String address, String birthday, String nickname, String facebook,
                   String twitter, String skype, String youtube, byte[] image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.company = company;
        this.email = email;
        this.url = url;
        this.address = address;
        this.birthday = birthday;
        this.nickname = nickname;
        this.facebook = facebook;
        this.twitter = twitter;
        this.skype = skype;
        this.youtube = youtube;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public byte[] getImage() { return image; }

    public void setImage(byte[] image) { this.image = image; }
}
