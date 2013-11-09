package com.example.soupfortim;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.graphics.Canvas;

public class MainActivity extends Activity {

    static float x = 0;
    static float y =0;

    DrawingPanel drawingPanel;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawingPanel = new DrawingPanel(this);
        canvas = new Canvas();

        final ImageView spoon = (ImageView) this.findViewById(R.id.spoon);
        spoon.setImageResource(R.drawable.spoon_icon);
        spoon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == motionEvent.ACTION_DOWN){
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    Log.d(String.valueOf(x), "we touched the screen");
                    drawingPanel.postInvalidate();
                    drawingPanel.onDraw(canvas);
                    return true;
                }
                if (motionEvent.getAction() == motionEvent.ACTION_MOVE){
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    Log.d(String.valueOf(x),"were moving");
                    drawingPanel.postInvalidate();
                    drawingPanel.onDraw(canvas);
                    return true;
                }
                drawingPanel.postInvalidate();
                return true;
            }
        });

/*        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        ImageView img = (ImageView) this.findViewById(R.id.tim);
        img.setBackgroundResource(R.drawable.spin_animation);

        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

        // Start the animation (looped playback by default).
        frameAnimation.start();*/
    }


/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(android.R.menu.main, menu);
        return true;
    }
    */
}
