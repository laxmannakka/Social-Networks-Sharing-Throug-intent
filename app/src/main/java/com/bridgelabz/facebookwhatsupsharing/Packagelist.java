package com.bridgelabz.facebookwhatsupsharing;

import android.graphics.drawable.Drawable;

/**
 * Created by bridgeit007 on 11/11/16.
 */

public class Packagelist {


    String appname;
    Drawable image;

    public Packagelist(String appname, Drawable image) {
        this.appname = appname;
        this.image = image;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}


