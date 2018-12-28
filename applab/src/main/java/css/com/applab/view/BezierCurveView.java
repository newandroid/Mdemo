package css.com.applab.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BezierCurveView extends View {
    // 3 point 0,0 0.97,0.5 1,1
    //redesign 300*300 0,0 291,150 300,300
    //fake curve support point 280,10
    private Paint paint;
    private Paint paintPoint;
    private Path path;
    Point point;
    public BezierCurveView(Context context) {
        super(context);
        paint = new Paint();
        point = new Point(291,150);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        path = new Path();
        path.moveTo(0,0);
        path.quadTo(280,10,point.x,point.y);
        path.quadTo(point.x,point.y,300,300);

        paintPoint = new Paint();
        paintPoint.setColor(Color.RED);
    }

    public BezierCurveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BezierCurveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(600,900);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
        canvas.drawCircle(point.x,point.y,20,paintPoint);
    }
}
