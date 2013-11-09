package com.example.soupfortim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by alison on 11/9/13.
 */
public class DrawingPanel extends SurfaceView {
    public DrawingPanel(Context context) {
        super(context);
    }


    @Override
    public void onDraw(Canvas canvas) {
        //do drawing stuff here.
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spoon_icon);
        canvas.drawBitmap(myBitmap, MainActivity.x, MainActivity.y, null);
    }


/*    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {


    }*/

}