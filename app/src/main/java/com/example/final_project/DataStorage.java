package com.example.final_project;

import android.service.notification.StatusBarNotification;

public class DataStorage {

    String fullname, email, dateofbirth, password, location, phonenumber;
    String propertytype,propertysize,propertyprice ,propertybathroom, propertylocation,propertybalcony,propertygarage,propertypool;

    String message, time;

    public DataStorage() {
    }

public DataStorage(String propertytype, String propertysize, String propertyprice, String propertybathroom, String propertylocation, String propertybalcony, String propertygarage, String propertypool){
        this.propertytype = propertytype;
        this.propertysize = propertysize;
        this.propertyprice = propertyprice;
        this.propertybathroom = propertybathroom;
        this.propertylocation = propertylocation;
        this.propertybalcony = propertybalcony;
        this.propertygarage = propertygarage;
        this.propertypool = propertypool;
}
    public DataStorage(String fullname, String email, String dateofbirth, String password, String location, String phonenumber) {
        this.fullname = fullname;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.password = password;
        this.location = location;
        this.phonenumber = phonenumber;
    }
    public DataStorage(String message) {
        this.message = message;

    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }




    public String getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype;
    }

    public String getPropertysize() {
        return propertysize;
    }

    public void setPropertysize(String propertysize) {
        this.propertysize = propertysize;
    }

    public String getPropertyprice() {
        return propertyprice;
    }

    public void setPropertyprice(String propertyprice) {
        this.propertyprice = propertyprice;
    }

    public String getPropertybathroom() {
        return propertybathroom;
    }

    public void setPropertybathroom(String propertybathroom) {
        this.propertybathroom = propertybathroom;
    }

    public String getPropertylocation() {
        return propertylocation;
    }

    public void setPropertylocation(String propertybathroom) {
        this.propertylocation = propertylocation;
    }

    public String getPropertybalcony() {
        return propertybalcony;
    }

    public void setPropertybalcony(String propertybalcony) {
        this.propertybalcony = propertybalcony;
    }

    public String getPropertygarage() {
        return propertygarage;
    }

    public void setPropertygarage(String propertygarage) {
        this.propertygarage = propertygarage;
    }

    public String getPropertypool() {
        return propertypool;
    }

    public void setPropertypool(String propertypool) {
        this.propertypool= propertypool;
    }

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public StatusBarNotification getSender() {
//        return sender;
//    }
}
