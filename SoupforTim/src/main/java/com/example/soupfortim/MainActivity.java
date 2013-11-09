package com.example.soupfortim;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    static int x = 0;
    static int y =0;
    int wh;
    int ww;
    int points = 0;
    boolean eat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wh = getWindowManager().getDefaultDisplay().getHeight();
        ww = getWindowManager().getDefaultDisplay().getWidth();

        Log.d(String.valueOf(wh), "heightuwant");
        Log.d(String.valueOf(ww), "widthuneed");

        final RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        final RelativeLayout.LayoutParams sop = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        final ImageView soup = (ImageView) this.findViewById(R.id.soup);
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

                        int h1t = wh/3;
                        int h2t = wh/3 + wh/3;
                        int whalf = ww/2;



                        lp.setMargins(x-50 , y-175,0,0);
                        spoon.setLayoutParams(lp);

                        sop.setMargins(whalf, h2t,0,0);
                        soup.setLayoutParams(sop);

                        if (whalf-25<x-50 && x-50<whalf+25 && h1t-50<y-175 && y-175<h1t+50 && eat) {
                            points = points + 10;
                            Toast.makeText(getApplicationContext(), "Points = " + String.valueOf(points), Toast.LENGTH_SHORT).show();
                            eat = false;
                            break;
                        }

                        //REFILLING SOUP
                        if (whalf-50<x-50 && x-50<whalf+50 && h2t-50<y-175 && y-175<h2t+50){
                            eat = true;
                            Toast.makeText(getApplicationContext(), "Eat the soup, Tim!", Toast.LENGTH_SHORT).show();
                        }
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
