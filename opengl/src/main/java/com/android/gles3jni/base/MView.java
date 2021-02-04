package com.android.gles3jni.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MView extends View {
    Paint paint = new Paint();

    {
        paint.setColor(Color.BLACK);
    }

    int realWidth = 1080;
    int realHeight = 1920;
    int fakeMinWidth = 9;
    int fakeMinHeight = 16;

    int r = realWidth / fakeMinWidth;

    public MView(Context context) {
        super(context);
    }

    public MView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        testEdge(canvas);
        //x line
//        mDrawLine(canvas, 0, 0, 8, 0);
        //y line
//        mDrawLine(canvas, 0, 0, 0, 15);

        //two x line
        mDrawLine(canvas, 0, 0, 8, 0);
        mDrawLine(canvas, 0, 1, 8, 1);
    }

    private void testEdge(Canvas canvas) {
        mDrawPoint(canvas, 0, 0);
        mDrawPoint(canvas, 8, 0);
        mDrawPoint(canvas, 0, 15);
        mDrawPoint(canvas, 8, 15);
    }

    private void mDrawPoint(Canvas canvas, int fakex, int fakey) {
        canvas.drawCircle(fakex * r + r / 2, fakey * r + r / 2, r / 2, paint);
    }

    private void mDrawLine(Canvas canvas, int fromX, int fromY, int toX, int toY) {

        for (int i = fromX; i < toX + 1; i++) {
            mDrawPoint(canvas, i, 0);
        }
        for (int i = fromY; i < toY + 1; i++) {
            mDrawPoint(canvas, 0, i);
        }
    }
}
