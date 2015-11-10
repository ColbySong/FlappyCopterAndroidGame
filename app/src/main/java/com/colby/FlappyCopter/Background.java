package com.colby.FlappyCopter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Colby on 2015-11-07.
 */
public class Background {
    private Bitmap image;
    private int x, y, dx; //coordinates for background

    public Background(Bitmap res){
        image = res;
        dx = GamePanel.MOVESPEED;
    }

    //allows background to move
    public void update(){

        x+=dx;

        // when background moves off the screen, bring it back
        if (x < -GamePanel.WIDTH){
            x = 0;
        }
    }

    public void draw(Canvas canvas){

        canvas.drawBitmap(image, x, y, null);
        //if the background has gone off the screen, draw another background after it
        if(x<0){
            canvas.drawBitmap(image, x+GamePanel.WIDTH, y ,null);
        }
    }

}
