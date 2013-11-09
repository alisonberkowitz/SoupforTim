package com.example.soupfortim;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
        final TextView pointcount = (TextView)this.findViewById(R.id.points);

        spoon.setImageResource(R.drawable.fullspoon);
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

                        int mouthy = wh/3 - 100;
                        int h2t = wh/3 + wh/3;
                        int whalf = ww/2;

                        int cursorx = x-175;
                        int cursory = y-175;

                        lp.setMargins(cursorx , y-175,0,0);
                        spoon.setLayoutParams(lp);

                        //when cursor position is in the area of tims mouth we get 10 points
                        if (whalf+120<cursorx && cursorx<whalf+200 && mouthy-50<cursory && cursory<mouthy+50 && eat) {
                            points = points + 10;
                            //Toast.makeText(getApplicationContext(), "Points = " + String.valueOf(points), Toast.LENGTH_SHORT).show();
                            Log.d((String.valueOf(whalf+100) + " to " + String.valueOf(whalf+200)),"the soup box");
                            Log.d((String.valueOf(mouthy - 50) + " to " + String.valueOf(mouthy + 50)), "the soup box");
                            eat = false;
                            spoon.setImageResource(R.drawable.spoon_icon);
                            pointcount.setText("Points = "+ String.valueOf(points));
                            break;
                        }

                        //REFILLING SOUP
                        if (whalf-25<cursorx && cursorx<whalf+25 && h2t-50<cursory && cursory<h2t+50){
                            eat = true;
                            Log.d((String.valueOf(whalf-25) + " to " + String.valueOf(whalf+25)),"the soup box");
                            Log.d((String.valueOf(h2t-50) + " to " + String.valueOf(h2t+50)),"the soup box");
                            spoon.setImageResource(R.drawable.fullspoon);
                            //Toast.makeText(getApplicationContext(), "Eat the soup, Tim!", Toast.LENGTH_SHORT).show();
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
