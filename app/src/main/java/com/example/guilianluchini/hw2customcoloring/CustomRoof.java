package com.example.guilianluchini.hw2customcoloring;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by guilianluchini on 3/21/17.
 */
/**
 External Citation
 Date:     25 March 2017
 Problem:  drawing a triangle
 Resource:
 http://stackoverflow.com/questions/3501126/how-to-draw-a-filled-triangle-in-android-canvas
 Solution: I used the example code from this post in the drawMe method
 */

public class CustomRoof extends CustomElement {
    private int x,y,width,height,index;
    private Paint myPaint;
    private Rect myRect;


    public CustomRoof(String name, int color, int x, int y){
        super(name, color);
        this.x = x;
        this.y = y;
        myPaint = new Paint();
        myPaint.setColor(color);
        width = 550;
        height = 250;
        myRect = new Rect(x,y-height,x+width,y);
        index = 2;
    }

    @Override
    public void drawMe(Canvas canvas) {
        Point p1 = new Point(x,y);
        int pointX = x + width/2;
        int pointY =  y - height;

        Point p2 = new Point(pointX,pointY);
        Point p3 = new Point(x+width,y);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(p1.x,p1.y);
        path.lineTo(p2.x,p2.y);
        path.lineTo(p3.x,p3.y);
        path.close();

        canvas.drawPath(path, myPaint);
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
