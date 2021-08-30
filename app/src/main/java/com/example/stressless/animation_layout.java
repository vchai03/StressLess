package com.example.stressless;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import static com.example.stressless.R.layout.activity_animation;

public class animation_layout extends SurfaceView implements Runnable{

    Thread thread = null;
    boolean canDraw = false;

    Bitmap background;
    Canvas canvas;
    SurfaceHolder surfaceHolder;

    Paint paint_fill;
    Paint paint_stroke;
    Path square;

    int circle_x, circle_y;
    int speed = 5;

    public animation_layout(Context context, AttributeSet attrs) {
        super(context, attrs);
        surfaceHolder = getHolder();
        background = BitmapFactory.decodeResource(getResources(), R.drawable.pastel_green);
        circle_x = 130;
        circle_y = 200;

    }


    public void run(){

        prepPaint();

        while(canDraw){

            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }

            canvas = surfaceHolder.lockCanvas();
            motionCircle();
            canvas.drawBitmap(background,0,0,null);
            drawSquare(130,200,950,1020);
            canvas.drawCircle(circle_x, circle_y, 30, paint_fill);
            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }

    private void drawSquare(int x1, int y1, int x2, int y2){

        square = new Path();
        square.moveTo(x1, y1);
        square.lineTo(x2, y1);
        square.moveTo(x2, y1);
        square.lineTo(x2, y2);
        square.moveTo(x2, y2);
        square.lineTo(x1, y2);
        square.moveTo(x1, y2);
        square.lineTo(x1, y1);

        this.canvas.drawPath(square, paint_stroke);
    }

    private void motionCircle(){

        if(circle_y == 200 && circle_x < 950) {
            circle_x = circle_x + speed;
            background = BitmapFactory.decodeResource(getResources(), R.drawable.pastel_green_inhale);
        }
        if(circle_y < 1020 && circle_x == 950) {
            circle_y = circle_y + speed;
            background = BitmapFactory.decodeResource(getResources(), R.drawable.pastel_green_exhale);
        }
        if(circle_y == 1020 && circle_x > 130) {
            circle_x = circle_x - speed;
            background = BitmapFactory.decodeResource(getResources(), R.drawable.pastel_green_inhale);
        }
        if(circle_y > 200 && circle_x == 130) {
            circle_y = circle_y - speed;
            background = BitmapFactory.decodeResource(getResources(), R.drawable.pastel_green_exhale);
        }
    }

    public void pause(){

        canDraw = false;
        circle_x = 130;
        circle_y = 200;

        while(true){
            try {
                thread.join();
                break;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void resume(){

        canDraw = true;
        thread = new Thread(this);
        thread.start();
    }

    private void prepPaint() {

        paint_fill = new Paint();
        paint_fill.setColor(getResources().getColor(R.color.pastelGreen));
        paint_fill.setStyle(Paint.Style.FILL);

        paint_stroke = new Paint();
        paint_stroke.setColor(getResources().getColor(R.color.pastelGreen));
        paint_stroke.setStyle(Paint.Style.STROKE);
        paint_stroke.setStrokeWidth(10);

    }

}

