package com.css.uilib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * create by css on 2019/1/17
 * 柱状图
 */
public class HistogramView extends View {
    String bgColor = "#556e7a";
    String histogramColor = "#73b829";

    RectF totalRectf = new RectF(100,100,600,500);
    public HistogramView(Context context) {
        super(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
