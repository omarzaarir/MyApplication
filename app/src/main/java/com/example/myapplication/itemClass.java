package com.example.myapplication;

public class itemClass {
    public String nam;
    public String dscr;

    public boolean due=false;
    itemClass(String nam,String dscr,boolean due ){
        this.dscr=dscr;
        this.nam=nam;
        this.due=due;
    }
}
