package com.colby.FlappyCopter;

import android.graphics.Bitmap;
import android.graphics.Canvas;


/**
 * Created by Colby on 2015-11-07.
 */
public class Player extends GameObject{

    private Bitmap spritesheet;
    private int score;
    private double dya; // acceleration in y direction
    private boolean up;
    private boolean playing;
    private Animation animation = new Animation();
    private long startTime;

    public Player(Bitmap res, int w, int h, int numFrames){
        x = 100;
        y = GamePanel.HEIGHT/2;
        dy = 0;
        score = 0;
        height = h;
        width = w;

        //bitmap array that stores sprites for image of the player
        // animation class will scroll through the images in the array to create a helicopter wing moving effect
        Bitmap[] image = new Bitmap[numFrames];
        spritesheet = res;

        for (int i = 0 ; i <image.length; i++){

            image[i]= Bitmap.createBitmap(spritesheet, i*width, 0, width, height);
        }

        animation.setFrames(image);
        animation.setDelay(10);
        startTime = System.nanoTime();
    }

    //this method is called by the motion event, pressing up
    public void setUp (boolean b){
        up = b;
    }

    public void update (){
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if (elapsed > 100){
            score ++;
            startTime = System.nanoTime();
        }

        animation.update();

        if (up){
            dy = (int) (dya -= 1.1);
        }
        else {
            dy = (int) (dya += 1.1);
        }

        //cap speed of helicopter
        if (dy > 14) {
            dy = 14;
        }

        if (dy < -14){
            dy = -14;
        }

        y += dy*2;
        dy = 0;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(animation.getImage(), x, y, null);
    }

    public int getScore(){
        return score;
    }

    public boolean getPlaying(){
        return playing;
    }

    public void setPlaying(boolean b){
        playing = b;
    }
    public void resetDYA(){
        dya = 0;
    }
    public void resetScore(){
        score = 0;
    }
}
