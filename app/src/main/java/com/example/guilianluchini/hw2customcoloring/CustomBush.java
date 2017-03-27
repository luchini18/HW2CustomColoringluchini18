package com.example.guilianluchini.hw2customcoloring;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by guilianluchini on 3/25/17.
 */

public class CustomBush extends CustomElement {
    private int index;
    private RectF bush1,bush2,bush3,bush4;
    private Rect myRect;

    public CustomBush(String name, int color,int x, int y){
        super(name,color);
        myPaint = new Paint();
        myPaint.setColor(color);
        float xf = (float)x;
        float yf = (float)y;
        bush1 = new RectF(xf,yf,xf+80,yf+100);
        bush2 = new RectF(xf+50,yf,xf+130,yf+100);
        bush3 = new RectF(xf+100,yf,xf+180,yf+100);
        bush4 = new RectF(xf+150,yf,xf+230,yf+100);
        myRect = new Rect(x,y,x+230,y+100);
        index = 6;
    }

    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawOval(bush1,myPaint);
        canvas.drawOval(bush2,myPaint);
        canvas.drawOval(bush3,myPaint);
        canvas.drawOval(bush4,myPaint);
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
