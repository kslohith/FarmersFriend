package com.example.rakshitha.farmersfriend;

public class Parameters  {
    String soil,nitrogen,phosphorus,potassium, dry;

    public Parameters(){}


    public Parameters(String soil, String nitrogen, String phosphorus, String potassium, String dry) {
        this.soil = soil;
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
        this.dry = dry;
    }

    public String getSoil() {
        return soil;
    }

    public String getNitrogen() {
        return nitrogen;
    }

    public String getPhosphorus() {
        return phosphorus;
    }

    public String getPotassium() {
        return potassium;
    }

    public String getDry() {
        return dry;
    }
}
