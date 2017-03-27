package com.example.guilianluchini.hw2customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import java.util.Vector;

/**
 * Created by guilianluchini on 3/26/17.
 */
/**
 External Citation
 Date:     26 March 2017
 Problem:  creating a surface view class from the lecture example
 Resource: Moodle/Nuxoll
 Solution: I used the example code from this post.
 */
public class MySurfaceView extends SurfaceView implements View.OnTouchListener {
    //instance variables
    Vector<CustomElement> myElements = new Vector<CustomElement>();
    public int bodyColor = Color.rgb(25,25,112);
    public int roofColor = Color.rgb(200,34,34);
    public int windowColor = Color.rgb(139,69,19);
    public int doorColor = Color.rgb(255,165,0);
    public int chimneyColor = Color.rgb(0,0,0);
    public int bushColor = Color.rgb(0,125,0);;
    private int index = 0;

    private CustomRoof roof;
    private CustomBody body;
    private CustomChimney chimney;
    private CustomDoor door;
    private CustomWindow window;
    private CustomBush bush;


    /** called by the ctors to initialize the variables I've added to this class */
    private void myInitializationStuff()
    {
        setWillNotDraw(false);

        //listen for the user to touch me
        this.setOnTouchListener(this);
    }

    public MySurfaceView(Context context) {
        super(context);
        myInitializationStuff();
    }

    public MySurfaceView(Context context, AttributeSet set) {
        super(context, set);
        myInitializationStuff();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        myInitializationStuff();
    }

    /**draw shapes*/
    @Override
    public void draw(Canvas canvas) {
        //background
        Paint skyBlue = new Paint();
        int skyColor = Color.rgb(135,206,250);
        skyBlue.setColor(skyColor);
        Rect sky = new Rect(0,0,2000,2000);
        canvas.drawRect(sky,skyBlue);
        //grass
        Paint grassGreen = new Paint();
        int grassColor = Color.rgb(0, 217, 0);
        grassGreen.setColor(grassColor);
        Rect grass = new Rect(0,750,2000,2000);
        canvas.drawRect(grass,grassGreen);

        body = new CustomBody("House Body",bodyColor, 500, 500);
        myElements.add(body);

        roof = new CustomRoof("Roof", roofColor, 460, 500);
        myElements.add(roof);

        window = new CustomWindow("Window",windowColor, 750, 530);
        myElements.add(window);

        door = new CustomDoor("Door",doorColor, 550, 775);
        myElements.add(door);

        chimney = new CustomChimney("Chimney",chimneyColor, 560, 300);
        myElements.add(chimney);

        bush = new CustomBush("Bush", bushColor, 750, 900);
        myElements.add(bush);

        for (CustomElement element : myElements) {
            element.drawMe(canvas);
        }
    }

    /** when the user touches the surface view,check to see if it is on a part of the house */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        for (CustomElement element : myElements) {
            if (element.containsPoint((int) event.getX(), (int) event.getY())) {
                ((MainActivity)getContext()).setTextView(element.getName());
                index = element.getIndex();
                ((MainActivity)getContext()).setSeekBars(element.getColor());

            }
        }
        //force the surface to redraw itself
        this.invalidate();

        return true;
    }

    public int getIndex() {
        return index;
    }
}// class MySurfaceView

