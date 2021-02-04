package css.com.applab.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import css.com.applab.R;

public class SimpleProgress extends View {

    private int progress = 88;
    private Paint outP = new Paint();
    private Paint contentP = new Paint();
    private float strokeWidth = 20f;


    public SimpleProgress(Context context) {
        super(context);
        init(null, 0);
    }

    public SimpleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public SimpleProgress(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {


        outP.setFlags(Paint.ANTI_ALIAS_FLAG);
        outP.setStyle(Paint.Style.STROKE);
        outP.setStrokeWidth(strokeWidth);
        outP.setColor(Color.parseColor("#ff0000"));
        contentP.setColor(Color.parseColor("#0000ff"));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        canvas.drawRect(strokeWidth, strokeWidth, contentWidth, contentHeight, outP);
        canvas.drawRect(strokeWidth, strokeWidth, contentWidth, contentHeight * progress / 100, contentP);
    }

}