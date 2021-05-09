package com.example.bottomnavigationview;

import android.graphics.drawable.Drawable;
/*
    这个类作为recyclerView中的物体类
    recyclerView中的每一行都是一个item
 */

public class item {
    private String name;
    private int image;

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }



    public item(String name, int image) {
        this.name = name;
        this.image = image;
    }


}
