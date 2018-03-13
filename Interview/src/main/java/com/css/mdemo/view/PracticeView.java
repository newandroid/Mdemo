package com.css.mdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.css.mdemo.R;

/**
 * Created by Administrator on 2017/12/31.
 */

public class PracticeView extends View {
    private Paint paint = new Paint();
    private Path clipPath = new Path();

    public PracticeView(Context context) {
        super(context);
    }

    public PracticeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        clipPath.addCircle(300, 300, 100, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawPath(canvas);
//        drawRect(canvas);
        canvas.clipPath(clipPath);
        drawBitmap(canvas);

//        drawBitmapWithMatrix(canvas);
//        drawPathDemo(canvas);
    }

    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(200, 200, 100, paint);
    }

    private void drawArc(Canvas canvas) {
        canvas.drawArc(20, 20, 100, 100, 0, 270, true, paint);
        canvas.drawArc(new RectF(200, 200, 400, 400), -30, 70, false, paint);
    }

    private void drawARGB(Canvas canvas) {
        canvas.drawARGB(200, 1, 1, 255);
        canvas.drawColor(Color.GRAY);
        canvas.drawPaint(paint);
    }

    private void drawBitmap(Canvas canvas) {
        Bitmap bitmap = createBitmap();
//        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 20, 20, paint);

    }

    private void drawBitmapWithMatrix(Canvas canvas) {
        Matrix matrix = new Matrix();
        Matrix matrixB = new Matrix();
        matrix.setRotate(45);
        matrixB.setScale(2, 2);
//        matrix.setConcat(matrix, matrixB);
        matrix.postConcat(matrixB);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(createBitmap(), matrix, paint);
    }

    private void drawLines(Canvas canvas) {
        paint.setColor(Color.GREEN);
        canvas.drawLine(20, 20, 149, 149, paint);
    }

    private Bitmap createBitmap() {
        int size = 500 * 500;
        int[] colors = new int[size];
        for (int i = 0; i < size; i++) {
            colors[i] = Color.GREEN;
        }

//        Bitmap bitmap = Bitmap.createBitmap(colors, 500, 500, Bitmap.Config.RGB_565);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_img);
        return bitmap;

    }

    private void drawPath(Canvas canvas) {
        Path path = new Path();
        path.moveTo(200, 200);
        path.lineTo(500, 600);
        path.lineTo(500, 900);
//        path.quadTo(400, 400, 200, 700);
//        path.close();
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, paint);
    }

    private void drawPathDemo(Canvas canvas) {
        Path path = new Path();
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
        path.close();
//        path.quadTo(400, 400, 200, 700);
//        path.close();
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, paint);
    }

    private void drawRect(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(30);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawRect(200, 200, 400, 400, paint);
    }
}
