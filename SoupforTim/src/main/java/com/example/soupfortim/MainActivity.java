package com.example.soupfortim;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    static int x = 0;
    static int y =0;
    int wh;
    int ww;

    DrawingPanel drawingPanel;
    Canvas canvas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wh = getWindowManager().getDefaultDisplay().getHeight();
        ww = getWindowManager().getDefaultDisplay().getWidth();

        Log.d(String.valueOf(wh), "heightuwant");
        Log.d(String.valueOf(ww), "widthuneed");

        final RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        final ImageView spoon = (ImageView) this.findViewById(R.id.spoon);
        spoon.setImageResource(R.drawable.spoon_icon);
        spoon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = Math.round(motionEvent.getRawX());

                        y = Math.round(motionEvent.getRawY());
                        Log.d(String.valueOf(x),"were moving");
                        Log.d(String.valueOf(y),"were moving");


                        lp.setMargins(x-50 , y-175,0,0);
                        spoon.setLayoutParams(lp);
                }

                return true;


//                if (motionEvent.getRawX() > ww-5) {
//                     x = ww;
//                }
//                if (motionEvent.getRawY() > wh-5) {
//                    y = wh;
//                }
//                if (motionEvent.getAction() == motionEvent.ACTION_DOWN){
////                    drawingPanel.postInvalidate();
////                    drawingPanel.onDraw(canvas);
//                    return true;
//                }
//                if (motionEvent.getAction() == motionEvent.ACTION_MOVE){
//                    x = Math.round(motionEvent.getRawX());
//
//                    y = Math.round(motionEvent.getRawX());
//                    Log.d(String.valueOf(x),"were moving");
//                    Log.d(String.valueOf(y),"were moving");
//
//
//                    lp.setMargins(x-25 , y-75,0,0);
//                    spoon.setLayoutParams(lp);
//
////                    drawingPanel.postInvalidate();
////                    drawingPanel.onDraw(canvas);
//                    return true;
//                }
////                drawingPanel.animate();
//                return true;
            }

        });
    }
}
