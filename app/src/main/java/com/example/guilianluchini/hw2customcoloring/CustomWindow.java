package com.example.guilianluchini.hw2customcoloring;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by guilianluchini on 3/21/17.
 */

public class CustomWindow extends CustomElement {
    private int top, bottom, left, right,color,index;
    private Rect myRect,pane1,pane2,pane3,pane4;

    public CustomWindow(String name, int color,int x, int y){
        super (name,color);
        this.color = color;
        myPaint = new Paint();
        myPaint.setColor(color);
        top = y;
        bottom = 200+y;
        left = x;
        right = 200+x;
        this.myRect = new Rect(left,top,right,bottom);
        this.pane1 = new Rect(x+20,y+20,x+90,y+90);
        this.pane2 = new Rect(x+110,y+20,x+180,y+90);
        this.pane3 = new Rect(x+20,y+110,x+90,y+180);
        this.pane4 = new Rect(x+110,y+110,x+180,y+180);
        index = 3;
    }

    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawRect(myRect,myPaint);
        myPaint.setColor(Color.CYAN);
        canvas.drawRect(pane1,myPaint);
        canvas.drawRect(pane2,myPaint);
        canvas.drawRect(pane3,myPaint);
        canvas.drawRect(pane4,myPaint);
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
