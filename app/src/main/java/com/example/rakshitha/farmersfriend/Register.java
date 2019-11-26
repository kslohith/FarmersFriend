package com.example.rakshitha.farmersfriend;

public class Register {
    public String name , usn , branch , event_name;

    public Register(){}

    public Register(String name, String usn, String branch, String event_name) {
        this.name = name;
        this.usn = usn;
        this.branch = branch;
        this.event_name = event_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }
}
