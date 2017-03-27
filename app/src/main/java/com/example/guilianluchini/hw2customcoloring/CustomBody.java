package com.example.guilianluchini.hw2customcoloring;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


/**
 * Created by guilianluchini on 3/21/17.
 */
/**
 External Citation
 Date:     26 March 2017
 Problem:  drawing a rectangle
 Resource: Moodle Example
 Solution: I used most of the customRectangle class in here
 */
public class CustomBody extends CustomElement {
    private int top, bottom, left, right, index;
    private Rect myRect;


    public CustomBody(String name, int color, int x, int y){
        super(name,color);
        myPaint = new Paint();
        myPaint.setColor(color);
        top = y;
        bottom = 475+y;
        left = x;
        right = 475+x;
        this.myRect = new Rect(left,top,right,bottom);
        index = 1;
    }

    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawRect(myRect,myPaint);
        canvas.drawRect(myRect,outlinePaint);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        int left = this.myRect.left - TAP_MARGIN;
        int top = this.myRect.top - TAP_MARGIN;
        int right = this.myRect.right + TAP_MARGIN;
        int bottom = this.myRect.bottom + TAP_MARGIN;
        Rect r = new Rect(left, top, right, bottom);

        return r.contains(x, y);

    }

    public int getIndex() {
        return index;
    }

}
