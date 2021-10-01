package com.example.salonlumm.model;

public class AppointModel {
    String date,time,name,branch;

    public AppointModel() {

    }

    public AppointModel(String date, String time, String name, String branch) {
        this.date = date;
        this.time = time;
        this.name = name;
        this.branch = branch;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
