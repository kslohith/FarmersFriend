package com.example.rakshitha.farmersfriend;

import android.widget.Button;

public class Farmers {
    public String name,desc,price,url;

    public Farmers(String name, String desc, String price, String url) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.url = url;
    }

    public Farmers() {

    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }
}
