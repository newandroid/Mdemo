package com.css.uilib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * create by css on 2019/1/17
 */
public class HelloWorldView extends View {
    Paint paint = new Paint();

    public HelloWorldView(Context context) {
        super(context);
    }

    public HelloWorldView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public HelloWorldView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String helloWorld = "Hello world!";
        paint.setTextSize(50);
        paint.setColor(Color.BLUE);
        float textWidth = paint.measureText(helloWorld);
        canvas.drawText(helloWorld, (getMeasuredWidth() - textWidth) / 2, getMeasuredHeight() / 2, paint);
    }
}
