package com.example.guilianluchini.hw2customcoloring;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 External Citation
 Date:     24 March 2017
 Problem:  getting seekbars to record colors
 Resource:
 http://stackoverflow.com/questions/23896216/set-3-
 seekbars-to-change-rgb-channels
 Solution: I used the example code from this post.
 */
public class MainActivity extends AppCompatActivity{
    //instance variables
    private int seekR, seekG, seekB, color, index;;
    private MySurfaceView msv;
    private TextView redNum, greenNum, blueNum;
    private TextView selectedTextView;
    private SeekBar sbR,sbG,sbB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find views
        sbR = (SeekBar) findViewById(R.id.redSeekBar);
        sbG = (SeekBar) findViewById(R.id.greenSeekBar);
        sbB = (SeekBar) findViewById(R.id.blueSeekBar);
        selectedTextView = (TextView) findViewById(R.id.CustomElementTextView);
        redNum = (TextView) findViewById(R.id.redNumTextView);
        greenNum = (TextView) findViewById(R.id.greenNumTextView);
        blueNum = (TextView) findViewById(R.id.blueNumTextView);
        msv = (MySurfaceView)this.findViewById(R.id.surfaceView);
        msv.invalidate();

        //rgb color spectrum
        sbR.setMax(255);
        sbG.setMax(255);
        sbB.setMax(255);

        //red seek bar listener
        sbR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekR = progress;
                updateColor();
                updateDraw();
                msv.invalidate();
            }
        });

        //green seek bar listener
        sbG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekG = progress;
                updateColor();
                updateDraw();
                msv.invalidate();
            }
        });

        //blue seekbar listener
        sbB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekB = progress;
                updateColor();
                updateDraw();
                msv.invalidate();
            }
        });

    }//onCreate

    //update textviews and change color of shape
    private void updateColor() {
       //set text
        redNum.setText("" + seekR);
        greenNum.setText("" + seekG);
        blueNum.setText("" + seekB);
    }

    public int getColor(){
        color = Color.rgb(seekR, seekG, seekB);
        return color;
    }

    /**
     External Citation
     Date:     24 March 2017
     Problem:  accessing textViews from my custom surface view class
     Resource:
     http://stackoverflow.com/questions/8685201/communication-between-custom-surfaceview-and-default-androids-views
     Solution: I used the example code from this post, followed the same format for setSeekBars
     */
    public void setTextView(final String txt){
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                selectedTextView.setText(txt);
            }
        });
    }

    public void setSeekBars(final int color){
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                int r = Color.red(color);
                int g = Color.green(color);
                int b = Color.blue(color);
                sbR.setProgress(r);
                sbG.setProgress(g);
                sbB.setProgress(b);
            }
        });
    }
    //update drawing used when the seekbars are moved, redraws
    public void updateDraw(){
        index = msv.getIndex();
        if (index == 1){
            msv.bodyColor = Color.rgb(sbR.getProgress(),sbG.getProgress(),sbB.getProgress());
        }
        else if (index == 2) {
            msv.roofColor = Color.rgb(sbR.getProgress(), sbG.getProgress(), sbB.getProgress());
        }
        else if (index == 3) {
            msv.windowColor = Color.rgb(sbR.getProgress(), sbG.getProgress(), sbB.getProgress());
        }
        else if (index == 4) {
            msv.doorColor = Color.rgb(sbR.getProgress(), sbG.getProgress(), sbB.getProgress());
        }
        else if (index == 5) {
            msv.chimneyColor = Color.rgb(sbR.getProgress(), sbG.getProgress(), sbB.getProgress());
        }
        else if (index == 6) {
            msv.bushColor = Color.rgb(sbR.getProgress(), sbG.getProgress(), sbB.getProgress());
        }
    }

}//class MainActivity
