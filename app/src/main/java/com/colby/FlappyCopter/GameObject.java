package com.colby.FlappyCopter;

import android.graphics.Rect;

/**
 * Created by Colby on 2015-11-07.
 */

//all objects of the game will extend this class and have the declared fields
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected int width;
    protected int height;

    public void setX(int x){
        this.x=x;

    }

    public void setY(int y){
        this.y=y;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    //this will be used to check collisions (objects are essential rectangeles and will intersect when they colllide)
    public Rect getRectangle(){
        return new Rect(x, y, x+width, y+height);
    }
}
