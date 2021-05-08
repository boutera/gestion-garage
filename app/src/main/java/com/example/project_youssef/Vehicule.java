package com.example.project_youssef;

import android.graphics.drawable.Drawable;

public class Vehicule {
    private String mName;
    private String mDescription;
    private Drawable mImage;



    public Vehicule( String mName, String mDescription,Drawable mImage){
        this.mName = mName;
        this.mDescription = mDescription;
        this.mImage = mImage;


    }

    public Drawable getVehiculeImage() {return mImage;}
    public String getVehiculeName() {return mName;}
    public String getVehiculeDesc() {return mDescription;}
}
