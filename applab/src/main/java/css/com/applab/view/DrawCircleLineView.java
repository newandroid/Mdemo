package css.com.applab.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import css.com.applab.R;

public class DrawCircleLineView extends AppCompatImageView {
    Paint paint;
    int totalW;
    int totalH;
    float pointX;
    float pointY;

    public DrawCircleLineView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30);
        setBackgroundColor(Color.BLACK);
    }

    public DrawCircleLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircleLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View parentView = (View) getParent();
        totalW = parentView.getMeasuredWidth();
        totalH = parentView.getMeasuredHeight();
        setMeasuredDimension(totalW, totalH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(pointX, pointY, 20, paint);
        canvas.drawCircle(totalW / 2, totalW / 2, 20, paint);
        float ag = (float) Math.toDegrees(Math.atan2(pointY - totalW/2 , pointX-totalW/2));
        System.out.println("ag:" + ag);
        canvas.drawArc(0, 0, totalW, totalW, ag, 1, false, paint);
//        canvas.drawArc(0, 0, totalW, totalW, 0, 90, true, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        pointX = event.getX();
        pointY = event.getY();
        postInvalidate();
        return true;
    }
}
