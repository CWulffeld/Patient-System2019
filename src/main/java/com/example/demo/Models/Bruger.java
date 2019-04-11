package com.example.demo.Models;


public class Bruger {

    private String rolle;

    public Bruger(String rolle) {
        this.rolle = rolle;
    }


    public Bruger(){

    }


    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
}
