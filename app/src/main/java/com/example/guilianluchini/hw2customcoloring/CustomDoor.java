package com.example.guilianluchini.hw2customcoloring;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by guilianluchini on 3/23/17.
 */

public class CustomDoor extends CustomElement {
    private int top, bottom, left, right,doorknobX, doorknobY, color,index;
    private Rect myRect;

    public CustomDoor(String name, int color, int x, int y){
        super(name,color);
        this.color = color;
        myPaint = new Paint();
        myPaint.setColor(color);
        top = y;
        bottom = 200+y;
        left = x;
        right = 150+x;
        doorknobX = x+40;
        doorknobY = y + 100;
        this.myRect = new Rect(left,top,right,bottom);
        index = 4;
    }

    @Override
    public void drawMe(Canvas canvas) {
        //door
        canvas.drawRect(myRect,myPaint);
        //doorknob
        myPaint.setColor(Color.YELLOW);
        canvas.drawCircle(doorknobX, doorknobY, 30, myPaint);
        myPaint.setColor(color);

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
