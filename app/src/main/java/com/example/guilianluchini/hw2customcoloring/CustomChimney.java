package com.example.guilianluchini.hw2customcoloring;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by guilianluchini on 3/23/17.
 */

public class CustomChimney extends CustomElement {
    private int top, bottom, left, right,top2, bottom2, left2, right2,index;
    private Rect topRect,bottomRect;

    public CustomChimney(String name, int color,int x, int y){
        super(name, color);
        myPaint = new Paint();
        myPaint.setColor(color);
        top = y;
        bottom = 50+y;
        left = x;
        right = 60+x;
        top2 = y;
        bottom2 = 130+y;
        left2 = x+10;
        right2 = 50+x;
        this.topRect = new Rect(left,top,right,bottom);
        this.bottomRect = new Rect(left2,top2,right2,bottom2);
        index = 5;
    }

    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawRect(topRect,myPaint);
        canvas.drawRect(bottomRect,myPaint);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        int left = this.topRect.left - TAP_MARGIN;
        int top = this.topRect.top - TAP_MARGIN;
        int right = this.topRect.right + TAP_MARGIN;
        int bottom = this.topRect.bottom + TAP_MARGIN;
        Rect topR = new Rect(left, top, right, bottom);

        int left2 = this.bottomRect.left - TAP_MARGIN;
        int top2 = this.bottomRect.top - TAP_MARGIN;
        int right2 = this.bottomRect.right + TAP_MARGIN;
        int bottom2 = this.bottomRect.bottom + TAP_MARGIN;
        Rect bottomR = new Rect(left2, top2, right2, bottom2);

        if (topR.contains(x, y)){return true;}
        else if (bottomR.contains(x,y)){return true;}
        else {return false;}
    }

    public int getIndex() {
        return index;
    }

}
