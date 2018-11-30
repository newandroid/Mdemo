package com.css.mdemo.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/1/12.
 */

public class MEclipseLoadingView extends View {
    private static final int ANI_TIME = 2000;

    private float centerX;
    private float centerY;
    private float radius;
    private Paint sunPaint;

    private float shadowOffset;
    private Path shadowPath;

    private AnimatorSet animatorSet;

    public MEclipseLoadingView(Context context) {
        super(context);
        init();
    }

    public MEclipseLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MEclipseLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        sunPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        animatorSet = new AnimatorSet();

        shadowPath = new Path();
    }

    private void initAni() {
        ValueAnimator moveValueAnimator = ValueAnimator.ofFloat(3 * centerX, centerX);
        moveValueAnimator.setDuration(ANI_TIME);
        moveValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                shadowOffset =
                        (float) animation.getAnimatedValue();
                invalidate();

            }
        });
        animatorSet.playSequentially(moveValueAnimator);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        radius = Math.min(centerX, centerY);
        initAni();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        shadowPath.reset();
        shadowPath.addCircle(shadowOffset, centerY, radius, Path.Direction.CW);
        canvas.clipPath(shadowPath);
        canvas.drawCircle(centerX, centerY, radius, sunPaint);

    }
}
