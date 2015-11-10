package com.colby.FlappyCopter;

import android.graphics.Bitmap;

/**
 * Created by Colby on 2015-11-07.
 */

//this class draws the images held in image array and decides which image to draw
public class Animation {
    private Bitmap[] frames;
    private int currentFrame;
    private long startTime;
    private long delay;
    private boolean playedOnce;

    public void setFrames(Bitmap[] frames){
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }
    
    public void setDelay(long d){
        delay = d;
    }

    public void setFrame(int i){
        currentFrame = i ;
    }

    public void update(){
        //time counters are used in capping the fps, inscrementing the score and now decidinng which image to display
        long elapsed = (System.nanoTime()-startTime)/1000000;

        if (elapsed > delay){
            currentFrame ++;
            startTime = System.nanoTime();
        }
        if (currentFrame == frames.length){
            currentFrame = 0;
            playedOnce = true;
        }
    }

    public Bitmap getImage(){
        return frames[currentFrame];
    }

    public int getFrame(){
        return currentFrame;
    }

    public boolean playedOnce(){
        return playedOnce;
    }
}
