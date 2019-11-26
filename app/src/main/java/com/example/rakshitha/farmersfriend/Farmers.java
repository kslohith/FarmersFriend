package com.example.rakshitha.farmersfriend;

import android.widget.Button;

public class Farmers {
    public String name,desc,date;

    public Farmers(String name, String desc,String date ) {
        this.name = name;
        this.desc = desc;
        this.date = date;

    }

    public Farmers() {

    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() { return date; }

}
