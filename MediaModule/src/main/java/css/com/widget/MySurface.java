package css.com.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2017/9/16.
 */

public class MySurface extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private int measureWith;
    private int measureHeight;

    private Paint linePaint;
    private SurfaceHolder mSurfaceHolder;
    private boolean isDrawing = true;

    private byte[] dataSource;
    private float[] maxFloat;

    public MySurface(Context context) {
        super(context);
        init();
    }

    public MySurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurface(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureWith = getMeasuredWidth();
        measureHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isDrawing = false;
    }

    @Override
    public void run() {
        while (isDrawing) {
            Canvas canvas = null;
            canvas = mSurfaceHolder.lockCanvas();
            if (canvas != null) {
                //把HSV的内容转化成color,其中alpha设置成0xff,hsv有三个成员，
                // hsv[0]的范围是[0,360),表示色彩，hsv[1]范围[0,1]表示饱和度，
                // hsv[2]范围[0,1]表示值，如果它们的值超出范围，那么它们会被截断成范围内的值。

                canvas.drawColor(Color.WHITE);
                if (maxFloat != null) {
                    canvas.drawColor(Color.HSVToColor(maxFloat));
                }

                if (dataSource == null || dataSource.length == 0) {
//                    canvas.drawLine(0,measureHeight/2,measureWith,measureHeight/2,linePaint);
                } else {
                    int length = dataSource.length;
                    int withSingle = (int) (measureWith * 1.0 / length);
                    for (int i = 0; i < dataSource.length; i++) {
//                        canvas.drawLine(i*withSingle,0+measureHeight/2,i*withSingle,dataSource[i]+measureHeight/2,linePaint);
                        canvas.drawLine(i * withSingle, 0, i * withSingle, dataSource[i] + Byte.MAX_VALUE, linePaint);
                    }
                }
                mSurfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void init() {
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setColor(Color.RED);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(5);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
    }

    public void setDataSource(byte[] data) {
        dataSource = data;
    }

    float lastMax = 0;

    //把HSV的内容转化成color,其中alpha设置成0xff,hsv有三个成员，
    // hsv[0]的范围是[0,360),表示色彩，hsv[1]范围[0,1]表示饱和度，
    // hsv[2]范围[0,1]表示值，如果它们的值超出范围，那么它们会被截断成范围内的值。
    public void setMaxFloat(byte max) {
        float maxh = (max + Byte.MAX_VALUE) * 1f / 256 * 360;
        if (maxh < lastMax) {
            maxh = (lastMax+maxh) / 2;
        }
        lastMax = maxh;
        maxFloat = new float[]{maxh, 1f, 1f};
    }

    public void setMaxFloat(int max) {
        maxFloat = new float[]{max, 1f, 1f};
    }
}
