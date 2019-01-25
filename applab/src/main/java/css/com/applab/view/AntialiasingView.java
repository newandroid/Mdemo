package css.com.applab.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import css.com.applab.R;

public class AntialiasingView extends View {
    private Paint paint;
    private Bitmap bitmap;
    int x;
    int y;

    public AntialiasingView(Context context) {
        super(context);
        init();
    }

    public AntialiasingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public AntialiasingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setFilterBitmap(true);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.circle_15_15);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setLayerType(LAYER_TYPE_SOFTWARE,paint);
        canvas.drawBitmap(bitmap, x, y, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();
        postInvalidate();
        return super.onTouchEvent(event);
    }
}
